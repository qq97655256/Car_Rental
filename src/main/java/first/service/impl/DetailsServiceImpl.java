package first.service.impl;

import first.dao.DetailsMapper;
import first.pojo.Details;
import first.repository.Details2Repository;
import first.response.DetailsResponse;
import first.service.DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DetailsServiceImpl implements DetailsService {

    @Autowired
    private DetailsMapper detailsMapper;
    @Autowired
    private Details2Repository detailsRepository;
    @Override
    public List<Details> SelectCarName() {
        return detailsMapper.SelectCarName();
    }

    @Override
    public DetailsResponse SelectCar(Integer page, Integer size) {
        if (page<0){
            page=0;
        }else {
            page=page-1;
        }
        Pageable pageable=PageRequest.of(page,size);
        Page<Details> all = detailsRepository.findAll(pageable);
        List<Details> content = all.getContent();
        DetailsResponse detailsResponse=new DetailsResponse();
       detailsResponse.setDetails(content);
       detailsResponse.setPage(all.getTotalPages());
       detailsResponse.setTotal(all.getTotalElements());
        return detailsResponse;
    }

    @Override
    public List<Details> SelectCarByName(String pname) {
        return detailsMapper.SelectCarByName(pname);
    }

    @Override
    public List<Details> SelectBrand(String rname) {
        return detailsMapper.SelectBrand(rname);
    }

    @Override
    public List<Details> SelectHot(String caname) {
        return detailsMapper.SelectHot(caname);
    }

    @Override
    public List<Details> SelectByMoney() {
        return detailsMapper.SelectByMoney();
    }

    @Override
    public List<Details> SelectByMoney2() {
        return detailsMapper.SelectByMoney2();
    }

    @Override
    public List<Details> SelectByZuCi() {
        return detailsMapper.SelectByZuCi();
    }

    @Override
    public Integer InsertDetails(Details details) {
        return detailsMapper.InsertDetails(details);
    }

    @Override
    public Details SelectId(String pic) {
        return detailsMapper.SelectId(pic);
    }

    @Override
    public Integer UpdateById(Details details) {
       return detailsMapper.UpdateById(details);
    }

    @Override
    public void quxiao(Integer caid) {
        detailsRepository.deleteById(caid);
    }
}
