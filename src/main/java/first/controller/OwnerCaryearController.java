package first.controller;

import first.pojo.Caryear;
import first.service.OwnerServiceCaryear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/owner")
public class OwnerCaryearController {
    @Autowired
    private OwnerServiceCaryear ownerServiceCaryear;
    @RequestMapping("/caryear/{kid}")
    public List<Caryear> FindAll(@PathVariable("kid") Integer kid){
        List<Caryear> caryears = ownerServiceCaryear.findByKid(kid);
        return  caryears;
    }
}
