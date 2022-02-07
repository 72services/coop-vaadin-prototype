package ch.coop.app.ui.views;

import ch.coop.app.ui.layout.MainLayout;
import ch.coop.greeter.library.Greeter;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Hello World")
@Route(value = "hello", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class HelloWorldView extends VerticalLayout {

    public HelloWorldView(Greeter greeter) {
        setMargin(true);

        TextField name = new TextField("Your name");
        H1 text = new H1();
        Button sayHello = new Button("Say hello", e -> text.setText(greeter.greet(name.getValue())));

        add(name, sayHello, text);

        name.setAutofocus(true);
    }

}
