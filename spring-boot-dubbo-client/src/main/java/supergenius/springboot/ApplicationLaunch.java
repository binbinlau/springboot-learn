package supergenius.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 *  
 * @Author LiuBin
 * @Date 2019/7/18  13:50 
 * @Param 
 * @return 
 **/
@SpringBootApplication
public class ApplicationLaunch {
    private final Logger logger = LoggerFactory.getLogger(ApplicationLaunch.class);

    public static void main(String[] args) {
        new SpringApplicationBuilder(ApplicationLaunch.class).run(args);
    }

}
