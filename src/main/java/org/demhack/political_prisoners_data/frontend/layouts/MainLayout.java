package org.demhack.political_prisoners_data.frontend.layouts;

import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.demhack.political_prisoners_data.frontend.MainLayoutDrawer;
import org.demhack.political_prisoners_data.frontend.layouts.main.PoliticalPrisonersVirtualList;


@Route(value = "/main", layout = MainLayoutDrawer.class)
public class MainLayout extends VerticalLayout {
    public MainLayout() {
        add(new PoliticalPrisonersVirtualList());
    }
}
