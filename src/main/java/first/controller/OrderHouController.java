package first.controller;

import first.pojo.OrderH;
import first.pojo.Page;
import first.service.OrderHService;
import first.vo.MyOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/orderh")
public class OrderHouController {
    @Autowired
    private OrderHService orderHService;

    @RequestMapping("/all")
    public MyOrder allOrder(Page page) {//查询订单
        MyOrder myOrder = orderHService.allOrder(page);
        return myOrder;
    }

    @RequestMapping("/up")
    public Integer updateByOid(@RequestBody OrderH orderH) {//立即还车

        Date shi = orderH.getShi();
        Date qu = orderH.getQu();
        if (shi == null) {
            shi = new Date();
            orderH.setShi(shi);
            long hh = 60 * 60 * 1000;
            Long str = qu.getTime();
            Long end = shi.getTime();
            Long cc = end - str;
            Integer sss = (int) (cc / hh);
            orderH.setYong(sss);
            Integer day = sss / 24;
            orderH.setMoney((sss % 24 == 0 ? day : (day + 1)) * orderH.getPrice());
        } else {
            return 3;
        }
        Integer ss = orderHService.updateByOid(orderH);
        return ss;
    }

    @RequestMapping("/xiu")
    public Integer updateByOid2(@RequestBody OrderH orderH) {//修改


        return orderHService.updateByOid(orderH);
    }

    @RequestMapping("/over")
    public Object over(@RequestBody OrderH orderH) {//完成订单


        return orderHService.updateByOid1(orderH);
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public Integer del(@RequestBody OrderH orderH) {//查询订单

        return orderHService.delByOid(orderH.getOid());
    }

    @RequestMapping("/add")
    public Integer add(@RequestBody OrderH orderH) {//查询订单
        //System.out.println(orderH);

        return orderHService.add(orderH);
    }

    @RequestMapping("/findT")
    public MyOrder findByTel(String tel) {//电话模糊查询查询订单
        tel = tel + "%";
        List<OrderH> byTel = orderHService.findByTel(tel);
        List<OrderH> byOid = orderHService.findByOid(tel);
        for (OrderH o : byOid) {
            byTel.add(o);
        }
        HashSet<OrderH> set=new HashSet<>();
        for (OrderH ss:byTel ){
            set.add(ss);
        }
        MyOrder myOrder = new MyOrder();
         myOrder.setTotals(set.size());
         myOrder.setSet(set);
        myOrder.setSize(set.size());
        return myOrder;
    }
}
