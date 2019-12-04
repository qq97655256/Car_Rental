package first.pojo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer uid;
    private  String tel;
    private double sal;
    private String username;
    private  String resname;
    private String usercard;
    private  Integer ustatus;
    private  String pass;
    private  String password;
    private  String uph;
    private  String bankcard;

}
