package first.pojo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "area")
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;
    private String pname;
    private Integer cid;
}
