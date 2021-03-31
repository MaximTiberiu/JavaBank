package javabank.utils.validators;

public class WebsiteValidator {
    private static final String regexWebsite = "^(http://|https://)?(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?$";

    public static boolean validateWebsite(String website) {
        return website.matches(regexWebsite);
    }
}
