package supergenius.springboot.oauth2.entity;

import supergenius.springboot.converter.MapToStringConverter;
import supergenius.springboot.converter.SetToStringConverter;
import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author LiuBin
 * @Date 2019/9/24 15:03
 **/
@Table(name = "clientdetails")
@Entity
public class MyClientDetails extends BaseEntity {

    @Id
    @Column(nullable = false, unique = true)
    @NotNull
    private String id;
    @Column(unique = true, nullable = false)
    @NotNull
    private String clientId;
    @Column(unique = true, nullable = false)
    @NotNull
    private String clientSecret;
    @Convert(converter = SetToStringConverter.class)
    private Set<String> resourceIds = new HashSet<>();
    private boolean secretRequired;
    private boolean scoped;
    @Convert(converter = SetToStringConverter.class)
    private Set<String> scope = new HashSet<>();
    @Convert(converter = SetToStringConverter.class)
    private Set<String> authorizedGrantTypes = new HashSet<>();
    @Convert(converter = SetToStringConverter.class)
    private Set<String> registeredRedirectUri = new HashSet<>();
    @Convert(converter = SetToStringConverter.class)
    private Set<String> authorities = new HashSet<>();
    private Integer accessTokenValiditySeconds;
    private Integer refreshTokenValiditySeconds;
    private boolean autoApprove;
    @Convert(converter = MapToStringConverter.class)
    private Map<String, Object> additionalInformation = new HashMap<>();

    public MyClientDetails() {
    }

    public MyClientDetails(String id, String clientId, String clientSecret) {
        this.id = id;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public Set<String> getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(Set<String> resourceIds) {
        this.resourceIds = resourceIds;
    }

    public boolean isSecretRequired() {
        return secretRequired;
    }

    public void setSecretRequired(boolean secretRequired) {
        this.secretRequired = secretRequired;
    }

    public boolean isScoped() {
        return scoped;
    }

    public void setScoped(boolean scoped) {
        this.scoped = scoped;
    }

    public Set<String> getScope() {
        return scope;
    }

    public void setScope(Set<String> scope) {
        this.scope = scope;
    }

    public Set<String> getAuthorizedGrantTypes() {
        return authorizedGrantTypes;
    }

    public void setAuthorizedGrantTypes(Set<String> authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes;
    }

    public Set<String> getRegisteredRedirectUri() {
        return registeredRedirectUri;
    }

    public void setRegisteredRedirectUri(Set<String> registeredRedirectUri) {
        this.registeredRedirectUri = registeredRedirectUri;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }

    public Integer getAccessTokenValiditySeconds() {
        return accessTokenValiditySeconds;
    }

    public void setAccessTokenValiditySeconds(Integer accessTokenValiditySeconds) {
        this.accessTokenValiditySeconds = accessTokenValiditySeconds;
    }

    public Integer getRefreshTokenValiditySeconds() {
        return refreshTokenValiditySeconds;
    }

    public void setRefreshTokenValiditySeconds(Integer refreshTokenValiditySeconds) {
        this.refreshTokenValiditySeconds = refreshTokenValiditySeconds;
    }

    public boolean isAutoApprove() {
        return autoApprove;
    }

    public void setAutoApprove(boolean autoApprove) {
        this.autoApprove = autoApprove;
    }

    public Map<String, Object> getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(Map<String, Object> additionalInformation) {
        this.additionalInformation = additionalInformation;
    }
}
