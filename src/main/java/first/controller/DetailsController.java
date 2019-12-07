package first.controller;

import first.pojo.Details;
import first.pojo.Tu;
import first.pojo.User;
import first.service.DetailsService;
import first.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class DetailsController {
@Autowired
    private DetailsService detailsService;
@Autowired
private UploadUtils uploadUtils;
@Value("${qiniu.url}")
private String url;

//点击提交
@RequestMapping("/InsertDetails")
    public String InsertDetails(@RequestBody Details details, HttpServletRequest request){
    Object user = request.getSession().getAttribute("user");
    if (user instanceof User){
        User user1=(User) user;
        System.out.println(user1.getUid());
        try{
            details.setUid(user1.getUid());
            detailsService.UpdateById(details);
            return "提交成功";
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    return "提交失败";
}


//点击取消
@RequestMapping("/quxiao/{caid}")
public int quxiao(@PathVariable("caid") Integer caid){
    try{
        detailsService.quxiao(caid);
        return 1;
    }catch (Exception e){
        e.printStackTrace();
    }
    return 0;

}


//上传图片
@RequestMapping(value = "/tupian",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public Integer tupian(@RequestParam("file") MultipartFile[] multipartFile){
    Details details = new Details();
   if (multipartFile.length<6){
           if (multipartFile.length==1){
               String upload = uploadUtils.upload(multipartFile[0]);
               details.setPh1(url+upload);
               details.setPh2("1");
               details.setPh3("2");
               details.setPh4("3");
               details.setPh5("4");
               details.setPh6("5");
               Integer integer = detailsService.InsertDetails(details);
               if (integer==1){
                   System.out.println("success");
               }else {
                   System.out.println("fail");
               }
               String pic=url+upload;
               details = detailsService.SelectId(pic);
           }else if (multipartFile.length==2){
               String upload = uploadUtils.upload(multipartFile[0]);
               String upload1 = uploadUtils.upload(multipartFile[1]);
               details.setPh1(url+upload);
               details.setPh2(url+upload1);
               details.setPh3("2");
               details.setPh4("3");
               details.setPh5("4");
               details.setPh6("5");
               Integer integer = detailsService.InsertDetails(details);
               if (integer==1){
                   System.out.println("success");
               }else {
                   System.out.println("fail");
               }
               String pic=url+upload;
               details = detailsService.SelectId(pic);
           }else if (multipartFile.length==3){
               String upload = uploadUtils.upload(multipartFile[0]);
               String upload1 = uploadUtils.upload(multipartFile[1]);
               String upload2 = uploadUtils.upload(multipartFile[2]);
               details.setPh1(url+upload);
               details.setPh2(url+upload1);
               details.setPh3(url+upload2);
               details.setPh4("3");
               details.setPh5("4");
               details.setPh6("5");
               Integer integer = detailsService.InsertDetails(details);
               if (integer==1){
                   System.out.println("success");
               }else {
                   System.out.println("fail");
               }
               String pic=url+upload;
               details = detailsService.SelectId(pic);
           }else if (multipartFile.length==4){
               String upload = uploadUtils.upload(multipartFile[0]);
               String upload1 = uploadUtils.upload(multipartFile[1]);
               String upload2 = uploadUtils.upload(multipartFile[2]);
               String upload3 = uploadUtils.upload(multipartFile[3]);
               details.setPh1(url+upload);
               details.setPh2(url+upload1);
               details.setPh3(url+upload2);
               details.setPh4(url+upload3);
               details.setPh5("4");
               details.setPh6("5");
               Integer integer = detailsService.InsertDetails(details);
               if (integer==1){
                   System.out.println("success");
               }else {
                   System.out.println("fail");
               }
               String pic=url+upload;
               details = detailsService.SelectId(pic);
           }else if (multipartFile.length==5){
               String upload = uploadUtils.upload(multipartFile[0]);
               String upload1 = uploadUtils.upload(multipartFile[1]);
               String upload2 = uploadUtils.upload(multipartFile[2]);
               String upload3 = uploadUtils.upload(multipartFile[3]);
               String upload4 = uploadUtils.upload(multipartFile[4]);
               details.setPh1(url+upload);
               details.setPh2(url+upload1);
               details.setPh3(url+upload2);
               details.setPh4(url+upload3);
               details.setPh5(url+upload4);
               details.setPh6("5");
               Integer integer = detailsService.InsertDetails(details);
               if (integer==1){
                   System.out.println("success");
               }else {
                   System.out.println("fail");
               }
               String pic=url+upload;
               details = detailsService.SelectId(pic);
           }
   }else if (multipartFile.length==6){
       String upload = uploadUtils.upload(multipartFile[0]);
       String upload1 = uploadUtils.upload(multipartFile[1]);
       String upload2 = uploadUtils.upload(multipartFile[2]);
       String upload3 = uploadUtils.upload(multipartFile[3]);
       String upload4 = uploadUtils.upload(multipartFile[4]);
       String upload5 = uploadUtils.upload(multipartFile[5]);
       details.setPh1(url+upload);
       details.setPh2(url+upload1);
       details.setPh3(url+upload2);
       details.setPh4(url+upload3);
       details.setPh5(url+upload4);
       details.setPh6(url+upload5);
       Integer integer = detailsService.InsertDetails(details);
       if (integer==1){
           System.out.println("success");
       }else {
           System.out.println("fail");
       }
       String pic=url+upload;
       details = detailsService.SelectId(pic);
   }else {

   }
    return details.getCaid();
}
@RequestMapping("/shangc")
    public String sahngc(@RequestParam("file") MultipartFile multipartFile){
    System.out.println(multipartFile.getOriginalFilename());
    return "";
}
}
