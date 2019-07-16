package binbinlau.springboot.dubbo.serviceimpl;

import binbinlau.springboot.dubbo.entity.User;
import binbinlau.springboot.dubbo.service.UserService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 *  
 * @Author LiuBin
 * @Date 2019/7/16  16:37
 * @Param 
 * @return 
 **/
@Service(version = "1.0.0")
@Component
public class UserServiceImpl implements UserService {

    @Override
    public String get(String name) {
        User user = new User("uid1111111111111111111", name, 20);
        return user.toString();
    }


}
