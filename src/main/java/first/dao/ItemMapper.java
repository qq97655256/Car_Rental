package first.dao;

import first.pojo.ItemDetails;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {
    List<ItemDetails> itemall(Integer uid);

    int Itemdelete(Integer oid);
}
