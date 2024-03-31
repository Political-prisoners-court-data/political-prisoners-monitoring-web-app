package org.demhack.political_prisoners_data.frontend.layouts;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import org.demhack.political_prisoners_data.frontend.MainLayoutDrawer;


@Route(value = "/updates", layout = MainLayoutDrawer.class)
public class UpdatesLayout extends Div {
    public UpdatesLayout() {
        add(new UpdatesVirtualList());
    }
}
