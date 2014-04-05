package ee.mangupidu.dao;

import java.util.List;

import ee.mangupidu.model.Event;

public interface EventDao {
	
	List<Event> getAllEvents();
	
	Event getEvent(Long eventId);
	
	void addEvent(Event event);
	
	void updateEvent(Event event);
	
	void deleteEvent(Long eventId);
	

}
