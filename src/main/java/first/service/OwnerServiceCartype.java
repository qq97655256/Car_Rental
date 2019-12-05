package first.service;

import first.pojo.Cartype;

import java.util.List;

public interface OwnerServiceCartype {
    List<Cartype> findByRid(Integer rid);
}
