package first.dao;

import first.pojo.Area;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CityDao {
List<Area> SelectAreaByCname(String cname);
}
