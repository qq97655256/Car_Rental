package first.vo;

import first.pojo.Car;
import lombok.Data;

import java.util.List;

@Data
public class MyCar {
    private  List<Car> all;
    private Integer totals;
}
