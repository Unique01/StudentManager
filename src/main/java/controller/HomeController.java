package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.ServiceLogin;

@Controller
@RequestMapping("/Home")
public class HomeController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String hello(ModelMap model) {
		if(ServiceLogin.sessionVar==null){
			return "Login";
		}
		
		return "Home";

	}
}
