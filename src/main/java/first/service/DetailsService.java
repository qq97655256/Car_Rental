package first.service;

import first.pojo.Details;
import first.pojo.User1;
import first.response.DetailsResponse;

import java.util.List;

public interface DetailsService {
    public List<Details> SelectCarName();

    public DetailsResponse SelectCar(Integer page, Integer sixze);

    List<Details> SelectCarByName(String pname);

    List<Details> SelectBrand(String rname);

    List<Details> SelectHot(String caname);

    List<Details> SelectByMoney();

    List<Details> SelectByMoney2();

    List<Details> SelectByZuCi();

    Integer InsertDetails(Details details);

    Details SelectId(String pic);

    Integer UpdateById(Details details);

    void quxiao(Integer caid);

    User1 SelectResNameByUid(Integer uid);
}
