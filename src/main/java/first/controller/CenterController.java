package first.controller;

import first.pojo.Details;
import first.pojo.User;
import first.pojo.User1;
import first.service.CenterService;
import first.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/*
* 个人中心所有方法的控制层
* */
@RestController
public class CenterController {

    @Autowired
    CenterService centerService;
    @Value("${qiniu.url}")
    private  String url;

    @Autowired
    private UploadUtils up;


    @RequestMapping(value = "/personalCenter",method = RequestMethod.POST)
    public User1 personalCenter(HttpServletRequest request){

        User userr = (User)request.getSession().getAttribute("user");
        System.out.println(userr.getUid());
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

    @RequestMapping("/addmoney/{num}/{uid}")
    public String addmoney(@PathVariable("num")Integer num,@PathVariable("uid")Integer uid){

        System.out.println(num);
        return centerService.updatesal(num,uid);
    }
    @RequestMapping("/updatemess1")
    public String updatemess1(@RequestBody User user,@RequestParam("file") MultipartFile muli){
        System.out.println(user);
        System.out.println(muli);

        String upload = up.upload(muli);
        user.setUph(url+upload);

        return centerService.updatemess(user);
    }
}
