package javabank.service.validators;

import javabank.domain.BankBranch;
import javabank.domain.validators.ValidationException;

public class BankBranchValidatorService implements ValidatorService<BankBranch> {
    /**
     * Abstract method that validates a T entity upon adding
     *
     * @param entity T, representing the entity to be validated
     * @throws ValidationException, an exception
     */
    @Override
    public void validateAdd(BankBranch entity) throws ValidationException {
        if (entity != null) {
            throw new ValidationException("The bank branch to be added already exists!");
        }
    }

    /**
     * Abstract method that validates a T entity upon deletion
     *
     * @param entity T, representing the entity to be validated
     * @throws ValidationException, an exception
     */
    @Override
    public void validateDelete(BankBranch entity) throws ValidationException {
        if (entity == null) {
            throw new ValidationException("The bank branch to be deleted doesn't exists!");
        }
    }
}
