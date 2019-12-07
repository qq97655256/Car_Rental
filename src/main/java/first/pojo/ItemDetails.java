package first.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
public class ItemDetails {
    private Integer uid;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer oid;
    private String caname;
    private String cacard;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date xia;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date qu;
    private Double money;
    private Double yong;
    private Integer delete1;
    private Integer zhuang;

}
