package first.pojo;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "cartype")
public class Cartype {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "fid")
    private Integer values;
    @Column(name = "fname")
    private String labels;
    private Integer rid;



}
