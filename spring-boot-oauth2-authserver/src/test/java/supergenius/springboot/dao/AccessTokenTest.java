package supergenius.springboot.dao;

import supergenius.springboot.oauth2.entity.AccessToken;
import supergenius.springboot.oauth2.enums.EStatus;
import supergenius.springboot.oauth2.service.AccessTokenRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author LiuBin
 * @Date 2019/9/24 10:09
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class AccessTokenTest {

    @Autowired
    AccessTokenRepository accessTokenRepository;

    @Test
    public void saveTest() {
        AccessToken accessToken = new AccessToken("111", "111", "zhangsan", "clientapp");
        accessToken.setStatus(EStatus.enable);

        List<AccessToken> list = accessTokenRepository.findByClientIdAndUsername("clientapp", "zhangsan");
        if (list != null && list.size() > 0) {
            if (!list.contains(accessToken)) {
                accessTokenRepository.save(accessToken);
            } else {
                System.out.println("======================" + list.get(0).getUsername());
            }
        } else {
            accessTokenRepository.save(accessToken);
        }
    }
}
