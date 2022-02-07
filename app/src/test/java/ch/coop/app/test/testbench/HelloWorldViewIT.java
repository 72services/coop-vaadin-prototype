package ch.coop.app.test.testbench;

import com.vaadin.flow.component.button.testbench.ButtonElement;
import com.vaadin.flow.component.html.testbench.H1Element;
import com.vaadin.flow.component.textfield.testbench.TextFieldElement;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class HelloWorldViewIT extends AbstractTestBenchIT {

    @Test
    public void say_hello() {
        TextFieldElement name = $(TextFieldElement.class).id("hello-world-name");
        name.setValue("Max");

        ButtonElement sayHello = $(ButtonElement.class).id("hello-world-say-hello");
        sayHello.click();

        H1Element text = $(H1Element.class).id("hello-world-text");

        assertTrue(text.getText().contains("Max"));
    }
}
