package javabank.service.validators;

import javabank.domain.validators.ValidationException;

public interface ValidatorService<T> {
    /**
     * Abstract method that validates a T entity upon adding
     * @param entity T, representing the entity to be validated
     * @throws ValidationException, an excelption
     */
    void validateAdd(T entity) throws ValidationException;

    /**
     * Abstract method that validates a T entity upon deletion
     * @param entity T, representing the entity to be validated
     * @throws ValidationException, an excelption
     */
    void validateDelete(T entity) throws ValidationException;
}
