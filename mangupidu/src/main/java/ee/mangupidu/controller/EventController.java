package ee.mangupidu.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ee.mangupidu.service.EventService;

@Controller
@RequestMapping("/events")
public class EventController {
	
	@Resource
	private EventService eventService;
 
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		String eventTitle = eventService.getAllEvents().get(0).getDescription();
		model.addAttribute("message", "First event is: " + eventTitle );
		return "events";
 
	}
 
}