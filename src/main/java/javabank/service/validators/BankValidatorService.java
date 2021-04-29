package javabank.service.validators;

import javabank.domain.Bank;
import javabank.domain.validators.ValidationException;

public class BankValidatorService implements ValidatorService<Bank> {

    /**
     * Abstract method that validates a Bank entity upon adding
     * @param entity Bank, representing the entity to be validated
     * @throws ValidationException, an exception
     */
    @Override
    public void validateAdd(Bank entity) throws ValidationException {
        if (entity != null) {
            throw new ValidationException("The bank to be added already exists!");
        }
    }

    /**
     * Abstract method that validates a Bank entity upon deletion
     * @param entity Bank, representing the entity to be validated
     * @throws ValidationException, an exception
     */
    @Override
    public void validateDelete(Bank entity) throws ValidationException {
        if (entity == null) {
            throw new ValidationException("The bank to be deleted doesn't exists!");
        }
    }
}
