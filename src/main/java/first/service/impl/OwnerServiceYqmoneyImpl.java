package first.service.impl;

import first.pojo.Yqmoney;
import first.repository.OwnerRepositoryYqmoney;
import first.service.OwnerServiceYqmoney;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OwnerServiceYqmoneyImpl implements OwnerServiceYqmoney {
    @Autowired
    private OwnerRepositoryYqmoney ownerRepositoryYqmoney;
    @Override
    public List<Yqmoney> findByDid(Integer did) {
        List<Yqmoney> byDid = ownerRepositoryYqmoney.findByDid(did);
        return byDid;
    }
}
