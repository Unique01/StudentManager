package validator;

import model.Event;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EventValidator implements Validator {
	
	private static final String FLOAT_PATTERN = "^\\d\\.\\d{1,3}$";

	public boolean supports(Class<?> aClass) {
		return Event.class.equals(aClass);
	}
 
	public void validate(Object obj, Errors errors) {
		Event event = (Event) obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "date", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subject", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mark", "field.required");
		if(!String.valueOf(event.getMark()).matches(FLOAT_PATTERN)) {
			errors.rejectValue("mark","valid.mark");
		}

	}
}
