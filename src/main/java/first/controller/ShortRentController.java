package first.controller;

import first.pojo.Area;
import first.pojo.Brand;
import first.pojo.Details;
import first.response.DetailsResponse;
import first.response.ShortRentResponse;
import first.service.AreaService;
import first.service.BrandService;
import first.service.DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
@RestController
public class ShortRentController {
    @Autowired
    private BrandService brandService;
    @Autowired
    private DetailsService detailsService;
    @Autowired
    private AreaService areaService;
    @RequestMapping("/shortrent/{page}/{size}")
    public ShortRentResponse SelectBrand(@PathVariable("page") Integer page,@PathVariable("size") Integer size){
        ShortRentResponse shortRentResponse=new ShortRentResponse();
        List<Brand> brands = brandService.SelectBrand();
        List<Details> details = detailsService.SelectCarName();
        DetailsResponse detailsResponse = detailsService.SelectCar(page, size);
        List<Area> areas = areaService.SelectArea();
        shortRentResponse.setArea(areas);
        shortRentResponse.setBrand(brands);
        shortRentResponse.setCarName(details);
        shortRentResponse.setDetailsResponse(detailsResponse);
        return shortRentResponse;
    }

    @RequestMapping( "/selectCar/{pname}")
    public List<Details> selectCar(@PathVariable("pname") String pname) throws UnsupportedEncodingException {
        System.out.println(pname);
        return detailsService.SelectCarByName(pname);
    }

    @RequestMapping("/SelectBrand/{rname}")
    public List<Details> SelectBrand(@PathVariable("rname") String rname){
        return detailsService.SelectBrand(rname);
    }
    @RequestMapping("/SelectHot/{caname}")
    public List<Details> SelectHot(@PathVariable("caname") String caname){
        return detailsService.SelectHot(caname);
    }
    @RequestMapping("/SelectByMoney")
    public List<Details> SelectByMoney(){
return detailsService.SelectByMoney();
    }
    @RequestMapping("/SelectByMoney2")
    public List<Details> SelectByMoney2(){
        return detailsService.SelectByMoney2();
    }
    @RequestMapping("/SelectByZuCi")
    public List<Details> SelectByZuCi(){
        return detailsService.SelectByZuCi();
    }
}
