package first.service.impl;

import first.pojo.Cartype;
import first.repository.OwnerRepositoryCartype;
import first.service.OwnerServiceCartype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerServiceCartypeImpl implements OwnerServiceCartype {
    @Autowired
    private OwnerRepositoryCartype ownerRepositoryCartype;
    @Override
    public List<Cartype> findByRid(Integer rid) {
        List<Cartype> byRid = ownerRepositoryCartype.findByRid(rid);
        return byRid;
    }
}
