/* Minor changes made to other controller tester for more accurate results */
package haagahelia.exercise;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import haagahelia.exercise.web.MusicController;

/**
 * Testing that the context is creating your controller
 * 
 * @author h01270
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MusicSiteApplicationTests {

    @Autowired
    private MusicController controller;

    @Test
    public void contexLoads() throws Exception {
        assertThat(controller).isNotNull();
    }	
}

