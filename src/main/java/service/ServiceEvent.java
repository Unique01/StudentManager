package service;

import java.util.List;

import dao.DAOEvent;
import model.Event;

public class ServiceEvent {

	public static List<Event> getAllEvents() {
		return DAOEvent.getAllEvents();
	}

	public static Event getEventById(int id) {	
		return DAOEvent.getEventById(id);
	}
	
	public static void AddEvent(Event event) {	
		DAOEvent.createEvent(event);
	}
	
	public static void updateEvent(Event event) {	
		DAOEvent.updateEvent(event);
	}

	public static void deleteEvent(Event event) {
		DAOEvent.deleteEvent(event);	
	}

	public static Event getEventByIdEagerly(int id) {
		return DAOEvent.getEventByIdEagerly(id);
	}

}
