package org.demhack.political_prisoners_data.frontend;


import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.demhack.political_prisoners_data.frontend.side_navigation.*;

@Route("")
@Theme("avtozaklive")
public class MainLayoutDrawer extends AppLayout implements AppShellConfigurator {

    public MainLayoutDrawer() {
        DrawerToggle toggle = new DrawerToggle();

        H1 title = new H1("Avtozak search");
        title.getStyle().set("font-size", "var(--lumo-font-size-l)")
                .set("margin", "0");

        SideNav nav = getTabs();

        Scroller scroller = new Scroller(nav);
        scroller.setClassName(LumoUtility.Padding.SMALL);

        addToDrawer(scroller);
        addToNavbar(toggle, title);

        setPrimarySection(Section.DRAWER);
    }

    private SideNav getTabs() {
        SideNav nav = new SideNav();
        nav.addItem(new MainSideItem(),
                new RfmUpdatesSideItem(),
                new RfmSuggestionsSideItem(),
                new CourtsUpdatesSideItem(),
                new UpdatesSideItem());
        return nav;
    }

}
