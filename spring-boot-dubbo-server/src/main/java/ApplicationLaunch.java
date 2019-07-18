import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 *  启动类
 * @Author LiuBin
 * @Date 2019/7/16  16:20
 * @Param
 * @return
 **/
@EnableAutoConfiguration
public class ApplicationLaunch {
    protected final static Log logger = LogFactory.getLog(ApplicationLaunch.class);

    public static void main(String[] args) {
        new SpringApplicationBuilder(ApplicationLaunch.class).run(args);
    }
}
