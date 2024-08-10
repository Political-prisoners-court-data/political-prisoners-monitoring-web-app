package org.demhack.political_prisoners_data.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "events")
@Getter @Setter @NoArgsConstructor
public class Event {
    @MongoId
    private String id;

    @Indexed
    private String fullName;

    @Indexed
    private LocalDate birthDate;

    private boolean isTerr;

    private String address;

    private String action;

    private List<String> aliases;

    private LocalDateTime date;

    private boolean oldIsTerr;

    private boolean newIsTerr;

    private List<String> oldAliases;

    private List<String> newAliases;

    private String oldAddress;

    private String newAddress;

    @Override
    public String toString() {
        return "Event{" +
                "fullName='" + fullName + '\'' +
                ", birthDate=" + birthDate +
                ", action='" + action + '\'' +
                ", date=" + date +
                '}';
    }
}
