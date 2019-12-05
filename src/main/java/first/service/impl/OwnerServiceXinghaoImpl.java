package first.service.impl;

import first.pojo.XingHao;
import first.repository.OwnerRepositoryXinghao;
import first.service.OwnerServiceXinghao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerServiceXinghaoImpl implements OwnerServiceXinghao {
    @Autowired
    private OwnerRepositoryXinghao ownerRepositoryXinghao;
    @Override
    public List<XingHao> findByFid(Integer fid) {
        List<XingHao> byFid = ownerRepositoryXinghao.findByFid(fid);
        return byFid;
    }
}
