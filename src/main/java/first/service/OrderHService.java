package first.service;

import first.pojo.OrderH;
import first.pojo.Page;
import first.vo.MyOrder;

import java.util.List;

public interface OrderHService {
    MyOrder allOrder(Page page);

    Integer updateByOid(OrderH orderH);

    Integer delByOid(Integer oid);

    Integer add(OrderH orderH);
    Integer updateByOid2(OrderH orderH);//修改

    Object updateByOid1(OrderH orderH);//完成订单

    List<OrderH> findByTel(String tel);

    List<OrderH> findByOid(String tel);
}
