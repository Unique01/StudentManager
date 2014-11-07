package validator;

import model.Classe;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ClasseValidator implements Validator {
	public boolean supports(Class<?> aClass) {
		return Classe.class.equals(aClass);
	}
 
	public void validate(Object obj, Errors errors) {
		//Classe classe = (Classe) obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "year", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "adress", "field.required");

	}
}
