package first.service.impl;

import first.dao.BrandMapper;
import first.pojo.Brand;
import first.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> SelectBrand() {
        return brandMapper.SelectBrand();
    }
}
