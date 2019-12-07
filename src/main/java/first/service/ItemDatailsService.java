package first.service;

import first.pojo.ItemDetails;

import java.util.List;

public interface ItemDatailsService {
    List<ItemDetails> itemall(Integer uid);
    int Itemdelete(Integer oid);
}
