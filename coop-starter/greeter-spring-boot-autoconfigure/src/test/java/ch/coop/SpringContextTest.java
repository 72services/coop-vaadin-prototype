package ch.coop;

import ch.coop.greeter.autoconfigure.GreeterAutoConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = GreeterAutoConfiguration.class)
public class SpringContextTest {

    @Test
    public void whenSpringContextIsBootstrappedthenNoExceptionIsThrown() {
    }
}
