package first.service.impl;

import first.dao.UserMapper;
import first.pojo.Page;
import first.pojo.Quan;
import first.pojo.User;
import first.repository.UserRepository;
import first.service.UserService;
import first.utils.MyPage;
import first.vo.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserRepository userRepository;

    @Override
    public MyUser all(Page page) {//hx 分页查询用户
        MyUser myUser = new MyUser();
        Integer totals = userMapper.totals().size();
        Page page1 = MyPage.myPage1(totals, page);
        List<User> all = userMapper.all(page1);
        System.out.println(all);
        HashSet<User> set = new HashSet<>();
        for (User u : all) {
            set.add(u);
        }
        System.out.println(all);
        myUser.setAll(set);
        myUser.setTotals(totals);
        return myUser;
    }

    @Override
    public Integer updateById(User user) {//hx 修改用户

        return userMapper.updateById(user);
    }

    @Override
    public List<Quan> findQuan(String tel) {//hx 查用户权限

        return userMapper.findQuan(tel);
    }

    @Override
    public User findOne(String tel) {//hx 查一个用户
        return userMapper.findOne(tel);
    }

    @Override
    public User addUser(String tel) {//增加用户
        User user = new User();
        user.setTel(tel);
        user.setPass("123456");
        user.setUstatus(1);
        Integer zai = userMapper.addUser(user);
        if (zai == 1) {
            return this.findOne(tel);
        }

        return null;
    }

    @Override
    public Integer juese(User user) {//修改角色

        return userMapper.juese(user);
    }

    @Override
    public Integer addJue(User user) {//增加角色

        return userMapper.addJue(user);
    }
}
