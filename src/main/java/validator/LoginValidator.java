package validator;

import model.Login;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class LoginValidator implements Validator {
	public boolean supports(Class<?> aClass) {
		return Login.class.equals(aClass);
	}
 
	public void validate(Object obj, Errors errors) {
		//Login login = (Login) obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "safePassword", "field.required");

	}
}
