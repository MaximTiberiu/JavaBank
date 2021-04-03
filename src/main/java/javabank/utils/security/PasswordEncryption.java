package javabank.utils.security;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;

public class PasswordEncryption {
    private static final Random RANDOM = new SecureRandom();
    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int ITERATIONS = 10000;
    private static final int KEY_LENGTH = 256;

    /**
     * Method that generates a salt value of given length
     * @param length int, representing the length of the salt value
     * @return String, the salt value generated
     */
    public static String getSalt(int length) {
        StringBuilder returnValue = new StringBuilder(length);

        for(int i = 0; i < length; i++) {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return new String(returnValue);
    }

    /**
     * Hash method that generates the secure password
     * @param password char[], representing the password given by the client
     * @param salt byte[], representing the salt value
     * @return byte[], the secure password
     * @throws NoSuchAlgorithmException | InvalidKeySpecException, if the secure password was not generated
     */
    public static byte[] hash(char[] password, byte[] salt) {
        PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
        Arrays.fill(password, Character.MIN_VALUE);

        try {
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            return secretKeyFactory.generateSecret(spec).getEncoded();
        }
        catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
        }
        finally {
            spec.clearPassword();
        }
    }

    /**
     * Method that encodes the secure client password into Base64
     * @param password String, representing the unsecure password given by the client
     * @param salt String, representing the salt value
     * @return String, the generated secure password
     */
    public static String generateSecurePassword(String password, String salt) {
        String returnValue = null;
        byte[] securePassword = hash(password.toCharArray(), salt.getBytes());

        returnValue = Base64.getEncoder().encodeToString(securePassword);
        return returnValue;
    }

    /**
     * Method that is used in the login process
     * @param providedPassword String, representing the password given by the client
     * @param securedPassword String, representing the password stored in the DB
     * @param salt String, representing the salt value stored in the DB
     * @return  true,   if the two passwords match
     *          false,  otherwise
     */
    public static boolean verifyClientPassword(String providedPassword, String securedPassword, String salt) {
        boolean returnValue = false;

        // Genereate new secure password with the same salt
        String newSecurePassword = generateSecurePassword(providedPassword, salt);

        // Check if two passworda are equal
        returnValue = newSecurePassword.equalsIgnoreCase(securedPassword);
        return returnValue;
    }

}
