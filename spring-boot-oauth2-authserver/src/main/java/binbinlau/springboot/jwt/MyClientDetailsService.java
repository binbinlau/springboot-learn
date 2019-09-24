package binbinlau.springboot.jwt;

import binbinlau.springboot.oauth2.entity.MyClientDetails;
import binbinlau.springboot.oauth2.service.MyClientDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Author LiuBin
 * @Date 2019/9/9 19:52
 **/
@Service
public class MyClientDetailsService implements ClientDetailsService {

    @Autowired
    MyClientDetailsRepository repository;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        Optional<MyClientDetails> client = repository.findByClientId(clientId);
        BaseClientDetails base = null;
        if (client.isPresent()) {
            String resourceIds = client.get().getResourceIds().stream().collect(Collectors.joining(","));
            String scopes = client.get().getScope().stream().collect(Collectors.joining(","));
            String grantTypes = client.get().getAuthorizedGrantTypes().stream().collect(Collectors.joining(","));
            String authorities = client.get().getAuthorities().stream().collect(Collectors.joining(","));
            base = new BaseClientDetails(client.get().getClientId(), resourceIds, scopes, grantTypes, authorities);
            base.setClientSecret(client.get().getClientSecret());
            base.setAccessTokenValiditySeconds(client.get().getAccessTokenValiditySeconds());
            base.setRefreshTokenValiditySeconds(client.get().getRefreshTokenValiditySeconds());
            base.setAdditionalInformation(client.get().getAdditionalInformation());
            base.setAutoApproveScopes(client.get().getScope());
        }
        return base;
    }
}
