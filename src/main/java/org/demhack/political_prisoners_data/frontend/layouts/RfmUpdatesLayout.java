package org.demhack.political_prisoners_data.frontend.layouts;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import org.demhack.political_prisoners_data.frontend.MainLayoutDrawer;


@Route(value = "/rfm-updates", layout = MainLayoutDrawer.class)
public class RfmUpdatesLayout extends Div {
    public RfmUpdatesLayout() {
        add(new UpdatesVirtualList());
    }
}
