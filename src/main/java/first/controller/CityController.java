package first.controller;

import first.pojo.Area;
import first.pojo.City;
import first.service.CityServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityController {
    @Autowired
    private CityServcie cityServcie;
    @RequestMapping("/SelectCity")
    public List<City> SelectCity(){
      return cityServcie.SelectCity();
    }
    @RequestMapping("/SelectAreaByCname/{cname}")
    public List<Area> SelectAreaByCname(@PathVariable("cname") String cname){
      return   cityServcie.SelectAreaByCname(cname);
    }
}
