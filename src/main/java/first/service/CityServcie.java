package first.service;

import first.pojo.Area;
import first.pojo.City;

import java.util.List;

public interface CityServcie {
    List<City> SelectCity();

    List<Area> SelectAreaByCname(String cname);
}
