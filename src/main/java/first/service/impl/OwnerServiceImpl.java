package first.service.impl;

import first.pojo.Brand_r;
import first.pojo.Cartype;
import first.repository.OwnerRepository;
import first.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;

    public List<Brand_r> FindAll(){
        List<Brand_r> all = ownerRepository.findAll();
        return all;
    }




}
