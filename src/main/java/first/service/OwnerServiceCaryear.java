package first.service;

import first.pojo.Caryear;

import java.util.List;

public interface OwnerServiceCaryear {
    List<Caryear> findByKid(Integer kid);
}
