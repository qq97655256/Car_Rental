package first.dao;

import first.pojo.Details;
import first.pojo.User;
import first.pojo.User1;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DetailsMapper {
    public List<Details> SelectCarName();

    List<Details> SelectCarByName(String pname);

    List<Details> SelectBrand(String rname);

    List<Details> SelectHot(String caname);

    List<Details> SelectByMoney();

    List<Details> SelectByMoney2();

    List<Details> SelectByZuCi();

    Integer InsertDetails(Details details);

    Details SelectId(String pic);

    Integer UpdateById(Details details);

    User1 SelectResNameByUid(Integer uid);
}
