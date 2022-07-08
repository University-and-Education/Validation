package ru.validation.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.validation.validation.FieldValidator;
import ru.validation.validation.ParamValidator;
import ru.validation.validation.annotation.NotEmpty;
import ru.validation.validation.annotation.RegExp;
import ru.validation.validation.impl.AnnotationBasedParamValidatorImpl;
import ru.validation.validation.impl.NotEmptyValidatorImpl;
import ru.validation.validation.impl.RegularExpressionValidatorImpl;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class ValidationConfiguration {

    @Bean
    public ParamValidator getParamValidator() {
        Map<Class<? extends Annotation>, FieldValidator> validatorMap = new HashMap<>();
        validatorMap.put(RegExp.class, new RegularExpressionValidatorImpl());
        validatorMap.put(NotEmpty.class, new NotEmptyValidatorImpl());
        return new AnnotationBasedParamValidatorImpl(validatorMap);
    }
}