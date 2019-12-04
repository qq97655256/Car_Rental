package first.service.impl;

import first.pojo.Details;
import first.repository.DetailsRepository;
import first.service.DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DetailsServiceImpl implements DetailsService {
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
