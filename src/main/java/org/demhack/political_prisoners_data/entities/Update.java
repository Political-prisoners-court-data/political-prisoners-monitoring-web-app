package org.demhack.political_prisoners_data.entities;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;

public class Update {
    private int id;
    private PoliticalPrisoner politicalPrisoner;
    private String action;
    private String summary;

    private Date date = Date.from(Instant.now());

    public Update(int id) {
        this.id = id;
    }

    public Update(int id, PoliticalPrisoner politicalPrisoner, String action, String summary) {
        this.id = id;
        this.politicalPrisoner = politicalPrisoner;
        this.action = action;
        this.summary = summary;
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Update update = (Update) o;
        return id == update.id && Objects.equals(politicalPrisoner, update.politicalPrisoner) && Objects.equals(action, update.action) && Objects.equals(summary, update.summary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, politicalPrisoner, action, summary);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
