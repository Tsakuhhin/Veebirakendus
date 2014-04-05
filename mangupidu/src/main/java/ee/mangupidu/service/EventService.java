package ee.mangupidu.service;

import java.util.List;

import ee.mangupidu.model.Event;

public interface EventService {
	
	List<Event> getAllEvents();
	
	Event getEvent(Long eventId);
	
	void saveEvent(Event event);
	
	void deleteEvent(Long eventId);
	
}
