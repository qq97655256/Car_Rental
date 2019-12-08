package first.service;

import first.pojo.Details;
import first.pojo.User;
import first.pojo.User1;

import java.util.List;

public interface CenterService {
    User1 findone(Integer uid);

    String updatebankcard(User user);

    String delbankcard(Integer uid);

    String updatemess(User user);

    List<Details> findmycar(Integer uid);

    String deletecar(Integer caid);

    String updatesal(Integer num,Integer uid);
}
