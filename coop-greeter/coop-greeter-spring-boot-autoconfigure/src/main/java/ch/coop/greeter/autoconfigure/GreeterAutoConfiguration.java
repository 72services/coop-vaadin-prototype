package ch.coop.greeter.autoconfigure;

import ch.coop.greeter.library.Greeter;
import ch.coop.greeter.library.GreetingConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static ch.coop.greeter.library.GreeterConfigParams.AFTERNOON_MESSAGE;
import static ch.coop.greeter.library.GreeterConfigParams.EVENING_MESSAGE;
import static ch.coop.greeter.library.GreeterConfigParams.MORNING_MESSAGE;
import static ch.coop.greeter.library.GreeterConfigParams.NIGHT_MESSAGE;

@Configuration
@ConditionalOnClass(Greeter.class)
@EnableConfigurationProperties(GreeterProperties.class)
public class GreeterAutoConfiguration {

    private final GreeterProperties greeterProperties;

    public GreeterAutoConfiguration(GreeterProperties greeterProperties) {
        this.greeterProperties = greeterProperties;
    }

    @Bean
    @ConditionalOnMissingBean
    public GreetingConfig greeterConfig() {

        String morningMessage = greeterProperties.getMorningMessage() == null ? "Good Morning" : greeterProperties.getMorningMessage();
        String afternoonMessage = greeterProperties.getAfternoonMessage() == null ? "Good Afternoon" : greeterProperties.getAfternoonMessage();
        String eveningMessage = greeterProperties.getEveningMessage() == null ? "Good Evening" : greeterProperties.getEveningMessage();
        String nightMessage = greeterProperties.getNightMessage() == null ? "Good Night" : greeterProperties.getNightMessage();

        GreetingConfig greetingConfig = new GreetingConfig();
        greetingConfig.put(MORNING_MESSAGE, morningMessage);
        greetingConfig.put(AFTERNOON_MESSAGE, afternoonMessage);
        greetingConfig.put(EVENING_MESSAGE, eveningMessage);
        greetingConfig.put(NIGHT_MESSAGE, nightMessage);
        return greetingConfig;
    }

    @Bean
    @ConditionalOnMissingBean
    public Greeter greeter(GreetingConfig greetingConfig) {
        return new Greeter(greetingConfig);
    }

}
