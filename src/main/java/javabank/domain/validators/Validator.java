package javabank.domain.validators;


import java.text.ParseException;

public interface Validator<E> {
    /**
     * Abstract method that validates an E entity
     * @param entity E, representing the entity to be validate
     * @throws ValidationException, representing an exception
     * @throws ParseException, representing an exception
     */
    void validate(E entity) throws ValidationException, ParseException;
}
