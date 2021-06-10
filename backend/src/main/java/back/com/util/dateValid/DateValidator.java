package back.com.util.dateValid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.SimpleDateFormat;

public class DateValidator implements ConstraintValidator<DateValid, String> {

    @Override
    public void initialize(DateValid constraintAnnotation) {
    }

    @Override
    public boolean isValid(String field, ConstraintValidatorContext context) {
        try {
            new SimpleDateFormat("yyyy-MM-dd").parse(field);
        } catch (Exception ex) {
            return false;
        }

        return true;
    }


}
