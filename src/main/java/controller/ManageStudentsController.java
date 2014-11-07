package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;



import javax.servlet.http.HttpServletRequest;

import model.Event;
import model.ItemJsonObject;
import model.Student;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import service.ServiceEvent;
import service.ServiceStudent;

@Controller
public class ManageStudentsController {
	
	@Autowired
	@Qualifier("StudentValidator")
	private Validator validator;
	
    @InitBinder
	private void initBinder(WebDataBinder binder) {
    	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	    binder.setValidator(validator);
	}
    
	@RequestMapping(value = "/ManageStudents", method = RequestMethod.GET)
	public String initForm(ModelMap model) {
		Boolean studentAddedAlert = Boolean.FALSE;
		Boolean studentUpdatedAlert = Boolean.FALSE;
		Boolean eventsAddedAlert = Boolean.FALSE;
		model.addAttribute("studentAddedAlert", studentAddedAlert);
		model.addAttribute("studentUpdatedAlert", studentUpdatedAlert);
		model.addAttribute("eventsAddedAlert", eventsAddedAlert);

		
		return "ManageStudents";	
	}
	
	@RequestMapping(value = "/createStudent", method = RequestMethod.GET)
	public String createStudent(ModelMap model) {
		Student student = new Student();
		model.addAttribute("student", student);

		return "CreateStudent";	
	}
	
	@RequestMapping(value = "/createStudent", method = RequestMethod.POST)
	public String submitCreateStudentForm(Model model, @Validated Student student, BindingResult result) {
	    model.addAttribute("student", student);

	    String returnVal = "ManageStudents";
	    if(result.hasErrors()) {
	        returnVal = "CreateStudent";
	    } else {
	    	ServiceStudent.AddStudent(student);
		    Boolean studentAddedAlert = Boolean.TRUE;
	    	model.addAttribute("student", student);
		    model.addAttribute("studentAddedAlert", studentAddedAlert);	
	    }      
	    return returnVal;
	}
	
	@RequestMapping(value = "/seeStudent", method = RequestMethod.GET)
	public String seeStudent(@RequestParam("id") int id, ModelMap model) {
		Student student = ServiceStudent.getStudentByIdEagerly(id);
		model.addAttribute("student", student);

		return "SeeStudent";	
	}
	
	@RequestMapping(value = "/setEventMark", method = RequestMethod.GET)
	public String setEventMark(@RequestParam("id") int id, ModelMap model) {
		Student student = ServiceStudent.getStudentByIdEagerly(id);
		model.addAttribute("student", student);

		return "SetEventMark";	
	}
	
	@RequestMapping(value = "/setEventMark", method = RequestMethod.POST)
	public String submitSetEventMark(HttpServletRequest request, ModelMap model) {
		//Tout simplement mettre les données recupérées dans l'objet étudiant manipulé puis l'injecter en base

		//student.calculateMean();
		
		return "ManageStudents";	
	}
	
	@RequestMapping(value = "/updateStudent", method = RequestMethod.GET)
	public String updateStudent(@RequestParam("id") int id, ModelMap model) {
		Student student = ServiceStudent.getStudentById(id);	
		
		model.addAttribute("student", student);
		return "UpdateStudent";	
	}
	
	@RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
	public String submitUpdateStudentForm(Model model, @Validated Student student, BindingResult result) {
	    model.addAttribute("student", student);
	    String returnVal = "ManageStudents";
	    if(result.hasErrors()) {
	        returnVal = "UpdateStudent";
	    } else {
	    	ServiceStudent.updateStudent(student);
	        model.addAttribute("student", student);
	        Boolean studentUpdatedAlert = Boolean.TRUE;
	        model.addAttribute("studentUpdatedAlert", studentUpdatedAlert);	 
	    }      
	    return returnVal;
	}

	
	@RequestMapping(value = "/deleteStudent", method = RequestMethod.GET)
	public String deleteStudent(@RequestParam("id") int id, ModelMap model) {
		Student student = ServiceStudent.getStudentById(id);
		
		if(student!=null){
			ServiceStudent.deleteStudent(student);
		}
		
		model.addAttribute("student", student);
		return "ManageStudents";	
	}
	
	@RequestMapping(value = "/addEventsToStudent", method = RequestMethod.GET)
	public String addEventsToStudent(@RequestParam("id") int id, ModelMap model) {
		Student student = ServiceStudent.getStudentById(id);
		List<Event> eventList = ServiceEvent.getAllEvents();
		
		Collections.sort(eventList, new Comparator<Event>() {
	        public int compare(Event lhs, Event rhs){
	            return lhs.getSubject().compareTo(rhs.getSubject());
	        }
	    });
				
		model.addAttribute("student", student);
		model.addAttribute("eventList", eventList);

		return "AddEventsToStudent";	
	}
	
	@RequestMapping(value = "/addEventsToStudent", method = RequestMethod.POST)
	public String submitAddEventsToStudent(HttpServletRequest request, ModelMap model) {

		/*String checkboxValues = request.getParameter("eventsToAssociate");*/
		
		//Recupérer l'étudiant utilisé dans le formulaire
		
		/*List<String> list = new ArrayList<String>(Arrays.asList(checkboxValues.split(",")));*/
		
		//Utiliser les id de la liste "list" pour récupérer les épreuves en base et les ajouter dans notre objet student
		//Mettre à jour l'étudient en base
		
		/*Boolean eventsAddedAlert = Boolean.TRUE;
		model.addAttribute("eventsAddedAlert", eventsAddedAlert);*/
		
		return "ManageStudents";	
	}
	
	 @RequestMapping(value = "/springPaginationDataTablesStudents.web", method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody String springPaginationDataTables() throws IOException {
	 		 
		List<Student> studentList = ServiceStudent.getAllStudents();

		for (Student student : studentList) {
			student.setEvents(null);
			student.setClasse(null);
		}
		
		ItemJsonObject studentJsonObject = new ItemJsonObject();	
		studentJsonObject.setiTotalDisplayRecords(ServiceStudent.getAllStudents().size());
		studentJsonObject.setiTotalRecords(ServiceStudent.getAllStudents().size());
		studentJsonObject.setAaData(studentList);
		    
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json2 = gson.toJson(studentJsonObject);

		return json2;
	 }
}
