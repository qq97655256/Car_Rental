package first.repository;

import first.pojo.Details;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailsRepository extends JpaRepository<Details,Integer> {
}
