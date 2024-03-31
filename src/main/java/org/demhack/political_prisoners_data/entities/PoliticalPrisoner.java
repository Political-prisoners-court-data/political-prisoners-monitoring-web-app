package org.demhack.political_prisoners_data.entities;

import java.util.*;

public class PoliticalPrisoner implements Comparable<PoliticalPrisoner> {
    private int id;
    private String fullName;
    private String caseName;
    private String region;
    private String city;
    private int age;
    private boolean rfm;
    private Date inclusionDate;
    private Date exclusionDate;
    private boolean hasUpdates;

    public String getAirtableId() {
        return airtableId;
    }

    public void setAirtableId(String airtableId) {
        this.airtableId = airtableId;
    }

    private String airtableId = "reclipz2ETFw74FOW";

    public PoliticalPrisoner(int id, String fullName, String caseName, String region, String city, int age, boolean rfm, Date inclusionDate, Date exclusionDate, boolean hasUpdates) {
        this.id = id;
        this.fullName = fullName;
        this.caseName = caseName;
        this.region = region;
        this.city = city;
        this.age = age;
        this.rfm = rfm;
        this.inclusionDate = inclusionDate;
        this.exclusionDate = exclusionDate;
        this.hasUpdates = hasUpdates;
    }

    public PoliticalPrisoner(int id) {
        this(id, "Иванов Иван Иваныч", "Дело Ермолаева и других в Чите", "Забайкальский край", "Краснокаменск", 64, false, new GregorianCalendar(2018, Calendar.MARCH, 12).getTime(), new GregorianCalendar(2019, Calendar.FEBRUARY, 18).getTime(), true);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isRfm() {
        return rfm;
    }

    public void setRfm(boolean rfm) {
        this.rfm = rfm;
    }

    public Date getInclusionDate() {
        return inclusionDate;
    }

    public void setInclusionDate(Date inclusionDate) {
        this.inclusionDate = inclusionDate;
    }

    public Date getExclusionDate() {
        return exclusionDate;
    }

    public void setExclusionDate(Date exclusionDate) {
        this.exclusionDate = exclusionDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PoliticalPrisoner that = (PoliticalPrisoner) o;
        return id == that.id && age == that.age && rfm == that.rfm && hasUpdates == that.hasUpdates && Objects.equals(fullName, that.fullName) && Objects.equals(caseName, that.caseName) && Objects.equals(region, that.region) && Objects.equals(city, that.city) && Objects.equals(inclusionDate, that.inclusionDate) && Objects.equals(exclusionDate, that.exclusionDate) && Objects.equals(airtableId, that.airtableId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, caseName, region, city, age, rfm, inclusionDate, exclusionDate, hasUpdates, airtableId);
    }

    public boolean hasUpdates() {
        return hasUpdates;
    }

    public void setHasUpdates(boolean hasUpdates) {
        this.hasUpdates = hasUpdates;
    }


    @Override
    public int compareTo(PoliticalPrisoner o) {
        return Comparator.comparing(PoliticalPrisoner::hasUpdates)
                .reversed()
                .thenComparing(PoliticalPrisoner::getExclusionDate)
                .thenComparing(PoliticalPrisoner::getInclusionDate)
                .compare(this, o);
    }
}
