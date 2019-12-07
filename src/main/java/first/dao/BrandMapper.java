package first.dao;

import first.pojo.Brand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BrandMapper {
    public List<Brand> SelectBrand();
}
