package supergenius.springboot.oauth2.entity;

import supergenius.springboot.converter.SerializableObjectConverter;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * @Author LiuBin
 * @Date 2019/9/24 12:02
 **/
@Table(name = "refreshtoken")
@Entity
public class RefreshToken extends BaseEntity {
    @Id
    @Column(unique = true, nullable = true)
    private String id;
    private String tokenId;
    @Lob
    private String token;
    @Lob
    private String authentication;

    public RefreshToken() {
    }

    ;

    public RefreshToken(String id, String tokenId) {
        this.id = id;
        this.tokenId = tokenId;
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

    public OAuth2RefreshToken getToken() {
        return SerializableObjectConverter.deserialize2(token);
    }

    public void setToken(OAuth2RefreshToken token) {
        this.token = SerializableObjectConverter.serialize(token);
    }

    public OAuth2Authentication getAuthentication() {
        return SerializableObjectConverter.deserialize(authentication);
    }

    public void setAuthentication(OAuth2Authentication authentication) {
        this.authentication = SerializableObjectConverter.serialize(authentication);
    }
}
