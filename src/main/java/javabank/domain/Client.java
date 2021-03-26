package javabank.domain;

import java.util.ArrayList;
import java.util.Objects;

public class Client {
    private String firstName;
    private String lastName;
    private String CNP;
    private String telephoneNumber;
    private String email;
    private ClientCredentials credentials;
    private ArrayList<BankAccount> bankAccounts;

    /**
     * Constructor that creates a new Client
     * @param firstName String,                     representing the first name of the Client
     * @param lastName String,                      representing the last name of the Client
     * @param CNP String,                           representing the CNP (Identity Card) of the Client
     * @param telephoneNumber String,               representing the telephone number of the Client
     * @param email String,                         representing the email address of the Client
     * @param credentials ClientCredentials,        representing the Client's credentials
     * @param bankAccounts ArrayList<BankAccount>,  representing a list of Client's bank accounts
     */
    public Client(String firstName, String lastName, String CNP, String telephoneNumber, String email, ClientCredentials credentials, ArrayList<BankAccount> bankAccounts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.CNP = CNP;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.credentials = credentials;
        this.bankAccounts = bankAccounts;
    }

    /**
     * @return String, representing the first name of the Client
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName String, representing the first name of the Client
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return String, representing the last name of the Client
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName String, representing the last name of the Client
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return String, representing the CNP (Identity Card) of the Client
     */
    public String getCNP() {
        return CNP;
    }

    /**
     * @param CNP String, representing the CNP (Identity Card) of the Client
     */
    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    /**
     * @return String, representing the telephone number of the Client
     */
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    /**
     * @param telephoneNumber String, representing the telephone number of the Client
     */
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    /**
     * @return String, representing the email address of the Client
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email String, representing the email address of the Client
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return ClientCredentials, representing the Client's credentials
     */
    public ClientCredentials getCredentials() {
        return credentials;
    }

    /**
     * @param credentials ClientCredentials, representing the Client's credentials
     */
    public void setCredentials(ClientCredentials credentials) {
        this.credentials = credentials;
    }

    /**
     * @return ArrayList<BankAccount>, representing a list of Client's bank accounts
     */
    public ArrayList<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    /**
     * @param bankAccounts ArrayList<BankAccount>, representing a list of Client's bank accounts
     */
    public void setBankAccounts(ArrayList<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    /**
     * @return String, representing the serialization of a Client | TODO: Implement Serialization
     */
    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", CNP='" + CNP + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", credentials=" + credentials +
                ", bankAccounts=" + bankAccounts +
                '}';
    }

    /**
     * @param obj Object, representing the Object to be verified
     * @return  true,   if the firstName of the Client is equal to the firstName of the Object,
     *                  the lastName of the Client is equal to the lastName of the Object,
     *                  the CNP of the Client is equal to the CNP of the Object,
     *                  the telephoneNumber of the Client is equal to the telephoneNumber of the Object,
     *                  the email of the Client is equal to the email of the Object,
     *                  the credentials of the Client is equal to the credentials of the Object,
     *                  the bankAccounts list of Client is equal to the bankAccounts list of the Object
     *          false,  otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Client that = (Client) obj;
        return firstName.equals(that.firstName) && lastName.equals(that.lastName) && CNP.equals(that.CNP) && telephoneNumber.equals(that.telephoneNumber)
                && Objects.equals(email, that.email) && credentials.equals(that.credentials) && bankAccounts.equals(that.bankAccounts);
    }

    /**
     * @return int, representing the hashCode of the Client
     */
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, CNP, telephoneNumber, email, credentials, bankAccounts);
    }
}
