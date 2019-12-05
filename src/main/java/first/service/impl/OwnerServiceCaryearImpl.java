package first.service.impl;

import first.pojo.Caryear;
import first.repository.OwnerRepositoryCaryear;
import first.service.OwnerServiceCaryear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerServiceCaryearImpl implements OwnerServiceCaryear {
    @Autowired
    private OwnerRepositoryCaryear ownerRepositoryCaryear;
    @Override
    public List<Caryear> findByKid(Integer kid) {
        List<Caryear> byKid = ownerRepositoryCaryear.findByKid(kid);
        return byKid;
    }
}
