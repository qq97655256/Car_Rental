package first.repository;

import first.pojo.Caryear;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OwnerRepositoryCaryear extends JpaRepository<Caryear,Integer> {
    List<Caryear> findByKid(Integer kid);
}
