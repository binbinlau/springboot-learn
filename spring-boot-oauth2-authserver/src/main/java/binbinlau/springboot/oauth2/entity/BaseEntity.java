package binbinlau.springboot.oauth2.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @Author LiuBin
 * @Date 2019/9/5 17:58
 **/
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Column(length = 10, columnDefinition = "tinyint default 1")
    int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
