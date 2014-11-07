package validator;

import model.Student;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator {
	
	private static final String FLOAT_PATTERN = "^\\d\\.\\d{1,3}$";
	
	public boolean supports(Class<?> aClass) {
		return Student.class.equals(aClass);
	}
 
	public void validate(Object obj, Errors errors) {
		Student student = (Student) obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mean", "field.required");
		if(!String.valueOf(student.getMean()).matches(FLOAT_PATTERN)) {
			errors.rejectValue("mean","valid.mean");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birthDate", "field.required");

	}
}
