package com.itechart.library.webapp.validation;

import com.itechart.library.webapp.admin.form.UserForm;
import com.itechart.library.webapp.validation.annotation.EqualProperties;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Iterator;
import java.util.Objects;

public class EqualPropertiesValidator implements ConstraintValidator<EqualProperties, Object> {
    private String[] properties;

    @Override
    public void initialize(EqualProperties constraintAnnotation) {
        this.properties = constraintAnnotation.properties();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {
        Object[] values = extractValues(object);
        boolean result = isAllValuesEqual(values);
        if (!result) {
            context.disableDefaultConstraintViolation();
            for (String property : properties) {
                context
                        .buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                        .addPropertyNode(property).addConstraintViolation();
            }

        }
        return result;
    }

    private Object[] extractValues(Object object) {
        BeanWrapper bean = new BeanWrapperImpl(object);
        Object[] values = new String[properties.length];
        for (int i = 0; i < properties.length; i++) {
            values[i] = bean.getPropertyValue(properties[i]);
        }
        return values;
    }

    private boolean isAllValuesEqual(Object[] values) {
        for (int i = 0; i < values.length - 1; i++) {
            if (!Objects.equals(values[i], values[i + 1])) {
                return false;
            }
        }
        return true;

    }
}
