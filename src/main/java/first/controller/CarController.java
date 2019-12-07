package first.controller;


import first.pojo.Car;
import first.pojo.Page;
import first.service.CarService;
import first.vo.MyCar;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;
    @RequiresPermissions(value = {"there","two"})
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public MyCar allCar(Page page) {//hx 后台查全部车

        return carService.allCar(page);
    }
    @RequiresPermissions(value = {"there","two"})
    @RequestMapping(value = "/up",method = RequestMethod.POST)
    public Integer updateCar(@RequestBody Car car) {//hx 后台修改车信息
        System.out.println(car);
        return carService.updateByCaid(car);
    }
    @RequiresPermissions(value = {"there","two"})
    @RequestMapping(value = "/del",method = RequestMethod.POST)
    Integer delByCaid(@RequestBody Car car) {//hx 后台删除车
        System.out.println(car.getCaid());
        return carService.delByCaid(car.getCaid());
    }
    @RequiresPermissions(value = {"there","two"})
    @RequestMapping(value = "/tel",method = RequestMethod.POST)
    public MyCar findOne(Car car) {//hx 后台删除车
        MyCar myCar = new MyCar();
        List<Car> all = carService.findOneByTel(car);
        myCar.setAll(all);
        myCar.setTotals(all.size());
        return myCar;
    }
    @RequiresPermissions(value = {"there","two"})
    @RequestMapping("/tel2")
    public MyCar findOne2(Car car) {//hx 后台删除车
        MyCar myCar = new MyCar();
        List<Car> all = carService.findOneByTel(car);
        myCar.setAll(all);
        myCar.setTotals(all.size());
        return myCar;
    }
}
