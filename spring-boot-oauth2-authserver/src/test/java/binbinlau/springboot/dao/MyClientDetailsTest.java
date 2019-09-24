package binbinlau.springboot.dao;

import binbinlau.springboot.oauth2.entity.MyClientDetails;
import binbinlau.springboot.oauth2.service.MyClientDetailsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

/**
 * @Author LiuBin
 * @Date 2019/9/24 17:38
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyClientDetailsTest {

    @Autowired
    MyClientDetailsRepository myClientDetailsRepository;

    @Test
    public void saveTest() {
        MyClientDetails myClientDetails = new MyClientDetails("someid", "clientapp", "112233");
        myClientDetails.setAuthorizedGrantTypes(new HashSet<>(Arrays.asList("password", "authorization_code", "refresh_token")));
        myClientDetails.setScope(new HashSet<>(Arrays.asList("read", "write")));
        myClientDetails.setAccessTokenValiditySeconds(1 * 60 * 60);
        myClientDetails.setRefreshTokenValiditySeconds(6 * 60 * 60);
        Optional<MyClientDetails> mcd = myClientDetailsRepository.findByClientId(myClientDetails.getClientId());
        System.out.println(mcd.isPresent() ? mcd.get().getClientId() : myClientDetailsRepository.save(myClientDetails));
    }
}
