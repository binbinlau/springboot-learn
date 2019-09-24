package binbinlau.springboot.oauth2.service;

import binbinlau.springboot.oauth2.entity.AccessToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @Author LiuBin
 * @Date 2019/9/23 20:24
 **/
public interface AccessTokenRepository extends JpaRepository<AccessToken, String> {

    List<AccessToken> findByClientId(String clientId);
    List<AccessToken> findByClientIdAndUsername(String clientId, String username);
    Optional<AccessToken> findByTokenId(String tokenId);
    Optional<AccessToken> findByRefreshToken(String refreshToken);
    Optional<AccessToken> findByAuthenticationId(String authenticationId);
 }
