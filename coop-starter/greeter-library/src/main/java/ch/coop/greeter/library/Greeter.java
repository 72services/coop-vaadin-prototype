package ch.coop.greeter.library;

import java.time.LocalDateTime;

import static ch.coop.greeter.library.GreeterConfigParams.AFTERNOON_MESSAGE;
import static ch.coop.greeter.library.GreeterConfigParams.EVENING_MESSAGE;
import static ch.coop.greeter.library.GreeterConfigParams.MORNING_MESSAGE;
import static ch.coop.greeter.library.GreeterConfigParams.NIGHT_MESSAGE;

public class Greeter {

    private GreetingConfig greetingConfig;

    public Greeter(GreetingConfig greetingConfig) {
        this.greetingConfig = greetingConfig;
    }

    public String greet(LocalDateTime localDateTime, String name) {
        int hourOfDay = localDateTime.getHour();

        if (hourOfDay >= 5 && hourOfDay < 12) {
            return String.format("Hello %s, %s", name, greetingConfig.get(MORNING_MESSAGE));
        } else if (hourOfDay >= 12 && hourOfDay < 17) {
            return String.format("Hello %s, %s", name, greetingConfig.get(AFTERNOON_MESSAGE));
        } else if (hourOfDay >= 17 && hourOfDay < 20) {
            return String.format("Hello %s, %s", name, greetingConfig.get(EVENING_MESSAGE));
        } else {
            return String.format("Hello %s, %s", name, greetingConfig.get(NIGHT_MESSAGE));
        }
    }

    public String greet(String name) {
        return greet(LocalDateTime.now(), name);
    }

}
