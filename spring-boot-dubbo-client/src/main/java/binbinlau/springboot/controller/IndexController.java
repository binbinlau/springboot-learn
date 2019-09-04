package binbinlau.springboot.controller;

import binbinlau.springboot.dubbo.service.UserConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *  
 * @Author LiuBin
 * @Date 2019/7/26  17:10 
 * @Param 
 * @return 
 **/
@RestController
public class IndexController {

    @Autowired
    UserConsumer userConsumer;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return userConsumer.get("springboot");
    }
}
