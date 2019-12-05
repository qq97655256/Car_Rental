package first.service;

import first.pojo.Yqmoney;

import java.util.List;

public interface OwnerServiceYqmoney {
    List<Yqmoney> findByDid(Integer did);
}
