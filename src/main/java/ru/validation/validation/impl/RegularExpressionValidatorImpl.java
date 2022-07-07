package ru.validation.validation.impl;

import ru.validation.exception.ParameterParsingException;
import ru.validation.exception.ValidationException;
import ru.validation.validation.FieldValidator;
import ru.validation.validation.annotation.RegExp;

import java.lang.reflect.Field;


public class RegularExpressionValidatorImpl implements FieldValidator {

    @Override
    public void validate(Object entity, Field field) {
        if (String.class.isAssignableFrom(field.getType())) {
            RegExp annotation = field.getAnnotation(RegExp.class);
            String regex = annotation.value();
            try {
                String fieldValue = (String) field.get(entity);
                if (fieldValue != null && !fieldValue.matches(regex)) {
                    throw new ParameterParsingException(field.getName());
                }
            } catch (IllegalAccessException e) {
                throw new ValidationException(e);
            }
        }
    }
}