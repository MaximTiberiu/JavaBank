package javabank.domain.validators;

import javabank.domain.banking.operations.Operation;

import java.text.ParseException;

public class OperationValidator implements Validator<Operation> {

    /**
     * Abstract method that validates an E entity
     *
     * @param entity Operation, representing the entity to be validate
     * @throws ValidationException, representing an exception
     */
    @Override
    public void validate(Operation entity) throws ValidationException {
        // TODO: operation validation
    }
}
