package first.dao;

import first.pojo.Car;
import first.pojo.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CarMapper {
    List<Car> allCar(Page page);//hx 查车
    List<Car> totals();//hx 查车信息总条数

    Integer updateByCaid(Car car);//hx 修改车信息
    Integer delByCaid(Integer caid);//hx 删除车
    List<Car> findOneByTel(Car car);//hx 查车

}
