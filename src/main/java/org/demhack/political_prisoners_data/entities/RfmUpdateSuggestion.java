package org.demhack.political_prisoners_data.entities;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

public class RfmUpdateSuggestion {
    private int id;
    private PoliticalPrisoner politicalPrisoner;

    private String action;

    private Date date;
    private String rfmListItemText;

    public RfmUpdateSuggestion(int id, PoliticalPrisoner politicalPrisoner) {
        this.id = id;
        this.setPoliticalPrisoner(politicalPrisoner);
        this.setAction("Добавление в реестр РФМ");
        Date rfmTimestamp = new GregorianCalendar(
                2023, Calendar.DECEMBER,
                13,
                13,
                12
        ).getTime();
        this.setDate(rfmTimestamp);
        this.setRfmListItemText("Иванов Иван *, 14.10.1989, Г.БЕЛГОРОД");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PoliticalPrisoner getPoliticalPrisoner() {
        return politicalPrisoner;
    }

    public void setPoliticalPrisoner(PoliticalPrisoner politicalPrisoner) {
        this.politicalPrisoner = politicalPrisoner;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRfmListItemText() {
        return rfmListItemText;
    }

    public void setRfmListItemText(String rfmListItemText) {
        this.rfmListItemText = rfmListItemText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RfmUpdateSuggestion that = (RfmUpdateSuggestion) o;
        return id == that.id && Objects.equals(politicalPrisoner, that.politicalPrisoner) && Objects.equals(action, that.action) && Objects.equals(date, that.date) && Objects.equals(rfmListItemText, that.rfmListItemText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, politicalPrisoner, action, date, rfmListItemText);
    }
}
