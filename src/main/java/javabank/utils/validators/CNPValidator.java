package javabank.utils.validators;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CNPValidator {
    private static final int cnpLength = 13;
    private static final SimpleDateFormat cnpDateFormat = new SimpleDateFormat("yyMMdd");
    private static final int[] defaultCNP = new int[] {2, 7, 9, 1, 4, 6, 3, 5, 8, 2, 7, 9};

    private static int[] getCNPDigits(String cnpAsString) {
        int[] digits = new int[cnpLength];
        for (int i = 0; i < cnpLength; i++) {
            char digit = cnpAsString.charAt(i);
            if (!Character.isDigit(digit)) {
                return null;
            }
            digits[i] = (byte) Character.digit(digit, 10);
        }
        return digits;
    }

    private static int getControlSum(int[] cnpDigits) {
        if (cnpDigits == null) {
            return -1;
        }
        int controlSum = 0;
        for (int i = 0; i < cnpLength - 1 ; i++) {
            controlSum += cnpDigits[i] * defaultCNP[i];
        }

        controlSum %= 11;
        if (controlSum == 10) {
            return 1;
        }
        return controlSum;
    }

    public static boolean validateCNP(String cnpAsString) throws ParseException {
        int[] cnpDigits = getCNPDigits(cnpAsString);
        int controlSum = getControlSum(cnpDigits);

        if (controlSum == -1) {
            return false;
        }

        Calendar cal = new GregorianCalendar();
        Date birthDate = cnpDateFormat.parse(cnpAsString.substring(1, 7));
        cal.setTime(birthDate);

        if(!(cal.get(Calendar.YEAR) >= 2000 && (cnpDigits[0] == 5 || cnpDigits[0] == 6))) {
            return false;
        }
        else if (!(cal.get(Calendar.YEAR) < 2000 && (cnpDigits[0] == 1 || cnpDigits[0] == 2))) {
            return false;
        }

        return controlSum == cnpDigits[cnpLength - 1];
    }

}
