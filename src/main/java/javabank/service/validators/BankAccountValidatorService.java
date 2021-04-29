package javabank.service.validators;

import javabank.domain.BankAccount;
import javabank.domain.validators.ValidationException;

public class BankAccountValidatorService implements ValidatorService<BankAccount> {
    /**
     * Abstract method that validates a BankAccount entity upon adding
     * @param entity BankAccount, representing the entity to be validated
     * @throws ValidationException, an exception
     */
    @Override
    public void validateAdd(BankAccount entity) throws ValidationException {
        if (entity != null) {
            throw new ValidationException("The bank account to be added already exists!");
        }
    }

    /**
     * Abstract method that validates a BankAccount entity upon deletion
     * @param entity BankAccount, representing the entity to be validated
     * @throws ValidationException, an exception
     */
    @Override
    public void validateDelete(BankAccount entity) throws ValidationException {
        if (entity == null) {
            throw new ValidationException("The bank account to be deleted doesn't exists!");
        }
    }
}
