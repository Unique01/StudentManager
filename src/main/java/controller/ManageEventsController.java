package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Classe;
import model.Event;
import model.ItemJsonObject;
import model.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import service.ServiceClasse;
import service.ServiceEvent;

@Controller
public class ManageEventsController {
	
	@Autowired
	@Qualifier("EventValidator")
	private Validator validator;
	
	@ModelAttribute("subjects")
	public Subject[] subjects() {
		return Subject.values();
	}
	
    @InitBinder
	private void initBinder(WebDataBinder binder) {
    	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	    binder.setValidator(validator);
	}
    
	@RequestMapping(value = "/ManageEvents", method = RequestMethod.GET)
	public String initForm(ModelMap model) {
		Boolean eventAddedAlert = Boolean.FALSE;
		Boolean eventUpdatedAlert = Boolean.FALSE;
		Boolean classesAddedAlert = Boolean.FALSE;
		model.addAttribute("eventAddedAlert", eventAddedAlert);
		model.addAttribute("eventUpdatedAlert", eventUpdatedAlert);
		model.addAttribute("classesAddedAlert", classesAddedAlert);
		
		return "ManageEvents";	
	}
	
	@RequestMapping(value = "/createEvent", method = RequestMethod.GET)
	public String createEvent(ModelMap model) {
		Event event = new Event();
		model.addAttribute("event", event);

		return "CreateEvent";	
	}
	
	@RequestMapping(value = "/createEvent", method = RequestMethod.POST)
	public String submitCreateEventForm(Model model, @Validated Event event, BindingResult result) {
	    model.addAttribute("event", event);

	    String returnVal = "ManageEvents";
	    if(result.hasErrors()) {
	        returnVal = "CreateEvent";
	    } else {
	    	ServiceEvent.AddEvent(event);
		    Boolean eventAddedAlert = Boolean.TRUE;
	    	model.addAttribute("event", event);
		    model.addAttribute("eventAddedAlert", eventAddedAlert);	
	    }      
	    return returnVal;
	}
	
	@RequestMapping(value = "/seeEvent", method = RequestMethod.GET)
	public String seeEvent(@RequestParam("id") int id, ModelMap model) {
		Event event = ServiceEvent.getEventByIdEagerly(id);
		model.addAttribute("event", event);

		return "SeeEvent";	
	}
	
	@RequestMapping(value = "/updateEvent", method = RequestMethod.GET)
	public String updateEvent(@RequestParam("id") int id, ModelMap model) {
		Event event = ServiceEvent.getEventById(id);	
		
		model.addAttribute("event", event);

		return "UpdateEvent";	
	}
	
	@RequestMapping(value = "/updateEvent", method = RequestMethod.POST)
	public String submitUpdateEventForm(Model model, @Validated Event event, BindingResult result) {
	    model.addAttribute("event", event);
	    String returnVal = "ManageEvents";
	    if(result.hasErrors()) {
	        returnVal = "UpdateEvent";
	    } else {
	    	ServiceEvent.updateEvent(event);
	        model.addAttribute("event", event);
	        Boolean eventUpdatedAlert = Boolean.TRUE;
	        model.addAttribute("eventUpdatedAlert", eventUpdatedAlert);	 
	    }      
	    return returnVal;
	}

	
	@RequestMapping(value = "/deleteEvent", method = RequestMethod.GET)
	public String deleteEvent(@RequestParam("id") int id, ModelMap model) {
		Event event = ServiceEvent.getEventById(id);
		
		if(event!=null){
			ServiceEvent.deleteEvent(event);
		}
		
		model.addAttribute("event", event);
		return "ManageEvents";	
	}
	
	@RequestMapping(value = "/addClassesToEvent", method = RequestMethod.GET)
	public String addClassesToEvent(@RequestParam("id") int id, ModelMap model) {
		Event event = ServiceEvent.getEventById(id);
		List<Classe> classeList = ServiceClasse.getAllClasses();
		
		Collections.sort(classeList, new Comparator<Classe>() {
	        public int compare(Classe lhs, Classe rhs){
	            return lhs.getName().compareTo(rhs.getName());
	        }
	    });
				
		model.addAttribute("event", event);
		model.addAttribute("classeList", classeList);

		return "AddClassesToEvent";	
	}
	
	@RequestMapping(value = "/addClassesToEvent", method = RequestMethod.POST)
	public String submitAddClassesToEvent(HttpServletRequest request, ModelMap model) {
		
		/*String checkboxValues = request.getParameter("classesToAssociate");*/
		
		//Recupérer l'epreuve utilisé dans le formulaire
		
		/*List<String> list = new ArrayList<String>(Arrays.asList(checkboxValues.split(",")));*/
		
		//Utiliser les id de la liste "list" pour récupérer les classes en base et les ajouter dans notre objet Event
		//Mettre à jour l'evenement en base
		
		/*Boolean classesAddedAlert = Boolean.TRUE;
		model.addAttribute("classesAddedAlert", classesAddedAlert);*/
		
		return "ManageClasses";	
	}
	
	
	 @RequestMapping(value = "/springPaginationDataTablesEvents.web", method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody String springPaginationDataTables() throws IOException {
	 		 
		List<Event> eventList = ServiceEvent.getAllEvents();

		for (Event event : eventList) {
			event.setClasses(null);
		}
		
		ItemJsonObject eventJsonObject = new ItemJsonObject();	
		eventJsonObject.setiTotalDisplayRecords(ServiceEvent.getAllEvents().size());
		eventJsonObject.setiTotalRecords(ServiceEvent.getAllEvents().size());
		eventJsonObject.setAaData(eventList);
		    
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json2 = gson.toJson(eventJsonObject);

		return json2;
	 }
}
