package first.pojo;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "caryear")
@Data
public class Caryear {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "did")
    private Integer value;
    @Column(name = "ddate")
    private String label;
    private Integer kid;
}
