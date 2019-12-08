package first.service.impl;

import first.dao.CenterMapper;
import first.pojo.Details;
import first.pojo.User;
import first.pojo.User1;
import first.repository.DetailsRepository;
import first.repository.User1Repository;
import first.repository.UserRepository;
import first.service.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CenterServiceImpl implements CenterService {

    @Autowired
    User1Repository userRepository;

    @Autowired
    CenterMapper centerMapper;

    @Autowired
    DetailsRepository detailsRepository;



    @Override
    public User1 findone(Integer uid) {

        Optional<User1> byId = userRepository.findById(uid);
        if(byId.isPresent()){
            return byId.get();
        }
        return null;
    }

    @Override
    public String updatebankcard(User user) {

        int i=centerMapper.updatebankcard(user);
        if(i==1)
            return "修改成功";
        return "修改失败";
    }

    @Override
    public String delbankcard(Integer uid) {

        int i=centerMapper.delbankcard(uid);
        System.out.println("zhuxiaochengogng");
        if(i==1)
            return "注销成功";
        return "注销失败";
    }

    @Override
    public String updatemess(User user) {
        int i=centerMapper.updatemess(user);

        if(i==1)
            return "修改成功";
        return "修改失败";
    }

    @Override
    public List<Details> findmycar(Integer uid) {

     return   detailsRepository.findByUid(uid);
    }

    @Override
    public String deletecar(Integer caid) {

        detailsRepository.deleteById(caid);

        return "删除成功";
    }

    @Override
    public String updatesal(Integer num ,Integer uid) {

        int i=centerMapper.updatesal(Double.valueOf(num),uid);

        System.out.println(i);
        if(i==1)
            return "充值成功";
        return "充值失败";
    }

}

