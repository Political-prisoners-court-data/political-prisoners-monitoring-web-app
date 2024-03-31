package org.demhack.political_prisoners_data.frontend.layouts;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.virtuallist.VirtualList;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.dom.ElementFactory;
import org.demhack.political_prisoners_data.entities.RfmUpdateSuggestion;
import org.demhack.political_prisoners_data.entities.Update;
import org.demhack.political_prisoners_data.services.DataService;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.StringJoiner;

public class UpdatesVirtualList extends VerticalLayout {

    private List<Update> updates = DataService.getUpdates();

    private ComponentRenderer<Component, Update> updatesCardRenderer = new ComponentRenderer<>(
            update -> {
                HorizontalLayout cardLayout = new HorizontalLayout();
                cardLayout.setMargin(true);

                VerticalLayout updateLayout = new VerticalLayout();

                HorizontalLayout personLayout = new HorizontalLayout();
                personLayout.setSpacing(true);
                personLayout.setPadding(true);

                var person = update.getPoliticalPrisoner();
                var firstRowPerson = new StringJoiner("/")
                        .add(person.getFullName())
                        .add(update.getAction())
                        .toString();

                SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm");

                personLayout.getElement().appendChild(
                        ElementFactory.createStrong(firstRowPerson));
                personLayout.add(new Text(dateTimeFormat.format(update.getDate())));

                updateLayout.add(personLayout);

                HorizontalLayout secondRow = new HorizontalLayout(new Div(new Text(update.getSummary())));

                updateLayout.add(secondRow);

                HorizontalLayout thirdRow = new HorizontalLayout();

                Icon warningIcon = VaadinIcon.WARNING.create();
                warningIcon.getElement().getThemeList().add("badge error");
                thirdRow.add(warningIcon);
                thirdRow.add(VaadinIcon.EXTERNAL_LINK.create());

                updateLayout.add(thirdRow);
                updateLayout.setAlignItems(Alignment.CENTER);
                updateLayout.getElement().getThemeList().add("badge contrast");
                cardLayout.add(updateLayout);

                cardLayout.setAlignItems(Alignment.CENTER);

                return cardLayout;
            });

    public UpdatesVirtualList() {
        VirtualList<Update> list = new VirtualList<>();
        list.setItems(updates);
        list.setRenderer(updatesCardRenderer);
        add(list);
    }

}
