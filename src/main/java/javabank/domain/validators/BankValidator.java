package javabank.domain.validators;

import javabank.domain.Bank;
import javabank.domain.BankBranch;
import javabank.utils.validators.EmailValidator;
import javabank.utils.validators.TelephoneNumberValidator;
import javabank.utils.validators.WebsiteValidator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BankValidator implements Validator<Bank> {
    /**
     * Method that validates a Bank entity
     *
     * @param entity Bank, representing the entity to be validate
     * @throws ValidationException, if the Bank is invalid
     */
    @Override
    public void validate(Bank entity) throws ValidationException {
        String errors = "";

        if (entity.getId() < 0 ) {
            errors += "The ID of the BankAddress can't be a negative number!\n";
        }
        if (entity.getBankName().matches("^[a-zA-Z\\s]*$")) {
            errors += "The bank name can't be an empty value and it can't contain digits!\n";
        }

        try {
            BankAddressValidator bankAddressValidator = new BankAddressValidator();
            bankAddressValidator.validate(entity.getHeadquartersAddress());
        }
        catch (ValidationException validationException) {
            errors += validationException.toString() + "\n";
        }

        if (!TelephoneNumberValidator.validateTelephoneNumber(entity.getHqTelephoneNumber())) {
            errors += "The telephone number is invalid!\n";
        }
        if (!EmailValidator.validateEmail(entity.getHqEmail())) {
            errors += "The email address is invalid!\n";
        }
        if (!WebsiteValidator.validateWebsite(entity.getWebsite())) {
            errors += "The URL address is invalid!";
        }

        try {
            List<BankBranch> bankBranches = new ArrayList<BankBranch>((Collection<? extends BankBranch>) entity.getBankBranches().findAll());
            BankBranchValidator bankBranchValidator = new BankBranchValidator();

            for (BankBranch bankBranch : bankBranches) {
                bankBranchValidator.validate(bankBranch);
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
