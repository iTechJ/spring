package com.itechart.library.webapp.validation.annotation;

import com.itechart.library.webapp.validation.EqualPropertiesValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EqualPropertiesValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface EqualProperties {

    String[] properties() default {};

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
