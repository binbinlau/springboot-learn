package binbinlau.springboot.config;

import binbinlau.springboot.oauth2.entity.User;
import binbinlau.springboot.oauth2.enums.EStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @Author LiuBin
 * @Date 2019/9/5 18:19
 **/
public class MyUserPrincipal implements UserDetails {

    private User user;
    public MyUserPrincipal(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    //用户账号过期，要重新请求令牌
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //用户账号被锁定，到账号中心解锁
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //信任凭证过期
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //用户是否是可用状态
    @Override
    public boolean isEnabled() {
        return user.getStatus() == EStatus.Enable;
    }
}
