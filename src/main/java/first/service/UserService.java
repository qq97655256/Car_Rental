package first.service;

import first.pojo.Page;
import first.pojo.Quan;
import first.pojo.User;
import first.vo.MyUser;

import java.util.List;
    public interface UserService {
        MyUser all(Page page);//hx 分页查询用户
        Integer updateById(User user);//hx 修改用户
        List<Quan> findQuan(String tel);//查用户权限
        User findOne(String tel);//
        User addUser(String tel);//
        Integer juese(User user);//修改角色

        Integer addJue(User user);


}
