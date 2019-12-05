package first.repository;

import first.pojo.Brand_r;
import org.springframework.data.jpa.repository.JpaRepository;
/*
车辆品牌查询
 */
public interface OwnerRepository extends JpaRepository<Brand_r,Integer> {

}
