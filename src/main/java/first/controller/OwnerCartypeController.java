package first.controller;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import first.pojo.Cartype;
import first.service.OwnerServiceCartype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/owner")
public class OwnerCartypeController {
    @Autowired
    private OwnerServiceCartype ownerServiceCartype;
@RequestMapping("/cartype/{rid}")
    private List<Cartype> FindAll(@PathVariable("rid") Integer rid){
        List<Cartype> cartypes = ownerServiceCartype.findByRid(rid);
        return cartypes;
    }
}
