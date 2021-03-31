package javabank.utils.validators;

public class TelephoneNumberValidator {
    private static final String regexTelephoneNumber = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
            + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
            + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";

    public static boolean validateTelephoneNumber(String telephoneNumber) {
        return telephoneNumber.matches(regexTelephoneNumber);
    }
}
