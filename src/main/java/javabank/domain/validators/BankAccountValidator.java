package javabank.domain.validators;

import javabank.domain.BankAccount;

import java.text.ParseException;

public class BankAccountValidator implements Validator<BankAccount> {
    /**
     * Method that validates a BankAccount entity
     *
     * @param entity BankAccount, representing the entity to be validate
     * @throws ValidationException, if the BankAccount is invalid
     */
    @Override
    public void validate(BankAccount entity) throws ValidationException {
        // TODO: iban validation

    }
}
