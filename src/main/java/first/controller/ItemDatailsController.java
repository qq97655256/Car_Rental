package first.controller;

import first.pojo.ItemDetails;
import first.service.ItemDatailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemDatailsController {
    @Autowired
    private ItemDatailsService itemDatailsService;
    @RequestMapping("/itemall/{uid}")
    private List<ItemDetails> itemall(@PathVariable("uid") Integer uid){
        List<ItemDetails> itemall = itemDatailsService.itemall(uid);
        return itemall;

    }
@RequestMapping("/Itemdelete/{oid}")
    private String Itemdelete(@PathVariable("oid") Integer oid){
        int itemdelete = itemDatailsService.Itemdelete(oid);
        if(itemdelete==1){
            return "success";
        }else{
            return "warning";
        }
    }
}
