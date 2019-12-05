package first.controller;

import first.pojo.Yqmoney;
import first.service.OwnerServiceYqmoney;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/owner")
public class OwnerYqmoneyController {
    @Autowired
    private OwnerServiceYqmoney ownerServiceYqmoney;
    @RequestMapping("/yqmoney/{did}")
    public List<Yqmoney> FindAll(@PathVariable("did")Integer did){
        List<Yqmoney> yqmonies = ownerServiceYqmoney.findByDid(did);
        return yqmonies;
    }
}
