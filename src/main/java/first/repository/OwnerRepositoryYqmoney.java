package first.repository;

import first.pojo.Yqmoney;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface OwnerRepositoryYqmoney extends JpaRepository<Yqmoney,Integer> {
    List<Yqmoney> findByDid(Integer did);

}
