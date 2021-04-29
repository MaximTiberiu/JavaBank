package javabank.service.validators;

import javabank.domain.Client;
import javabank.domain.validators.ValidationException;

public class ClientValidatorService implements ValidatorService<Client> {
    /**
     * Abstract method that validates a Client entity upon adding
     * @param entity Client, representing the entity to be validated
     * @throws ValidationException, an exception
     */
    @Override
    public void validateAdd(Client entity) throws ValidationException {
        if (entity != null) {
            throw new ValidationException("The cleint to be added already exists!");
        }
    }

    /**
     * Abstract method that validates a Client entity upon deletion
     * @param entity Client, representing the entity to be validated
     * @throws ValidationException, an exception
     */
    @Override
    public void validateDelete(Client entity) throws ValidationException {
        if (entity == null) {
            throw new ValidationException("The client to be deleted doesn't exists!");
        }
    }
}
