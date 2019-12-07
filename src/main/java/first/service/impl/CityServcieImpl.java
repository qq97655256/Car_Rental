package first.service.impl;

import first.dao.CityDao;
import first.pojo.Area;
import first.pojo.City;
import first.repository.CityRepository;
import first.service.CityServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServcieImpl implements CityServcie {
    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private CityDao cityDao;

    @Override
    public List<City> SelectCity() {
        return cityRepository.findAll();
    }

    @Override
    public List<Area> SelectAreaByCname(String cname) {
        return cityDao.SelectAreaByCname(cname);
    }
}
