import binbinlau.springboot.api.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 *  
 * @Author LiuBin
 * @Date 2019/7/18  13:50 
 * @Param 
 * @return 
 **/
@EnableAutoConfiguration
public class ApplicationLaunch {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Reference(version = "${demo.service.version}")
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationLaunch.class).close();
    }

    @Bean
    public ApplicationRunner runner() {
        return args -> logger.info(userService.get("binbin"));
    }
}
