package javabank.domain.validators;

import javabank.domain.Card;
import javabank.domain.Tuple;
import javabank.domain.banking.operations.Operation;
import org.apache.commons.validator.routines.IBANValidator;
import javabank.domain.BankAccount;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BankAccountValidator implements Validator<BankAccount> {
    /**
     * Method that validates a BankAccount entity
     *
     * @param entity BankAccount, representing the entity to be validate
     * @throws ValidationException, if the BankAccount is invalid
     */
    @Override
    public void validate(BankAccount entity) throws ValidationException {
        String errors = "";

        if (entity.getId() < 0 ) {
            errors += "The ID of the BankAddress can't be a negative number!\n";
        }
        if (!IBANValidator.getInstance().isValid(entity.getIbanCode())) {
            errors += "The IBAN code is invalid!";
        }

        try {
            List<Card> validCards = new ArrayList<>((Collection<? extends Card>) entity.getValidCards().findAll());
            CardValidator cardValidator = new CardValidator();
            for (Card card : validCards) {
                cardValidator.validate(card);
            }

            List<Tuple<Operation, Card>> bankingOperations = new ArrayList<>((Collection<? extends Tuple<Operation, Card>>) entity.getBankingOperations().findAll());
            Validator<Tuple<Operation, Card>> bankingOperationValidator = BankAccountValidator::validateBankingOperation;
            for (Tuple<Operation, Card> bankingOperation : bankingOperations) {
                bankingOperationValidator.validate(bankingOperation);
            }
        }
        catch (ValidationException | ParseException validationException) {
            errors += validationException.toString();
        }

        if (errors.length() > 0) {
            throw new ValidationException(errors);
        }
    }

    public static void validateBankingOperation(Tuple<Operation, Card> entity) {
        String errors = "";

        if (entity.getId() < 0 ) {
            errors += "The ID of the BankAddress can't be a negative number!\n";
        }

        try {
            // OperationValidator
            OperationValidator operationValidator = new OperationValidator();
            operationValidator.validate(entity.getLeftEntity());

            // CardValidator
            CardValidator cardValidator = new CardValidator();
            cardValidator.validate(entity.getRightEntity());
        }
        catch (ValidationException validationException) {
            errors += validationException.toString();
        }

        if(errors.length() > 0) {
            throw new ValidationException(errors);
        }
    }
}
