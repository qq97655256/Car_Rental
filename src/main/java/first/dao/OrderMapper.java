package first.dao;

import first.pojo.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    public  int add(Order order);
}
