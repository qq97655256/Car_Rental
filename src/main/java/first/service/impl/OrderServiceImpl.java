package first.service.impl;

import first.dao.OrderMapper;
import first.pojo.Order;
import first.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper om;


    @Override
    public int add(Order order) {
        return om.add(order);
    }
}

