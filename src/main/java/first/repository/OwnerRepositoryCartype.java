package first.repository;

import first.pojo.Cartype;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OwnerRepositoryCartype extends JpaRepository<Cartype,Integer> {
    List<Cartype> findByRid(Integer rid);
}
