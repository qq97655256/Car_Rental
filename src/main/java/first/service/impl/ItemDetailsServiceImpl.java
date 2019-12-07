package first.service.impl;

import first.dao.ItemMapper;
import first.pojo.ItemDetails;
import first.service.ItemDatailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemDetailsServiceImpl implements ItemDatailsService {

    @Autowired
    private ItemMapper itemMapper;
    @Override
    public List<ItemDetails> itemall(Integer uid) {
        List<ItemDetails> itemall = itemMapper.itemall(uid);
        return itemall;
    }

    @Override
    public int Itemdelete(Integer oid) {
        int itemdelete = itemMapper.Itemdelete(oid);
        return itemdelete;
    }
}
