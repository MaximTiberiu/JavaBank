package javabank.utils.validators;

import javabank.domain.Card;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CardDetailsValidator {
    public static boolean validateCard(Card card) {
        boolean validCardNumber = validateCardNumber(card.getCardNumber());
        boolean validExpiryDate = validateExpiryDate(card.getValidThru());
        return validCardNumber && validExpiryDate;
    }

    public static boolean validateCardNumber(String number) {
        int[] ints = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            ints[i] = Integer.parseInt(number.substring(i, i + 1));
        }

        for (int i = ints.length - 2; i >= 0; i = i - 2) {
            int j = ints[i];
            j = j * 2;
            if (j > 9) {
                j = j % 10 + 1;
            }
            ints[i] = j;
        }

        int sum = 0;
        for (int anInt : ints) {
            sum += anInt;
        }

        return sum % 10 == 0;
    }

    public static boolean validateExpiryDate(Date validThru) {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/yyyy");
        Date currDate = new Date(System.currentTimeMillis());
        return currDate.after(validThru);
    }
}
