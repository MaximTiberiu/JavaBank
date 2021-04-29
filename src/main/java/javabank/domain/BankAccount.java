package javabank.domain;

import javabank.domain.banking.operations.Operation;
import javabank.repository.memory.InMemoryRepository;

import java.util.Objects;

public class BankAccount extends Entity<Long>{
    private String ibanCode;
    private double balance;
    private InMemoryRepository<Long, Card> validCards;
    private InMemoryRepository<Long, Operation> validOperations;
    private InMemoryRepository<Long, Tuple<Operation, Card>> bankingOperations;

    /**
     * Constructor that creates a new BankAccount
     * @param ibanCode String,                                      representing the IBAN code of the BankAccount
     * @param balance double,                                       representing the balance of the BankAccount
     * @param validCards InMemoryRepository<Long, Card>,                           representing a list of valid cards associated with the BankAccount
     * @param validOperations InMemoryRepository<Long, Operation>,                representing a list of valid operations associated with the BankAccount
     * @param bankingOperations InMemoryRepository<Long, Tuple<Operation, Card>>,  representing a list of performed BankingOperation (history of BankingOperations) by the Client
     */
    public BankAccount(String ibanCode, double balance, InMemoryRepository<Long, Card> validCards, InMemoryRepository<Long, Operation> validOperations, InMemoryRepository<Long, Tuple<Operation, Card>> bankingOperations) {
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
     * @return InMemoryRepository<Long, Card>, representing a repository of valid cards associated with the BankAccount
     */
    public InMemoryRepository<Long, Card> getValidCards() {
        return validCards;
    }

    /**
     * @param validCards InMemoryRepository<Long, Card>, representing a new repository of valid cards associated with the BankAccount
     */
    public void setValidCards(InMemoryRepository<Long, Card> validCards) {
        this.validCards = validCards;
    }

    /**
     * @return InMemoryRepository<Long, Operation>, representing a repository of valid operations associated with the BankAccount
     */
    public InMemoryRepository<Long, Operation> getValidOperations() {
        return validOperations;
    }

    /**
     * @param validOperations InMemoryRepository<Long, Operation>, representing a new repository of valid operations associated with the BankAccount
     */
    public void setValidOperations(InMemoryRepository<Long, Operation> validOperations) {
        this.validOperations = validOperations;
    }

    /**
     * @return InMemoryRepository<Long, Tuple<Operation, Card>>, representing a repository of performed BankingOperation (history of BankingOperations) by the Client
     */
    public InMemoryRepository<Long, Tuple<Operation, Card>> getBankingOperations() {
        return bankingOperations;
    }

    /**
     * @param bankingOperations InMemoryRepository<Long, Tuple<Operation, Card>>, representing a new repository of performed BankingOperation (history of BankingOperations) by the Client
     */
    public void setBankingOperations(InMemoryRepository<Long, Tuple<Operation, Card>> bankingOperations) {
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
