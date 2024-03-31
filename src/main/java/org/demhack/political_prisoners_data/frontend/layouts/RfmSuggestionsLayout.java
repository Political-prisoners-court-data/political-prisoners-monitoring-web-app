package org.demhack.political_prisoners_data.frontend.layouts;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import org.demhack.political_prisoners_data.frontend.MainLayoutDrawer;


@Route(value = "/rfm-suggestions", layout = MainLayoutDrawer.class)
public class RfmSuggestionsLayout extends Div {
    public RfmSuggestionsLayout() {
        add(new RfmSuggestionsVirtualList());
    }
}
