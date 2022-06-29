package gameclub.webapplication.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

public class FutureDateValidator implements ConstraintValidator<FutureDateConstraint, String> {
    @Override
    public void initialize(FutureDateConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value.isEmpty()){
            return false;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd").withResolverStyle(ResolverStyle.SMART);
        LocalDate date = LocalDate.parse(value, formatter);
        if(LocalDate.now().isBefore(date))
            return true;
        else return false;
    }
}
