package supergenius.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
    public String creatUser(ModelMap map) {
        map.addAttribute("name", "binbinlau");
        return "index";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @ResponseBody
    public String register() {
        return "hello world";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(ModelMap map, String account, String passwd) {
        System.out.println("account : " + account);
        System.out.println("password : " + passwd);
        return "home";
    }
}
