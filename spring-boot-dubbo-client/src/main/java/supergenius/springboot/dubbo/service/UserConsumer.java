package supergenius.springboot.dubbo.service;

import supergenius.springboot.api.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

/**
 *
 * @Author LiuBin
 * @Date 2019/7/26  17:02
 * @Param
 * @return
 **/
@Component
public class UserConsumer {

    @Reference(version = "1.0.0")
    UserService userService;

    public String get(String name) {
        return userService.get(name); // Dubbo通过接口实现服务
    }

}
