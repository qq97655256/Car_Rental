package first.dao;

import first.pojo.Page;
import first.pojo.Quan;
import first.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> all(Page page);//hx 查全部用户以及角色

    List<User> totals();//hx 查全部用户表所有条数

    Integer updateById(User user);//hx 修改用户

    Integer juese(User user);//hx 修改角色

    List<Quan> findQuan(String tel);//查用户权限

    User findOne(String tel);//查用户

    Integer addJue(User user);//增加角色
    Integer addUser(User user);//增加用户
}
