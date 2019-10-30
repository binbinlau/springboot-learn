package supergenius.springboot.api;

import supergenius.springboot.entry.UserInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author LiuBin
 * @Date 2019/9/4 15:03
 **/
@Controller
public class UserController {

    @RequestMapping("/api/userinfo")
    public ResponseEntity<UserInfo> getUerInfo() {
        String username = (String) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        String email = username + "@supergenius.cn";

        UserInfo userInfo = new UserInfo(username, email);

        return ResponseEntity.ok(userInfo);
    }

    @RequestMapping("/user")
    @ResponseBody
    public String getUser() {
        return "supergenius";
    }
}
