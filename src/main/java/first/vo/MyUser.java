package first.vo;

import first.pojo.User;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class MyUser {
    private Set<User> all;

    private Integer totals;
}
