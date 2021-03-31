package javabank.domain.validators;

import javabank.domain.BankAccount;
import javabank.domain.Client;
import javabank.utils.validators.CNPValidator;
import javabank.utils.validators.EmailValidator;
import javabank.utils.validators.TelephoneNumberValidator;

import java.text.ParseException;
import java.util.ArrayList;

public class ClientValidator implements Validator<Client> {
    /**
     * Method that validates a Client entity
     *
     * @param entity Client, representing the entity to be validate
     * @throws ValidationException, if the Client is invalid
     * @throws ParseException, if the CNP is not valid
     */
    @Override
    public void validate(Client entity) throws ValidationException, ParseException {
        String errors = "";

        if (entity.getId() < 0) {
            errors += "The ID of the Client can't be a negative number!\n";
        }
        if (!entity.getFirstName().matches("^[a-zA-Z\\s]*$")) {
            errors += "The first name of the Client can't be an empty value and it can't contain digits!\n";
        }
        if (!entity.getLastName().matches("^[a-zA-Z\\s]*$")) {
            errors += "The last name of the Client can't be an empty value and it can't contain digits!\n";
        }
        if (!CNPValidator.validateCNP(entity.getCNP())) {
            errors += "The CNP of the Client is invalid!\n";
        }
        if (!TelephoneNumberValidator.validateTelephoneNumber(entity.getTelephoneNumber())) {
            errors += "The telephone number is invalid!\n";
        }
        if(!EmailValidator.validateEmail(entity.getEmail())) {
            errors += "The email address is invalid!\n";
        }

        // TODO: client credentials validation

        try {
            ArrayList<BankAccount> bankAccounts = entity.getBankAccounts();
            BankAccountValidator bankAccountValidator = new BankAccountValidator();

            for (BankAccount bankAccount: bankAccounts) {
                bankAccountValidator.validate(bankAccount);
            }

        }
        catch (ValidationException validationException) {
            errors += validationException.toString();
        }

        if (errors.length() > 0) {
            throw new ValidationException(errors);
        }
    }
}
