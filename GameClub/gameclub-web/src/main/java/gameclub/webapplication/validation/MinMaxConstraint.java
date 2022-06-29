package gameclub.webapplication.validation;



import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MinMaxValidator.class)
@Target( { ElementType.TYPE, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface MinMaxConstraint {
    String message() default "Maximum value must be bigger than the minimum value";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
