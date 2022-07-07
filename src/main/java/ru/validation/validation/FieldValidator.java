package ru.validation.validation;

import java.lang.reflect.Field;

public interface FieldValidator {

    void validate(Object entity, Field field);
}