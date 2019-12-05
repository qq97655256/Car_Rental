package first.pojo;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "xinghao")
public class XingHao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kid")
    private Integer valuess;
    @Column(name = "kname")
    private String labelss;
    private Integer fid;
}
