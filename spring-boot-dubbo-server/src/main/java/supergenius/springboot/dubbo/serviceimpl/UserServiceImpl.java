package supergenius.springboot.dubbo.serviceimpl;

import supergenius.springboot.api.service.UserService;
import supergenius.springboot.dubbo.entity.User;
import org.apache.dubbo.config.annotation.Service;

/**
 *  
 * @Author LiuBin
 * @Date 2019/7/16  16:37
 * @Param 
 * @return 
 **/
@Service(version = "1.0.0")
public class UserServiceImpl implements UserService {

    @Override
    public String get(String name) {
        User user = new User("uid1111111111111111111", name, 20);
        return user.toString();
    }

}
