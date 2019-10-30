package supergenius.springboot.oauth2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Arrays;
import java.util.Objects;

/**
 * @Author LiuBin
 * @Date 2019/9/5 16:18
 **/
@Entity
@Table(name = "user")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false, unique = true)
    private String username; //用户名
    private String password; //用户密码
    private boolean expired; //用户授权是否过期
    private boolean locked; //用户是否被锁定
    private String role; //用户角色，使用逗号分隔，例如：USER,ADMIN...

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        locked = locked;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // 判断该用户是否具有某角色
    public boolean hasRole(String r) {
        return Arrays.stream(this.role.split(",")).anyMatch(s -> Objects.equals(s, r));
    }
}
