package javabank.domain.validators;

import javabank.domain.BankAddress;

public class BankAddressValidator implements Validator<BankAddress> {
    /**
     * Method that validates a BankAddress entity
     *
     * @param entity BankAddress, representing the entity to be validate
     * @throws ValidationException, if the BankAddress is invalid
     */
    @Override
    public void validate(BankAddress entity) throws ValidationException {
        String errors = "";

        if (entity.getId() < 0 ) {
            errors += "The ID of the BankAddress can't be a negative number!\n";
        }
        if (entity.getStreetName().matches("[ ]*")) {
            errors += "The street name of the BankAddress can't be an empty value!\n";
        }
        if (entity.getNumber() < 0) {
            errors += "The building number of the BankAddress can't be a negative number!\n";
        }
        if (entity.getCityName().matches("[ ]*")) {
            errors += "The city name of the BankAddress can't be an empty value!\n";
        }
        if (!entity.getCountyName().matches("^[a-zA-Z\\s]*$")) {
            errors += "The county name of the BankAddress can't be an empty value and it can't contain digits!\n";
        }
        if (entity.getPostalCode() < 100000 || entity.getPostalCode() > 999999) {
            errors += "The postal code of the BankAddress must be a 6-digit positive number!\n";
        }
        if (!entity.getCountryName().matches("^[a-zA-Z\\s]*$")) {
            errors += "The country name of the BankAddress can't be an empty value and it can't contain digits!";
        }

        if (errors.length() > 0) {
            throw new ValidationException(errors);
        }
    }
}
