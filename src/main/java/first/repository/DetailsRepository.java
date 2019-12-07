package first.repository;

import first.pojo.Details;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetailsRepository extends JpaRepository<Details,Integer> {

    List<Details> findByUid(Integer uid);
}
