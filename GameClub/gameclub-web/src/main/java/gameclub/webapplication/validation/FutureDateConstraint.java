package gameclub.webapplication.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = FutureDateValidator.class)
@Target( { ElementType.TYPE, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface FutureDateConstraint {
    String message() default "Date must be in the future!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
