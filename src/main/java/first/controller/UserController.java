package first.controller;

import first.pojo.Page;
import first.pojo.Quan;
import first.pojo.User;
import first.service.UserService;
import first.utils.RandNum;
import first.utils.SendTelMsgUtils;
import first.vo.MyCode;
import first.vo.MyUser;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.hibernate.query.criteria.internal.predicate.IsEmptyPredicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sun.invoke.empty.Empty;

import javax.servlet.http.HttpSession;
import javax.sound.midi.Soundbank;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/all")
    public MyUser allUser(Page page) {// hx 后台查询全部用户

        return userService.all(page);
    }

    @RequestMapping("/up")
    public Integer updateById(@RequestBody User user/*,@RequestBody MultipartFile file*/) {// hx 后台修改用户


        return userService.updateById(user);
    }

    @RequestMapping("/login")
    public Integer login(@RequestBody User user, HttpSession session) {//后台登陆
        List<Quan> quan = userService.findQuan(user.getTel());

        for (Quan q : quan) {
            if ("two".equals(q.getQname()) || "there".equals(q.getQname())) {

                Subject subject = SecurityUtils.getSubject();
                UsernamePasswordToken token = new UsernamePasswordToken(user.getTel(), user.getPass());
                try {
                    subject.login(token);
                } catch (Exception e) {
                    return 0;
                }
                User one = userService.findOne(user.getTel());
                session.setAttribute("user", one);
                return 1;
            }
        }


        return 3;
    }

    @RequestMapping(value = "/login1",method = RequestMethod.POST)
    public Integer login1(@RequestBody User user, HttpSession session) {//前台登陆
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getTel(), user.getPass());
        try {
            subject.login(token);
        } catch (Exception e) {
            return 0;
        }
        User one = userService.findOne(user.getTel());
        session.setAttribute("user", one);
        return 1;
    }

    @RequestMapping("/rr")
    public Integer updateJue(@RequestBody User user) {//修改角色

        return userService.juese(user);
    }

    @RequestMapping(value = "/code", method = RequestMethod.GET)
    public void getCode(String tel, HttpSession session) {//获取验证码
        System.out.println(tel);
        MyCode myCode = new MyCode();
        String code = RandNum.createRandNum();
        myCode.setStartTime(new Date());
        myCode.setCode(code);
        session.removeAttribute(tel);
        session.setAttribute(tel, myCode);
        SendTelMsgUtils.sendMsgTo(tel, code);
    }

    @RequestMapping(value = "/loginCode",method = RequestMethod.GET)
    public Object loginCode(String tel, String code, HttpSession session) {//验证码登陆
        MyCode myCode = (MyCode) session.getAttribute(tel);
        User one = userService.findOne(tel);
        System.out.println(myCode);
        if (myCode != null && one != null) {
            Long cha = new Date().getTime() - myCode.getStartTime().getTime();
            if (cha < 60 * 3 * 1000) {

                if (code.equals(myCode.getCode())) {
                    Subject subject = SecurityUtils.getSubject();
                    UsernamePasswordToken token = new UsernamePasswordToken(one.getTel(), one.getPass());
                    subject.login(token);
                    session.setAttribute("user", one);
                    return "登陆成功";
                } else {
                    return "验证码输入有误";
                }


            } else {
                return "您的验证码已过期";
            }

        }
        return "您还未获取验证码或尚未注册";
    }

    @RequestMapping("/resCode")
    public Object zhuCode(String tel, String code, HttpSession session) {//验证码注册

        User one = userService.findOne(tel);

        MyCode myCode = (MyCode) session.getAttribute(tel);
        System.out.println(myCode);
        if (myCode != null && one == null) {
            Long cha = new Date().getTime() - myCode.getStartTime().getTime();
            if (cha < 60 * 3 * 1000) {

                if (code.equals(myCode.getCode())) {
                    User user = userService.addUser(tel);

                    if (user != null) {
                        user.setRid(1);
                        Integer jue = userService.addJue(user);
                        Subject subject = SecurityUtils.getSubject();
                        UsernamePasswordToken token = new UsernamePasswordToken(user.getTel(), user.getPass());
                        subject.login(token);
                        session.setAttribute("user", user);
                        return "注册成功";
                    } else {
                        return "注册失败";
                    }

                } else {
                    return "验证码输入有误";
                }


            } else {
                return "您的验证码已过期";
            }
        }

        return "您还未获取验证码或已经注册";
    }

}