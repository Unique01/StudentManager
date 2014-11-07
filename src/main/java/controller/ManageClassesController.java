package controller;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


import javax.servlet.http.HttpServletRequest;

import model.Classe;
import model.ItemJsonObject;
import model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

import service.ServiceClasse;
import service.ServiceStudent;

@Controller
public class ManageClassesController {
	
	@Autowired
	@Qualifier("ClasseValidator")
	private Validator validator;
	
    @InitBinder
	private void initBinder(WebDataBinder binder) {
	    binder.setValidator(validator);
	}
    
	@RequestMapping(value = "/ManageClasses", method = RequestMethod.GET)
	public String initForm(ModelMap model) {
		Boolean classeAddedAlert = Boolean.FALSE;
		Boolean classeUpdatedAlert = Boolean.FALSE;
		Boolean studentsAddedAlert = Boolean.FALSE;
		model.addAttribute("classeAddedAlert", classeAddedAlert);
		model.addAttribute("classeUpdatedAlert", classeUpdatedAlert);
		model.addAttribute("classeUpdatedAlert", studentsAddedAlert);
		
		return "ManageClasses";	
	}
	
	@RequestMapping(value = "/createClasse", method = RequestMethod.GET)
	public String createClasse(ModelMap model) {
		Classe myClasse = new Classe();
		model.addAttribute("classe", myClasse);

		return "CreateClasse";	
	}
	
	@RequestMapping(value = "/createClasse", method = RequestMethod.POST)
	public String submitCreateClasseForm(Model model, @Validated Classe classe, BindingResult result) {
	    model.addAttribute("classe", classe);
	    //classe.setStudents(null);
	    String returnVal = "ManageClasses";
	    if(result.hasErrors()) {
	        returnVal = "CreateClasse";
	    } else {
	    	ServiceClasse.AddClasse(classe);
		    Boolean classeAddedAlert = Boolean.TRUE;
	    	model.addAttribute("classe", classe);
		    model.addAttribute("classeAddedAlert", classeAddedAlert);	
	    }      
	    return returnVal;
	}
	
	@RequestMapping(value = "/seeClasse", method = RequestMethod.GET)
	public String seeClasse(@RequestParam("id") int id, ModelMap model) {
		Classe myClasse = ServiceClasse.getClasseByIdEagerly(id);
		model.addAttribute("classe", myClasse);

		return "SeeClasse";	
	}
	
	@RequestMapping(value = "/updateClasse", method = RequestMethod.GET)
	public String updateClasse(@RequestParam("id") int id, ModelMap model) {
		Classe myClasse = ServiceClasse.getClasseById(id);	
		
		model.addAttribute("classe", myClasse);
		return "UpdateClasse";	
	}
	
	@RequestMapping(value = "/updateClasse", method = RequestMethod.POST)
	public String submitUpdateClasseForm(Model model, @Validated Classe classe, BindingResult result) {
	    model.addAttribute("classe", classe);
	    String returnVal = "ManageClasses";
	    if(result.hasErrors()) {
	        returnVal = "UpdateClasse";
	    } else {
	    	ServiceClasse.updateClasse(classe);
	        model.addAttribute("classe", classe);
	        Boolean classeUpdatedAlert = Boolean.TRUE;
	        model.addAttribute("classeUpdatedAlert", classeUpdatedAlert);	 
	    }      
	    return returnVal;
	}

	
	@RequestMapping(value = "/deleteClasse", method = RequestMethod.GET)
	public String deleteClasse(@RequestParam("id") int id, ModelMap model) {
		Classe myClasse = ServiceClasse.getClasseById(id);
		
		if(myClasse!=null){
			ServiceClasse.deleteClasse(myClasse);
		}
		
		model.addAttribute("classe", myClasse);
		return "ManageClasses";	
	}
	
	@RequestMapping(value = "/addStudentsToClasse", method = RequestMethod.GET)
	public String addStudentsToClasse(@RequestParam("id") int id, ModelMap model) {
		Classe myClasse = ServiceClasse.getClasseById(id);
		List<Student> studentList = ServiceStudent.getAllStudents();
		
		Collections.sort(studentList, new Comparator<Student>() {
	        public int compare(Student lhs, Student rhs){
	            return lhs.getSurname().compareTo(rhs.getSurname());
	        }
	    });
				
		model.addAttribute("classe", myClasse);
		model.addAttribute("studentList", studentList);

		return "AddStudentsToClasse";	
	}
	
	@RequestMapping(value = "/addStudentsToClasse", method = RequestMethod.POST)
	public String submitAddStudentsToClasse(HttpServletRequest request, ModelMap model) {

		/*String checkboxValues = request.getParameter("studentsToAssociate");*/
		
		//Recupérer la classe utilisé dans le formulaire
		
		/*List<String> list = new ArrayList<String>(Arrays.asList(checkboxValues.split(",")));*/
		
		//Utiliser les id de la liste "list" pour récupérer les étudiants en base et les ajouter dans notre classe
		//Mettre à jour la classe en base
		
		/*Boolean studentsAddedAlert = Boolean.TRUE;
		model.addAttribute("studentsAddedAlert", studentsAddedAlert);*/
		
		return "ManageClasses";	
	}
	
	
	 @RequestMapping(value = "/springPaginationDataTablesClasses.web", method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody String springPaginationDataTables() throws IOException {
	 		 
		List<Classe> classeList = ServiceClasse.getAllClasses();

		for (Classe classe : classeList) {
			classe.setStudents(null);
		}
		
		ItemJsonObject classeJsonObject = new ItemJsonObject();	
		classeJsonObject.setiTotalDisplayRecords(ServiceClasse.getAllClasses().size());
		classeJsonObject.setiTotalRecords(ServiceClasse.getAllClasses().size());
		classeJsonObject.setAaData(classeList);
		    
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json2 = gson.toJson(classeJsonObject);

		return json2;
	 }
}
