package javabank.domain;

import java.util.ArrayList;
import java.util.Objects;

public class Bank {
    private String bankName;
    private BankAddress headquartersAddress;
    private String hqTelephoneNumber;
    private String website;
    private ArrayList<Client> clients;

    /**
     * Constructor that creates a new Bank
     * @param bankName String,                  representing the name of the bank
     * @param headquartersAddress BankAddress,  representing the address of the HQ
     * @param hqTelephoneNumber String,         representing the telephone number of the HQ
     * @param website String,                   representing the bank website
     * @param clients ArrayList<Client>,        representing a list of bank's clients
     */
    public Bank(String bankName, BankAddress headquartersAddress, String hqTelephoneNumber, String website, ArrayList<Client> clients) {
        this.bankName = bankName;
        this.headquartersAddress = headquartersAddress;
        this.hqTelephoneNumber = hqTelephoneNumber;
        this.website = website;
        this.clients = clients;
    }

    /**
     * @return String, representing the name of the bank
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * @param bankName String, representing the name of the bank
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * @return BankAddress, representing the address of the HQ
     */
    public BankAddress getHeadquartersAddress() {
        return headquartersAddress;
    }

    /**
     * @param headquartersAddress BankAddress, representing the address of the HQ
     */
    public void setHeadquartersAddress(BankAddress headquartersAddress) {
        this.headquartersAddress = headquartersAddress;
    }

    /**
     * @return String, representing the telephone number of the HQ
     */
    public String getTelephoneNumber() {
        return hqTelephoneNumber;
    }

    /**
     * @param hqTelephoneNumber String, representing the telephone number of the HQ
     */
    public void setTelephoneNumber(String hqTelephoneNumber) {
        this.hqTelephoneNumber = hqTelephoneNumber;
    }

    /**
     * @return String, representing the bank website
     */
    public String getWebsite() {
        return website;
    }

    /**
     * @param website String, representing the bank website
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * @return ArrayList<Client>, representing a list of bank's clients
     */
    public ArrayList<Client> getClients() {
        return clients;
    }

    /**
     * @param clients ArrayList<Client>, representing a list of bank's clients
     */
    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    /**
     *
     * @return String, representing the serialization of a Bank
     */
    @Override
    public String toString() {
        return bankName + "\n" + headquartersAddress.toString() + "\n" + "Telephone Number: " + hqTelephoneNumber
                + ", Website: " + website;
    }

    /**
     * Method that verifies if two Bank objects are equal
     * @param obj Object, representing the Object to be verified
     * @return  true,   if --
     *          false,  otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Bank that = (Bank) obj;
        return bankName.equals(that.bankName) && headquartersAddress.equals(that.headquartersAddress)
                && hqTelephoneNumber.equals(that.hqTelephoneNumber) && website.equals(that.website)
                && clients.equals(that.clients);
    }

    /**
     * Method that gets the hashCode of the Bank
     * @return int, representing the hashCode of the Bank
     */
    @Override
    public int hashCode() {
        return Objects.hash(bankName, headquartersAddress, hqTelephoneNumber, website, clients);
    }
}
