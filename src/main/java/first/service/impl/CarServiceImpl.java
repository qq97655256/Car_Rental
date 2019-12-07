package first.service.impl;

import first.dao.CarMapper;
import first.pojo.Car;
import first.pojo.Page;
import first.pojo.User;
import first.service.CarService;
import first.service.UserService;
import first.utils.MyPage;
import first.vo.MyCar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarMapper carMapper;
    @Autowired
    private UserService userService;

    @Override
    public MyCar allCar(Page page) {//  hx 分页查车
        MyCar myCar = new MyCar();
        Integer totals = carMapper.totals().size();
        Page page1 = MyPage.myPage1(totals, page);

        myCar.setAll(carMapper.allCar(page1));

        myCar.setTotals(totals);

        return myCar;
    }

    @Override
    public Integer updateByCaid(Car car) {
        Integer pid1 = car.getPid1();
        if(pid1!=null){
            car.setPid(pid1);
        }
        String tel=car.getTel();
        User one = userService.findOne(tel);
        if(one!=null){
            car.setUid(one.getUid());
            return carMapper.updateByCaid(car);
        }
        return 0;
    }

    @Override
    public Integer delByCaid(Integer caid) {
        return carMapper.delByCaid(caid);
    }

    @Override
    public List<Car> findOneByTel(Car car){
        return carMapper.findOneByTel(car);
    }
}
