package javabank.domain;

import javabank.domain.banking.operations.Operation;

import java.util.ArrayList;
import java.util.Objects;

public class BankAccount extends Entity<Long>{
    private String ibanCode;
    private double balance;
    private ArrayList<Card> validCards;
    private ArrayList<Operation> validOperations;
    private ArrayList<Tuple<Operation, Card>> bankingOperations;

    /**
     * Constructor that creates a new BankAccount
     * @param ibanCode String,                                      representing the IBAN code of the BankAccount
     * @param balance double,                                       representing the balance of the BankAccount
     * @param validCards ArrayList<Card>,                           representing a list of valid cards associated with the BankAccount
     * @param validOperations ArrayList<Operations>,                representing a list of valid operations associated with the BankAccount
     * @param bankingOperations ArrayList<Tuple<Operation, Card>>,  representing a list of performed BankingOperation (history of BankingOperations) by the Client
     */
    public BankAccount(String ibanCode, double balance, ArrayList<Card> validCards, ArrayList<Operation> validOperations, ArrayList<Tuple<Operation, Card>> bankingOperations) {
        this.ibanCode = ibanCode;
        this.balance = balance;
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
     * @return double, representing the balance of the BankAccount
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @param balance double, representing the new balance of the BankAccount
     */
    public void setBalance(double balance) {
        this.balance = balance;
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
    public ArrayList<Operation> getValidOperations() {
        return validOperations;
    }

    /**
     * @param validOperations ArrayList<Operations>, representing a new list of valid operations associated with the BankAccount
     */
    public void setValidOperations(ArrayList<Operation> validOperations) {
        this.validOperations = validOperations;
    }

    /**
     * @return ArrayList<Tuple<Operation, Card>>, representing a list of performed BankingOperation (history of BankingOperations) by the Client
     */
    public ArrayList<Tuple<Operation, Card>> getBankingOperations() {
        return bankingOperations;
    }

    /**
     * @param bankingOperations ArrayList<Tuple<Operation, Card>>, representing a new list of performed BankingOperation (history of BankingOperations) by the Client
     */
    public void setBankingOperations(ArrayList<Tuple<Operation, Card>> bankingOperations) {
        this.bankingOperations = bankingOperations;
    }

    /**
     * @return String, representing the serialization of a BankAccount
     */
    @Override
    public String toString() {
        return "BankAccount{" +
                "ID='" + getId() + '\'' +
                ", ibanCode='" + ibanCode + '\'' +
                ", valance='" + balance + '\'' +
                ", validCards=" + validCards +
                ", validOperations=" + validOperations +
                ", bankingOperations=" + bankingOperations +
                '}';
    }

    /**
     * Method that verifies if two BankAccount objects are equal
     * @param obj Object, representing the Object to be verified
     * @return  true,   if the IBAN code of the BankAccount is equal to the IBAN code of the Object,
     *                  the balance list of the BankAccount is equal to the balance list of the Object,
     *                  the validCards list of the BankAccount is equal to the validCards list of the Object,
     *                  the validOperations list of the BankAccount is equal to the validOperations list of the Object,
     *                  and the bankingOperations list of the BankAccount is equal to the bankingOperations list of the Object
     *          false,  otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BankAccount that = (BankAccount) obj;
        return balance == that.balance && Objects.equals(ibanCode, that.ibanCode) && Objects.equals(validCards, that.validCards)
                && Objects.equals(validOperations, that.validOperations) && Objects.equals(bankingOperations, that.bankingOperations);
    }

    /**
     * Method that gets the hashCode of the BankAccount
     * @return int, representing the hashCode of the BankAccount
     */
    @Override
    public int hashCode() {
        return Objects.hash(ibanCode, balance, validCards, validOperations, bankingOperations);
    }
}
