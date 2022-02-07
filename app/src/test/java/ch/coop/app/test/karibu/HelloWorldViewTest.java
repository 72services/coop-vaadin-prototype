package ch.coop.app.test.karibu;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.textfield.TextField;
import org.junit.jupiter.api.Test;

import static com.github.mvysny.kaributesting.v10.LocatorJ._get;
import static org.assertj.core.api.Assertions.assertThat;

class HelloWorldViewTest extends AbstractKaribuTest {

    @Test
    void say_hello() {
        TextField name = _get(TextField.class, spec -> spec.withId("hello-world-name"));
        name.setValue("Max");

        Button sayHello = _get(Button.class, spec -> spec.withId("hello-world-say-hello"));
        sayHello.click();

        H1 text = _get(H1.class, spec -> spec.withId("hello-world-text"));
        assertThat(text.getText()).contains("Max");
    }
}
