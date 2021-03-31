package javabank.domain.validators;

import javabank.domain.Card;
import javabank.utils.validators.CardDetailsValidator;

public class CardValidator implements Validator<Card> {
    /**
     * Method that validates a Card entity
     *
     * @param entity Card, representing the entity to be validate
     * @throws ValidationException, if the Card is invalid
     */
    @Override
    public void validate(Card entity) throws ValidationException {
        String errors = "";

        if (entity.getId() < 0) {
            errors += "The ID of the Card can't be a negative number!\n";
        }
        if (!CardDetailsValidator.validateCard(entity)) {
            errors += "The card details are invalid!\n";
        }
        if (!entity.getCardHolder().matches("^[a-zA-Z\\s]*$")) {
            errors += "The card holder can't be an empty value and it can't contain digits!\n";
        }
        if (entity.getCvvCode() < 100 || entity.getCvvCode() > 999) {
            errors += "The CVV code must be a 3-digit positive number!\n";
        }
        if (entity.getPIN() < 1000) {
            errors += "The Card PIN code must be a positive number of at least 4 digits!";
        }

        if(errors.length() > 0) {
            throw new ValidationException(errors);
        }
    }
}
