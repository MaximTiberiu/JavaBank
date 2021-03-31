package javabank.utils.validators;

public class EmailValidator {
    private static final String regexEmail = "^(.+)@(.+)$";

    public static boolean validateEmail(String email) {
        return email.matches(regexEmail);
    }
}
