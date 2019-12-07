package first.service;

import first.pojo.Car;
import first.pojo.Page;
import first.vo.MyCar;

import java.util.List;

public interface CarService {
    MyCar allCar(Page page);//hx 后台查全部车辆

    Integer updateByCaid(Car car);//hx 修改车辆信息
    Integer delByCaid(Integer caid);//hx 删除车
    List<Car> findOneByTel(Car car);//查车
}
