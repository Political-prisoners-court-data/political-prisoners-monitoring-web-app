package org.demhack.political_prisoners_data.frontend.layouts.main;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.virtuallist.VirtualList;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.dom.ElementFactory;
import org.demhack.political_prisoners_data.entities.PoliticalPrisoner;
import org.demhack.political_prisoners_data.services.DataService;

import java.text.SimpleDateFormat;
import java.util.List;

public class PoliticalPrisonersVirtualList extends VerticalLayout {

    private List<PoliticalPrisoner> people = DataService.getPeople();

    private ComponentRenderer<Component, PoliticalPrisoner> personCardRenderer = new ComponentRenderer<>(
            politicalPrisoner -> {
                HorizontalLayout cardLayout = new HorizontalLayout();
                cardLayout.setMargin(true);

                VerticalLayout infoLayout = new VerticalLayout();
                infoLayout.setSpacing(true);
                infoLayout.setPadding(true);
                infoLayout.setAlignItems(FlexComponent.Alignment.CENTER);
                infoLayout.getElement().appendChild(
                        ElementFactory.createStrong(politicalPrisoner.getFullName()));


                var cityBadge = new Span("Город: " + politicalPrisoner.getCity());
                cityBadge.getElement().getThemeList().add("badge error pill");

                var dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
                var inclusionDateBadge = new Span("Дата поступления: "
                        + dateFormatter.format(politicalPrisoner.getInclusionDate()));
                inclusionDateBadge.getElement().getThemeList().add("badge success pill");


                var badgeLayoutUp = new HorizontalLayout(cityBadge, inclusionDateBadge);
                badgeLayoutUp.setSpacing(true);
                infoLayout.add(badgeLayoutUp);

                var exclusionDateBadge = new Span ("Дата заседания: "
                        + dateFormatter.format(politicalPrisoner.getExclusionDate()));
                exclusionDateBadge.getElement().getThemeList().add("badge pill");

                var caseBadge = new Span(politicalPrisoner.getCaseName());
                caseBadge.getElement().getThemeList().add("badge contrast pill");
                var badgeLayoutDown = new HorizontalLayout(exclusionDateBadge, caseBadge);
                badgeLayoutDown.setSpacing(true);
                infoLayout.add(badgeLayoutDown);

                var iconsLayout = new HorizontalLayout();
                iconsLayout.setSpacing(true);
                if (politicalPrisoner.hasUpdates()) {
                    Icon updatedIcon = VaadinIcon.WARNING.create();
                    updatedIcon.getElement()
                            .getThemeList()
                            .add("badge error");
                    iconsLayout.add(updatedIcon);

                }
                iconsLayout.add(VaadinIcon.EXTERNAL_LINK.create());

                infoLayout.add(iconsLayout);
                infoLayout.getElement().getThemeList().add("badge contrast");

                cardLayout.add(infoLayout);

                cardLayout.setAlignItems(Alignment.CENTER);

                return cardLayout;
            });

    public PoliticalPrisonersVirtualList() {
        VirtualList<PoliticalPrisoner> list = new VirtualList<>();
        list.setItems(people);
        list.setRenderer(personCardRenderer);
        add(list);
    }

}
