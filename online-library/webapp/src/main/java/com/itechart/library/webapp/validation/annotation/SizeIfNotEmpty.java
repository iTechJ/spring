package com.itechart.library.webapp.validation.annotation;

import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.Length;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Size;
import java.lang.annotation.*;

@ConstraintComposition(CompositionType.OR)

@Size(max = 0)
@Length
@Documented
@Constraint(validatedBy = {})
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ReportAsSingleViolation
public @interface SizeIfNotEmpty {

    @OverridesAttribute.List({
            @OverridesAttribute(constraint = Size.class, name = "message"),
            @OverridesAttribute(constraint = Length.class, name = "message")}) String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @OverridesAttribute(constraint = Length.class, name = "min") int min() default 0;

    @OverridesAttribute(constraint = Length.class, name = "max") int max() default Integer.MAX_VALUE;
}
