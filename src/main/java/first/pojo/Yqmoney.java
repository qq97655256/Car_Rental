package first.pojo;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "yqmoney")
public class Yqmoney {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mid")
    private Integer value;
    @Column(name = "mmoney")
    private String number;
    private Integer did;
}
