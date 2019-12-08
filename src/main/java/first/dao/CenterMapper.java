package first.dao;

import first.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CenterMapper {

    public int updatebankcard(User user);

    int delbankcard(Integer uid);

    int updatemess(User user);

    int updatesal(@Param("sal") Double num, @Param("uid") Integer uid);
}
