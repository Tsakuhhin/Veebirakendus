package ee.mangupidu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ee.mangupidu.dao.EventDao;
import ee.mangupidu.model.Event;
import ee.mangupidu.service.EventService;

@Service
public class EventServiceImpl implements EventService{
	
	@Resource
	private EventDao eventDao;

	@Override
	public List<Event> getAllEvents() {
		return eventDao.getAllEvents();
	}

	@Override
	public Event getEvent(Long eventId) {
		return eventDao.getEvent(eventId);
	}

	@Override
	public void saveEvent(Event event) {
		if(event.getId() == null){
			eventDao.addEvent(event);
		}else{
			eventDao.updateEvent(event);
		}
		
	}

	@Override
	public void deleteEvent(Long eventId) {
		eventDao.deleteEvent(eventId);
	}

}
