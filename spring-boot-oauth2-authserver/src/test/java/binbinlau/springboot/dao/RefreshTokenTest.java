package binbinlau.springboot.dao;

import binbinlau.springboot.oauth2.entity.RefreshToken;
import binbinlau.springboot.oauth2.service.RefreshTokenRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

/**
 * @Author LiuBin
 * @Date 2019/9/24 12:09
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class RefreshTokenTest {

    @Autowired
    RefreshTokenRepository refreshTokenRepository;

    @Test
    public void saveTest() {
        RefreshToken refreshToken = new RefreshToken("refresh111", "111");
        Optional<RefreshToken> rt = refreshTokenRepository.findByTokenId("111");
        System.out.println(rt.isPresent() ? rt.toString() : refreshTokenRepository.save(refreshToken));
    }
}
