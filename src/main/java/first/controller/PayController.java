package first.controller;

import com.alipay.api.AlipayApiException;
import first.utils.AlipayUtils;
import first.utils.Od;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayController {
    @Autowired
    private AlipayUtils alipayUtils;

    @RequestMapping(value = "/pay",method = RequestMethod.POST)
    public String pay(@RequestBody Od od){
        String pay="";
        try {
          // Od od = new Od();
            pay = alipayUtils.pay(od);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        System.out.println(pay);
        return pay;
    }
}
