package first.dao;

import first.pojo.OrderH;
import first.pojo.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface OrderHouMapper {
    List<OrderH> allOrder(Page page);
    List<OrderH> totals();

    Integer updateByOid(OrderH orderH);

    Integer delByOid(Integer oid);

    Integer add(OrderH orderH);

    List<OrderH> findByTel(String tel);

    List<OrderH> findByOid(String tel);
}
