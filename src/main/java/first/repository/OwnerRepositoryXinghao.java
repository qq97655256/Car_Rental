package first.repository;

import first.pojo.XingHao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OwnerRepositoryXinghao extends JpaRepository<XingHao,Integer> {
    List<XingHao> findByFid(Integer fid);
}
