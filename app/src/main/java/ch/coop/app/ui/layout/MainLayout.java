package ch.coop.app.ui.layout;

import ch.coop.app.ui.views.HelloWorldView;
import ch.coop.vaadin.layout.CoopLayout;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;

@Theme("coop")
@PWA(name = "App", shortName = "App", offlineResources = {"images/logo.png"})
public class MainLayout extends CoopLayout implements AppShellConfigurator{

    public MainLayout() {
        addMenuItem(new MenuItemInfo("Hello World", "la la-globe", HelloWorldView.class));
    }
}
