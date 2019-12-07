package first.service.impl;

import first.dao.AreaMapper;
import first.pojo.Area;
import first.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaMapper areaMapper;
    @Override
    public List<Area> SelectArea() {
        return areaMapper.SelectArea();
    }
}
