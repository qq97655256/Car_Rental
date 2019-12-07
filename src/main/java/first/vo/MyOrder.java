package first.vo;

import first.pojo.OrderH;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class MyOrder {
    private List<OrderH> all;
    private Set<OrderH> set;
    private Integer totals;
    private Integer size;
}
