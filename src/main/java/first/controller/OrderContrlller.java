package first.controller;

import first.pojo.Order;
import first.service.OrderService;
import first.utils.Od;
import first.utils.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

@RestController
@RequestMapping("/order")
public class OrderContrlller {
    @Autowired
    private OrderService os;

    @RequestMapping("/count")
    public Time count(@RequestBody Od od) {
        Date qu = od.getQu();
        Date jiao = od.getJiao();
        Double price = od.getPrice();
        long time1 = qu.getTime();
        long time2 = jiao.getTime();
        long time3 = time2 - time1;
        long l = time3 / (1000 * 60 * 60 * 24);
        Double price1 = l * price;
        System.out.println(price1);
        Time t = new Time();
        t.setPrice(price1);
        t.setDays(l);
        return t;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestBody Order od) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parse = sf.parse(sf.format(new Date()));
            od.setXia(parse);
        }catch (Exception e){
            e.printStackTrace();
        }
        od.setZhuang(1);
        od.setUid(1);
        System.out.println(od);
        os.add(od);
        return "yes";
    }
}
