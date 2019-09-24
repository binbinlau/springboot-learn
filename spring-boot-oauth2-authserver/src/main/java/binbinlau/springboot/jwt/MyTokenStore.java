package binbinlau.springboot.jwt;

import binbinlau.springboot.oauth2.entity.AccessToken;
import binbinlau.springboot.oauth2.entity.RefreshToken;
import binbinlau.springboot.oauth2.service.AccessTokenRepository;
import binbinlau.springboot.oauth2.service.RefreshTokenRepository;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.AuthenticationKeyGenerator;
import org.springframework.security.oauth2.provider.token.DefaultAuthenticationKeyGenerator;
import org.springframework.security.oauth2.provider.token.TokenStore;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @Author LiuBin
 * @Date 2019/9/24 12:22
 **/
public class MyTokenStore implements TokenStore {
    private AccessTokenRepository accessTokenRepository;
    private RefreshTokenRepository refreshTokenRepository;

    public MyTokenStore(AccessTokenRepository accessTokenRepository, RefreshTokenRepository refreshTokenRepository) {
        this.accessTokenRepository = accessTokenRepository;
        this.refreshTokenRepository = refreshTokenRepository;
    }

    private AuthenticationKeyGenerator authenticationKeyGenerator = new DefaultAuthenticationKeyGenerator();

    @Override
    public OAuth2Authentication readAuthentication(OAuth2AccessToken token) {
        return readAuthentication(token.getValue());
    }

    @Override
    public OAuth2Authentication readAuthentication(String token) {
        Optional<AccessToken> accessToken = accessTokenRepository.findByTokenId(extractTokenKey(token));
        if (accessToken.isPresent()) {
            return accessToken.get().getAuthentication();
        }
        return null;
    }

    @Override
    public void storeAccessToken(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        String refreshToken = null;
        if (accessToken.getRefreshToken() != null) {
            refreshToken = accessToken.getRefreshToken().getValue();
        }
        if (readAccessToken(accessToken.getValue()) != null) {
            this.removeAccessToken(accessToken);
        }
        AccessToken at = new AccessToken();
        at.setId(generateUID());
        at.setTokenId(extractTokenKey(accessToken.getValue()));
        at.setToken(accessToken);
        at.setAuthenticationId(authenticationKeyGenerator.extractKey(authentication));
        at.setUsername(authentication.isClientOnly() ? null : authentication.getName());
        at.setClientId(authentication.getOAuth2Request().getClientId());
        at.setAuthentication(authentication);
        at.setRefreshToken(extractTokenKey(refreshToken));
        accessTokenRepository.save(at);
    }

    @Override
    public OAuth2AccessToken readAccessToken(String tokenValue) {
        Optional<AccessToken> accessToken = accessTokenRepository.findByTokenId(extractTokenKey(tokenValue));
        if (accessToken.isPresent()) {
            return accessToken.get().getToken();
        }
        return null;
    }

    @Override
    public void removeAccessToken(OAuth2AccessToken token) {
        Optional<AccessToken> accessToken = accessTokenRepository.findByTokenId(extractTokenKey(token.getValue()));
        if (accessToken.isPresent()) {
            accessTokenRepository.delete(accessToken.get());
        }
    }

    @Override
    public void storeRefreshToken(OAuth2RefreshToken refreshToken, OAuth2Authentication authentication) {
        RefreshToken rt = new RefreshToken();
        rt.setId(generateUID());
        rt.setTokenId(extractTokenKey(refreshToken.getValue()));
        rt.setToken(refreshToken);
        rt.setAuthentication(authentication);
        refreshTokenRepository.save(rt);
    }

    @Override
    public OAuth2RefreshToken readRefreshToken(String tokenValue) {
        Optional<RefreshToken> refreshToken = refreshTokenRepository.findByTokenId(extractTokenKey(tokenValue));
        return refreshToken.isPresent()? refreshToken.get().getToken() :null;
    }

    @Override
    public OAuth2Authentication readAuthenticationForRefreshToken(OAuth2RefreshToken token) {
        Optional<RefreshToken> refreshToken = refreshTokenRepository.findByTokenId(extractTokenKey(token.getValue()));
        return refreshToken.isPresent() ? refreshToken.get().getAuthentication() : null;
    }

    @Override
    public void removeRefreshToken(OAuth2RefreshToken token) {
        Optional<RefreshToken> refreshToken = refreshTokenRepository.findByTokenId(extractTokenKey(token.getValue()));
        if(refreshToken.isPresent()){
            refreshTokenRepository.delete(refreshToken.get());
        }
    }

    @Override
    public void removeAccessTokenUsingRefreshToken(OAuth2RefreshToken refreshToken) {
        Optional<AccessToken> accessToken = accessTokenRepository.findByTokenId(extractTokenKey(refreshToken.getValue()));
        if(accessToken.isPresent()) {
            accessTokenRepository.delete(accessToken.get());
        }
    }

    @Override
    public OAuth2AccessToken getAccessToken(OAuth2Authentication authentication) {
        OAuth2AccessToken accessToken = null;
        String authenticationId = authenticationKeyGenerator.extractKey(authentication);
        Optional<AccessToken> token = accessTokenRepository.findByAuthenticationId(authenticationId);
        if (token.isPresent()) {
            accessToken = token.get().getToken();
            if(accessToken != null && !authenticationId.equals(this.authenticationKeyGenerator.extractKey(this.readAuthentication(accessToken)))) {
                this.removeAccessToken(accessToken);
                this.storeAccessToken(accessToken, authentication);
            }
        }
        return accessToken;
    }

    @Override
    public Collection<OAuth2AccessToken> findTokensByClientIdAndUserName(String clientId, String userName) {
        Collection<OAuth2AccessToken> tokens = new ArrayList<OAuth2AccessToken>();
        List<AccessToken> result = accessTokenRepository.findByClientIdAndUsername(clientId, userName);
        result.forEach(e -> tokens.add(e.getToken()));
        return tokens;
    }

    @Override
    public Collection<OAuth2AccessToken> findTokensByClientId(String clientId) {
        Collection<OAuth2AccessToken> tokens = new ArrayList<OAuth2AccessToken>();
        List<AccessToken> result = accessTokenRepository.findByClientId(clientId);
        result.forEach(e -> tokens.add(e.getToken()));
        return tokens;
    }

    private String generateUID() {
        return UUID.randomUUID().toString() + UUID.randomUUID().toString();
    }

    private String extractTokenKey(String value) {
        if(value == null) {
            return null;
        } else {
            MessageDigest digest;
            try {
                digest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException var5) {
                throw new IllegalStateException("MD5 algorithm not available.  Fatal (should be in the JDK).");
            }
            try {
                byte[] e = digest.digest(value.getBytes("UTF-8"));
                return String.format("%032x", new Object[]{new BigInteger(1, e)});
            } catch (UnsupportedEncodingException var4) {
                throw new IllegalStateException("UTF-8 encoding not available.  Fatal (should be in the JDK).");
            }
        }
    }
}
