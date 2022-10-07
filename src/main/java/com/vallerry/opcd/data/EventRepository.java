package com.vallerry.opcd.data;

import com.vallerry.opcd.model.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {
}
