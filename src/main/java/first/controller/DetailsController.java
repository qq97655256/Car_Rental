package first.controller;

import first.pojo.Details;
import first.service.DetailsService;
import first.utils.Dp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/details")
public class DetailsController {
    @Autowired
    private DetailsService ds;
@RequestMapping("/one/{caid}")
    public Dp selectOne(@PathVariable("caid") int caid){
    Details details = ds.selectById(caid);
    List<String> list = new ArrayList<>();
    list.add(details.getPh1());
    list.add(details.getPh2());
    list.add(details.getPh3());
    list.add(details.getPh4());
    list.add(details.getPh5());
    list.add(details.getPh6());
    Dp dp = new Dp();
    dp.setDetails(details);
    dp.setList(list);
    return dp;
}


}
