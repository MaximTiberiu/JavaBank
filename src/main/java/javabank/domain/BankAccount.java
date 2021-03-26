package javabank.domain;

import javabank.domain.banking.operations.Operations;

import java.util.ArrayList;
import java.util.Objects;

public class BankAccount {
    private String ibanCode;
    private ArrayList<Card> validCards;
    private ArrayList<Operations> validOperations;
    private ArrayList<BankingOperation> bankingOperations;

    /**
     * Constructor that creates a new BankAccount
     * @param ibanCode String,                                  representing the IBAN code of the BankAccount
     * @param validCards ArrayList<Card>,                       representing a list of valid cards associated with the BankAccount
     * @param validOperations ArrayList<Operations>,            representing a list of valid operations associated with the BankAccount
     * @param bankingOperations ArrayList<BankingOperation>,    representing a list of performed BankingOperation (history of BankingOperations) by the Client
     */
    public BankAccount(String ibanCode, ArrayList<Card> validCards, ArrayList<Operations> validOperations, ArrayList<BankingOperation> bankingOperations) {
        this.ibanCode = ibanCode;
        this.validCards = validCards;
        this.validOperations = validOperations;
        this.bankingOperations = bankingOperations;
    }

    /**
     * @return String, representing the IBAN code of the BankAccount
     */
    public String getIbanCode() {
        return ibanCode;
    }

    /**
     * @param ibanCode String, representing the new IBAN code of the BankAccount
     */
    public void setIbanCode(String ibanCode) {
        this.ibanCode = ibanCode;
    }

    /**
     * @return ArrayList<Card>, representing a list of valid cards associated with the BankAccount
     */
    public ArrayList<Card> getValidCards() {
        return validCards;
    }

    /**
     * @param validCards ArrayList<Card>, representing a new list of valid cards associated with the BankAccount
     */
    public void setValidCards(ArrayList<Card> validCards) {
        this.validCards = validCards;
    }

    /**
     * @return ArrayList<Operations>, representing a list of valid operations associated with the BankAccount
     */
    public ArrayList<Operations> getValidOperations() {
        return validOperations;
    }

    /**
     * @param validOperations ArrayList<Operations>, representing a new list of valid operations associated with the BankAccount
     */
    public void setValidOperations(ArrayList<Operations> validOperations) {
        this.validOperations = validOperations;
    }

    /**
     * @return ArrayList<BankingOperation>, representing a list of performed BankingOperation (history of BankingOperations) by the Client
     */
    public ArrayList<BankingOperation> getBankingOperations() {
        return bankingOperations;
    }

    /**
     * @param bankingOperations ArrayList<BankingOperation>, representing a new list of performed BankingOperation (history of BankingOperations) by the Client
     */
    public void setBankingOperations(ArrayList<BankingOperation> bankingOperations) {
        this.bankingOperations = bankingOperations;
    }

    /**
     * @return String, representing the serialization of a BankAccount | TODO: Implement Serialization
     */
    @Override
    public String toString() {
        return "BankAccount{" +
                "ibanCode='" + ibanCode + '\'' +
                ", validCards=" + validCards +
                ", validOperations=" + validOperations +
                ", bankingOperations=" + bankingOperations +
                '}';
    }

    /**
     * Method that verifies if two BankAccount objects are equal
     * @param obj Object, representing the Object to be verified
     * @return  true,   if the IBAN code of the BankAccount is equal to the IBAN code of the Object,
     *                  the validCards list of the BankAccount is equal to the validCards list of the Object
     *                  the validOperations list of the BankAccount is equal to the validOperations list of the Object
     *                  the bankingOperations list of the BankAccount is equal to the bankingOperations list of the Object
     *          false,  otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BankAccount that = (BankAccount) obj;
        return Objects.equals(ibanCode, that.ibanCode) && Objects.equals(validCards, that.validCards) && Objects.equals(validOperations, that.validOperations)
                && Objects.equals(bankingOperations, that.bankingOperations);
    }

    /**
     * Method that gets the hashCode of the BankAccount
     * @return int, representing the hashCode of the BankAccount
     */
    @Override
    public int hashCode() {
        return Objects.hash(ibanCode, validCards, validOperations, bankingOperations);
    }
}
