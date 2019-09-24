package binbinlau.springboot.oauth2.service;

import binbinlau.springboot.oauth2.entity.MyClientDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 *
 * @Author LiuBin
 * @Date 2019/9/24  17:49 
 * @Param 
 * @return 
 **/
public interface MyClientDetailsRepository extends JpaRepository<MyClientDetails, String> {
    
    Optional<MyClientDetails> findByClientId(String clientId);
}
