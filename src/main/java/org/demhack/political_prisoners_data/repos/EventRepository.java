package org.demhack.political_prisoners_data.repos;

import org.demhack.political_prisoners_data.entities.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepository extends MongoRepository<Event, String> {
    Iterable<Event> findByAction(String action);
}
