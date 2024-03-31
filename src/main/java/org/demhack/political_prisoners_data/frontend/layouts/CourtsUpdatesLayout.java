package org.demhack.political_prisoners_data.frontend.layouts;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import org.demhack.political_prisoners_data.frontend.MainLayoutDrawer;


@Route(value = "/courts-updates", layout = MainLayoutDrawer.class)
public class CourtsUpdatesLayout extends Div {
    public CourtsUpdatesLayout() {
        add(new UpdatesVirtualList());
    }
}
