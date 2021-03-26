package javabank.domain;

import java.util.Date;
import java.util.Objects;

public class Card {
    private String cardNumber;
    private String cardHolder;
    private Date validThru;
    private int cvvCode;
    private int PIN;

    /**
     * Constructor that creates a new Card
     * @param cardNumber String,    representing the card number of the Card
     * @param cardHolder String,    representing the name of the Card's holder
     * @param validThru Date,       representing the expiry dat of the Card
     * @param cvvCode int,          representing the CVV code of the Card
     * @param PIN int,              representing the PIN code of the Card
     */
    public Card(String cardNumber, String cardHolder, Date validThru, int cvvCode, int PIN) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.validThru = validThru;
        this.cvvCode = cvvCode;
        this.PIN = PIN;
    }

    /**
     * @return String, representing the card number of the Card
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * @param cardNumber String, representing the new card number of the Card
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * @return String, representing the name of the Card's holder
     */
    public String getCardHolder() {
        return cardHolder;
    }

    /**
     * @param cardHolder String, representing the new name of the Card's holder
     */
    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    /**
     * @return Date, representing the expiry dat of the Card
     */
    public Date getValidThru() {
        return validThru;
    }

    /**
     * @param validThru Date, representing the new expiry dat of the Card
     */
    public void setValidThru(Date validThru) {
        this.validThru = validThru;
    }

    /**
     * @return int, representing the CVV code of the Card
     */
    public int getCvvCode() {
        return cvvCode;
    }

    /**
     * @param cvvCode int, representing the new CVV code of the Card
     */
    public void setCvvCode(int cvvCode) {
        this.cvvCode = cvvCode;
    }

    /**
     * @return int, representing the PIN code of the Card
     */
    public int getPIN() {
        return PIN;
    }

    /**
     * @param PIN int, representing the new PIN code of the Card
     */
    public void setPIN(int PIN) {
        this.PIN = PIN;
    }

    /**
     * @return String, representing the serialization of a Card | TODO: Implement Serialization
     */
    @Override
    public String toString() {
        return "Card{" +
                "cardNumber='" + cardNumber + '\'' +
                ", cardHolder='" + cardHolder + '\'' +
                ", validThru=" + validThru +
                ", cvvCode=" + cvvCode +
                ", PIN=" + PIN +
                '}';
    }

    /**
     * Method that verifies if two Bank objects are equal
     * @param obj Object, representing the Object to be verified
     * @return  true,   if the cvvCode of the Card is equal to the cvvCode of the Object,
     *                  the PIN of the Card is equal to the PIN of the Object,
     *                  the cardNumber of the Card is equal to the cardNumber of the Object,
     *                  the cardHolder of the Card is equal to the cardHolder of the Object,
     *                  and the validThru of the Card is equal to the validThru of the Object
     *          false,  otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Card that = (Card) obj;
        return cvvCode == that.cvvCode && PIN == that.PIN && cardNumber.equals(that.cardNumber) && cardHolder.equals(that.cardHolder) && validThru.equals(that.validThru);
    }

    /**
     * Method that gets the hashCode of the Card
     * @return int, representing the hashCode of the Card
     */
    @Override
    public int hashCode() {
        return Objects.hash(cardNumber, cardHolder, validThru, cvvCode, PIN);
    }
}
