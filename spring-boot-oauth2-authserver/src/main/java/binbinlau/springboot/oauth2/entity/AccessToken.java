package binbinlau.springboot.oauth2.entity;

import binbinlau.springboot.jwt.SerializableObjectConverter;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * @Author LiuBin
 * @Date 2019/9/23 20:03
 **/
@Entity
@Table(name = "accesstoken")
public class AccessToken extends BaseEntity {

    @Id
    private String id;
    @Column(name = "tokenid", unique = true, nullable = true)
    private String tokenId;
    @Lob
    private String token;
    @Column(name = "authenticationid")
    private String authenticationId;
    private String username;
    @Column(name = "clientid")
    private String clientId;
    @Lob
    private String authentication;
    @Column(name = "refreshtoken")
    private String refreshToken;

    public AccessToken() {};

    public AccessToken(String id, String tokenId, String username, String clientId) {
        this.id = id;
        this.tokenId = tokenId;
        this.username = username;
        this.clientId = clientId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public OAuth2AccessToken getToken() {
        return SerializableObjectConverter.deserialize1(token);
    }

    public void setToken(OAuth2AccessToken token) {
        this.token = SerializableObjectConverter.serialize(token);
    }

    public String getAuthenticationId() {
        return authenticationId;
    }

    public void setAuthenticationId(String authenticationId) {
        this.authenticationId = authenticationId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public OAuth2Authentication getAuthentication() {
        return SerializableObjectConverter.deserialize(authentication);
    }

    public void setAuthentication(OAuth2Authentication authentication) {
        this.authentication = SerializableObjectConverter.serialize(authentication);
    }
}
