package org.demhack.political_prisoners_data.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

@Document(collection = "events")
@Getter @Setter @NoArgsConstructor
public class Event {
    @MongoId
    private String id;

    @Indexed
    private String fullName;

    @Indexed
    private Date birthDate;

    private boolean isTerr;

    private String address;

    private String action;

    private Date date;

    @Override
    public String toString() {
        return "Event{" +
                "fullName='" + fullName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
