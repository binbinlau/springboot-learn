package supergenius.springboot;

import supergenius.springboot.oauth2.entity.User;
import supergenius.springboot.oauth2.service.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootOauth2ApplicationTests {

    @Autowired
    UserRepository userRepository;

    @Test
    public void contextLoads() {

    }

    @Before
    public void init() {
        User user = new User();
        user.setId(100);
        user.setUsername("supergenius");
        user.setPassword("supergenius");
        if (userRepository.findByUsername("supergenius") == null) {
            userRepository.save(user);
            System.out.println("user name is : " + user.getUsername());
        }
    }

    @Test
    public void testInsert() {
        System.out.println(userRepository.findByUsername("supergenius").getUsername());
    }

}
