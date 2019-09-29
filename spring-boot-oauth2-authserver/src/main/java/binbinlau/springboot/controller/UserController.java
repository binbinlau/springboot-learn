package binbinlau.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author LiuBin
 * @Date 2019/9/27 10:15
 **/
@Controller
public class UserController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @ResponseBody
    public String creatUser() {
        return "Hello";
    }

}
