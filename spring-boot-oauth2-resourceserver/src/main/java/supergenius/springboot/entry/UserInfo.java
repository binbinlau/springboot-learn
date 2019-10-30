package supergenius.springboot.entry;

/**
 * @Author LiuBin
 * @Date 2019/9/4 15:04
 **/
public class UserInfo {

    private String name;

    private String email;

    public UserInfo(String name, String email) {
        super();
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
