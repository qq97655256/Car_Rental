package first.service.impl;

import first.dao.CarMapper;
import first.dao.OrderHouMapper;
import first.pojo.Car;
import first.pojo.OrderH;
import first.pojo.Page;
import first.pojo.User;
import first.service.CarService;
import first.service.OrderHService;
import first.service.UserService;
import first.utils.MyPage;
import first.vo.MyOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderHServiceImpl implements OrderHService {
    @Autowired
    private OrderHouMapper orderHouMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private CarService carService;

    @Override
    public MyOrder allOrder(Page page) {//分页查订单
        MyOrder myOrder = new MyOrder();
        int totals = orderHouMapper.totals().size();
        Page page1 = MyPage.myPage1(totals, page);
        List<OrderH> all = orderHouMapper.allOrder(page1);
        myOrder.setAll(all);
        myOrder.setTotals(totals);
        return myOrder;
    }

    @Override
    public Integer updateByOid(OrderH orderH) {//修改立即还车

        return orderHouMapper.updateByOid(orderH);
    }

    @Override
    public Integer updateByOid2(OrderH orderH) {//修改
        String tel = orderH.getTel();
        String cacard = orderH.getCacard();
        Car car = new Car();
        car.setCacard(cacard);
        List<Car> all = carService.findOneByTel(car);
        User one = userService.findOne(tel);
        if (one != null && all.size() == 1) {
            orderH.setUid(one.getUid());
            orderH.setCaid(all.get(0).getCaid());
            return orderHouMapper.updateByOid(orderH);
        }
        return 3;
    }

    @Override
    public Object updateByOid1(OrderH orderH) { //完成订单
        Double money = orderH.getMoney();
        Double yujiao = orderH.getYujiao();
        Double cc = money - yujiao;
        Integer caid = orderH.getCaid();
        Car car = new Car();
        car.setCaid(caid);
        List<Car> all = carService.findOneByTel(car);
        if (all.size() == 1) {
            Integer uid = all.get(0).getUid();
            Double sal = all.get(0).getSal();
            //System.out.println(sal+"%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            User user = new User();
            user.setUid(uid);
            user.setSal((money+sal));
            Integer aa = userService.updateById(user);
            if (aa == 1) {
                Integer zhuang = orderH.getOid();

                OrderH h = new OrderH();
                h.setZhuang(1);
                h.setOid(zhuang);
                Integer wan = orderHouMapper.updateByOid(h);
                if (wan == 1) {
                    return cc;
                } else {
                    return "提交失败";
                }

            } else {
                return "车辆信息有误";
            }

        }
        return "车辆信息有误";
    }

    @Override
    public List<OrderH> findByTel(String tel) {//模糊查询订单
        return orderHouMapper.findByTel(tel);
    }
    @Override
    public List<OrderH> findByOid(String tel) {//模糊查询订单
        return orderHouMapper.findByOid(tel);
    }

    @Override
    public Integer delByOid(Integer oid) {//删除
        return orderHouMapper.delByOid(oid);
    }

    @Override
    public Integer add(OrderH orderH) {//增加
        String tel = orderH.getTel();
        String cacard = orderH.getCacard();
        Car car = new Car();
        car.setCacard(cacard);
        List<Car> all = carService.findOneByTel(car);
        User one = userService.findOne(tel);

        if (one != null && all != null) {
            orderH.setUid(one.getUid());
            orderH.setCaid(all.get(0).getCaid());
        } else {
            return 3;
        }
        //System.out.println(orderH);
        return orderHouMapper.add(orderH);
    }
}
