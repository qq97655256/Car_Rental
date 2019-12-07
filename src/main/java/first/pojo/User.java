package first.pojo;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;


@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;
    private String tel;
    private Double sal;
    private String username;
    private String resname;
    private String usercard;
    private Integer ustatus;
    private String pass;
    private String password;
    private String uph;
    private String bankcard;
    private String rname;//角色名9
    private Integer rid;//角色id

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof User) {
            User uu = (User) obj;
            if (this.getUid() == uu.getUid()
            ) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
