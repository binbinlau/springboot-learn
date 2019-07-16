import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;
import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 *  启动类
 * @Author LiuBin
 * @Date 2019/7/16  16:20
 * @Param
 * @return
 **/
@EnableAutoConfiguration
@EnableDubboConfig
@DubboComponentScan(basePackages = "binbinlau.springboot.dubbo")
public class ApplicationLaunch {
    protected final static Log logger = LogFactory.getLog(ApplicationLaunch.class);

    public static void main(String[] args) {
        logger.info("开始启动springboot项目");
        new SpringApplicationBuilder(ApplicationLaunch.class)
                .web(WebApplicationType.NONE)
                .run(args);
//        SpringApplication.run(ApplicationLaunch.class, args);
        logger.info("springboot项目初始化成功");
    }
}
