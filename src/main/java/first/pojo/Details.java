package first.pojo;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "details")
public class Details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer caid;
    private String caname;
    private  String cacard;
    private  String brand;
    private  String cartype;
    private  Integer changer;
    private Integer carage;
    private Integer seats;
    private  Double cc;
    private String power;
    private  Double price;
    private String cardate;
    private Double pingfen;
    private String youxing;
    private  Double carwight;
    private Integer daoche;
    private Integer tianchuang;
    private  Integer jilu;
    private Integer xianxing;
    private String jiaoche;
    private String zhuname;
    private Double jiedan;
    private String zhuph;
    private String ph1;
    private String ph2;
    private String ph3;
    private String ph4;
    private String ph5;
    private String ph6;
    private String miaoshu;
    private  Integer uid;
    private  Integer pid;
    private  Integer zuci;
    private String guo;
    private String make;
    private String dplace;
    private Double xingshi;
    private Integer isrent;
    private String zutype;

}
