package first.controller;

import first.pojo.Details;
import first.pojo.User;
import first.pojo.User1;
import first.service.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/*
* 个人中心所有方法的控制层
* */
@RestController
public class CenterController {

    @Autowired
    CenterService centerService;

    @RequestMapping(value = "/personalCenter",method = RequestMethod.POST)
    public User1 personalCenter(HttpServletRequest request){

        User userr = (User)request.getSession().getAttribute("user");

        User1 loginuser=centerService.findone(userr.getUid());
        System.out.println(loginuser);
        return loginuser;
    }

    @RequestMapping("/addbankcard")
    public String addbankcard(@RequestBody User user){


        return centerService.updatebankcard(user);
    }

    @RequestMapping("/delbankcard")
    public String delbankcard(@RequestBody User user){
        return centerService.delbankcard(user.getUid());
    }

    @RequestMapping("/updatemess")
    public String updatemess(@RequestBody User user){
        System.out.println(user);
        return centerService.updatemess(user);
    }

    @RequestMapping("/findmycar")
    public List<Details> findmycar(@RequestBody User user){


        return centerService.findmycar(user.getUid());
    }

    @RequestMapping("/deletecar/{caid}")
    public String deletecar(@PathVariable("caid")Integer caid){
        return centerService.deletecar(caid);
    }

}
