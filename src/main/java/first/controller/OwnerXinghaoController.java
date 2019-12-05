package first.controller;

import first.pojo.XingHao;
import first.service.OwnerServiceXinghao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/owner")
public class OwnerXinghaoController {
    @Autowired
    private OwnerServiceXinghao ownerServiceXinghao;
    @RequestMapping("/xinghao/{fid}")
    private List<XingHao> findByFid(@PathVariable("fid")Integer fid){
        List<XingHao> xingHaos = ownerServiceXinghao.findByFid(fid);
        return xingHaos;
    }

}
