package first.controller;

import first.pojo.Brand_r;
import first.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/owner")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;
//查询owner页面中的第一个选框
    @RequestMapping("/brand")
    private List<Brand_r> FindAll(){
        List<Brand_r> brand_rs = ownerService.FindAll();
        return brand_rs;
    }

}
