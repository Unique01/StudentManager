package controller;

import javax.servlet.http.HttpServletRequest;

import model.Login;

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

import service.ServiceLogin;


@Controller
@RequestMapping("/")
public class LoginController {
	
	@Autowired
	@Qualifier("LoginValidator")
	private Validator validator;
	
    @InitBinder
	private void initBinder(WebDataBinder binder) {
    	
	    binder.setValidator(validator);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String initForm(ModelMap model, HttpServletRequest request) {
		model.addAttribute("login", new Login("myLogin@aa.aa","myPassword",""));		
        return "Login";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(Model model, @Validated Login login, BindingResult result) {
	    model.addAttribute("login", login);
	    String returnVal = "Login";
	    
	    Boolean isValid = ServiceLogin.checkCredentials(login);
	    	    
	    if(result.hasErrors()) {
	        returnVal = "Login";
	    } else {
	    	if(isValid){
	    		returnVal = "Home";
	    	} else {
	    		model.addAttribute("wrongCredentialAlert", true);   		
	    	}
	    }      
	    return returnVal;
	}
	 
}




