package org.demhack.political_prisoners_data.frontend.layouts;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.virtuallist.VirtualList;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.dom.ElementFactory;
import org.demhack.political_prisoners_data.entities.RfmUpdateSuggestion;
import org.demhack.political_prisoners_data.services.DataService;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.StringJoiner;

public class RfmSuggestionsVirtualList extends Div {

    private List<RfmUpdateSuggestion> suggestions = DataService.getRfmUpdateSuggestions();

    private ComponentRenderer<Component, RfmUpdateSuggestion> suggestionsCardRenderer = new ComponentRenderer<>(
            suggestion -> {
                HorizontalLayout cardLayout = new HorizontalLayout();
                cardLayout.setMargin(false);

                //cardLayout.add(new Div(new Text("YOU SEE, IT WORKS!")));

                VerticalLayout personLayout = new VerticalLayout();
//                personLayout.setSpacing(true);
//                personLayout.setPadding(true);

                var dateFormatter = new SimpleDateFormat("dd.MM.yyyy");
                var person = suggestion.getPoliticalPrisoner();
                var firstRowPerson = new StringJoiner(", ")
                        .add(person.getFullName())
                        .add(String.valueOf(person.getAge()))
                        .add(person.getCity())
                        .add(dateFormatter.format(person.getInclusionDate()))
                        .toString();

                var secondRowPerson = "Airtable ID: " + person.getAirtableId();
                var secondRowLayout = new HorizontalLayout(new Div(new Text(secondRowPerson)));
                secondRowLayout.add(VaadinIcon.EXTERNAL_LINK.create());


                personLayout.getElement().appendChild(
                        ElementFactory.createStrong(firstRowPerson));
                personLayout.add(secondRowLayout);


                cardLayout.add(personLayout);
                cardLayout.add(VaadinIcon.CHEVRON_RIGHT.create());

                VerticalLayout suggestionLayout = new VerticalLayout();

                HorizontalLayout firstSuggestionRow = new HorizontalLayout(new Div(new Text(suggestion.getAction())));
                SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm");
                firstSuggestionRow.add(new Text(dateTimeFormat.format(suggestion.getDate())));

                suggestionLayout.add(firstSuggestionRow);

                HorizontalLayout secondSuggestionRow = new HorizontalLayout(new Div(new Text(suggestion.getRfmListItemText())));

                Icon warningIcon = VaadinIcon.WARNING.create();
                warningIcon.getElement().getThemeList().add("badge error");
                secondSuggestionRow.add(warningIcon);
                suggestionLayout.add(secondSuggestionRow);


                cardLayout.add(suggestionLayout);

                Icon checkIcon = VaadinIcon.CHECK.create();
                checkIcon.getElement().getThemeList().add("badge success");
                cardLayout.add(checkIcon);

                Icon close = VaadinIcon.CLOSE_BIG.create();
                close.getElement().getThemeList().add("badge error");
                cardLayout.add(close);

                cardLayout.setAlignItems(FlexComponent.Alignment.CENTER);

                return cardLayout;
            });

    public RfmSuggestionsVirtualList() {
        VirtualList<RfmUpdateSuggestion> list = new VirtualList<>();
        list.setItems(suggestions);
        list.setRenderer(suggestionsCardRenderer);
        add(list);
    }

}
