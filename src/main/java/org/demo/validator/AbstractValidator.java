/*
 * Created on 3 avr. 2014 ( Time 19:43:47 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */

package org.demo.validator;

import org.springframework.util.ClassUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.lang.reflect.ParameterizedType;

/**
 * Class to facilitate validator declaration.
 * 
 * @author Telosys Tools Generator
 *
 */
public abstract class AbstractValidator<T> implements Validator {

   /**
     * Verify if this validator is assignable to the target object.
     * @param aClass Class to validate
     * @return true if assignable
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean supports(Class<?> aClass) {
        Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return ClassUtils.isAssignable(aClass, clazz);
    }

    /**
     * Execute validations to the target object.
     * @param object Object to validate
     * @param errors Errors
     */
    @SuppressWarnings("unchecked")
    @Override
    public void validate(Object object, Errors errors) {
        T entity = (T) object;
        validateEntity(entity, errors);
    }

    /**
     * Method call by all entities to be validated.
     * @param entity Entity to validate
     * @param errors Errors
     */
    public abstract void validateEntity(T entity, Errors errors);
}