package binbinlau.springboot.dubbo.entity;

import java.io.Serializable;

/**
 *
 * @Author LiuBin
 * @Date 2019/7/16  16:38
 * @Param
 * @return
 **/
public class User implements Serializable {
    String uid;
    String name;
    int age;

    public User() {}

    public User(String uid, String name, int age) {
        this.uid = uid;
        this.name = name;
        this.age = age;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "{" +
                "\"uid\" : \"" + uid + '\"' +
                ", \"name\" : \"" + name + '\"' +
                ", \"age\" : " + age +
                '}';
    }
}
