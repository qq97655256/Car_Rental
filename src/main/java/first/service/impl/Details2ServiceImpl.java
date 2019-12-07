package first.service.impl;

import first.pojo.Details;
import first.repository.DetailsRepository;
import first.service.Details2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Details2ServiceImpl implements Details2Service {
    @Autowired
    private DetailsRepository dr;
    @Override
    public Details selectById(Integer caid) {
        Optional<Details> byId = dr.findById(caid);
        Details details=null;
        if (byId.isPresent()){
             details = byId.get();
        }
        return details;
    }
}
