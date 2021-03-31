package javabank.domain.validators;

import javabank.domain.BankBranch;
import javabank.domain.Client;
import javabank.utils.validators.EmailValidator;
import javabank.utils.validators.TelephoneNumberValidator;

import java.text.ParseException;
import java.util.ArrayList;

public class BankBranchValidator implements Validator<BankBranch> {
    /**
     * Method that validates a BankBranch entity
     *
     * @param entity BankBranch, representing the entity to be validate
     * @throws ValidationException, if the BankBranch is invalid
     */
    @Override
    public void validate(BankBranch entity) throws ValidationException {
        String errors = "";

        if (entity.getBicCode().matches("[ ]*")) {
            errors += "The BIC code can't be an empty value!\n";
        }
        if (entity.getSwiftCode().matches("[ ]*]")) {
            errors += "The SWIFT code can't be an empty value!\n";
        }

        try {
            BankAddressValidator bankAddressValidator = new BankAddressValidator();
            bankAddressValidator.validate(entity.getBankAddress());
        }
        catch (ValidationException validationException) {
            errors += validationException.toString() + "\n";
        }

        if (!TelephoneNumberValidator.validateTelephoneNumber(entity.getBankTelephoneNumber())) {
            errors += "The telephone number is invalid!\n";
        }
        if (!EmailValidator.validateEmail(entity.getBankEmail())) {
            errors += "The email address is invalid!\n";
        }

        try {
            ArrayList<Client> clients = entity.getClients();
            ClientValidator clientValidator = new ClientValidator();

            for (Client client : clients) {
                clientValidator.validate(client);
            }
        }
        catch (ValidationException | ParseException validationException) {
            errors += validationException;
        }

        if (errors.length() > 0) {
            throw new ValidationException(errors);
        }

    }
}
