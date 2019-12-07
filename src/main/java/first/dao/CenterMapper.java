package first.dao;

import first.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CenterMapper {

    public int updatebankcard(User user);

    int delbankcard(Integer uid);

    int updatemess(User user);
}
