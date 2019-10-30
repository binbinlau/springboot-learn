package supergenius.springboot.oauth2.service;

import supergenius.springboot.oauth2.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @Author LiuBin
 * @Date 2019/9/24  18:23
 * @Param
 * @return
 **/
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, String> {

    Optional<RefreshToken> findByTokenId(String tokenId);
}
