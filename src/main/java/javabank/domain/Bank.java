package javabank.domain;

import java.util.ArrayList;
import java.util.Objects;

public class Bank {
    protected String bankName;
    protected BankAddress headquartersAddress;
    protected String hqTelephoneNumber;
    protected String hqEmail;
    protected String website;
    private ArrayList<BankBranch> bankBranches;

    /**
     * Default constructor that creates a new Bank
     */
    public Bank() {

    }

    /**
     * Constructor that creates a new Bank
     * @param bankName String,                      representing the name of the bank
     * @param headquartersAddress BankAddress,      representing the address of the HQ
     * @param hqTelephoneNumber String,             representing the telephone number of the HQ
     * @param hqEmail String,                       representing the email address of the HQ
     * @param website String,                       representing the bank website
     * @param bankBranches ArrayList<BankBranch>,   representing a list of bank branches
     */
    public Bank(String bankName, BankAddress headquartersAddress, String hqTelephoneNumber, String hqEmail, String website, ArrayList<BankBranch> bankBranches) {
        this.bankName = bankName;
        this.headquartersAddress = headquartersAddress;
        this.hqTelephoneNumber = hqTelephoneNumber;
        this.hqEmail = hqEmail;
        this.website = website;
        this.bankBranches = bankBranches;
    }

    /**
     * @return String, representing the name of the bank
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * @param bankName String, representing the new name of the bank
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
     * @param headquartersAddress BankAddress, representing the new address of the HQ
     */
    public void setHeadquartersAddress(BankAddress headquartersAddress) {
        this.headquartersAddress = headquartersAddress;
    }

    /**
     * @param hqTelephoneNumber String, representing the new telephone number of the HQ
     */
    public void setHqTelephoneNumber(String hqTelephoneNumber) {
        this.hqTelephoneNumber = hqTelephoneNumber;
    }

    /**
     * @return String, representing the email address of the HQ
     */
    public String getHqEmail() {
        return hqEmail;
    }

    /**
     * @param hqEmail String, representing the new email address of the HQ
     */
    public void setHqEmail(String hqEmail) {
        this.hqEmail = hqEmail;
    }

    /**
     * @return String, representing the bank website
     */
    public String getWebsite() {
        return website;
    }

    /**
     * @param website String, representing the new bank website
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * @return ArrayList<BankBranch>, representing a list of bank's clients
     */
    public ArrayList<BankBranch> getBankBranches() {
        return bankBranches;
    }

    /**
     * @param bankBranches ArrayList<BankBranch>, representing a new list of bank's clients
     */
    public void setBankBranches(ArrayList<BankBranch> bankBranches) {
        this.bankBranches = bankBranches;
    }

    /**
     * @return String, representing the serialization of a Bank | TODO: Implement Serialization
     */
    @Override
    public String toString() {
        return "Bank{" +
                "bankName='" + bankName + '\'' +
                ", headquartersAddress=" + headquartersAddress +
                ", hqTelephoneNumber='" + hqTelephoneNumber + '\'' +
                ", hqEmail='" + hqEmail + '\'' +
                ", website='" + website + '\'' +
                ", bankBranches=" + bankBranches +
                '}';
    }

    /**
     * Method that verifies if two Bank objects are equal
     * @param obj Object, representing the Object to be verified
     * @return  true,   if the bankName of the Bank is equal to the bankName of the Object,
     *                  the headquartersAddress of the Bank is equal to the headquartersAddress of the Object,
     *                  the hqTelephoneNumber of the Bank is equal to the hqTelephoneNumber of the Object,
     *                  the hqEmail of the Bank is equal to the hqEmail of the Object,
     *                  the website of the Bank is equal to the website of the Object,
     *                  and the bankBranches list of the Bank is equal to the bankBranches list of the Object
     *          false,  otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Bank that = (Bank) obj;
        return bankName.equals(that.bankName) && headquartersAddress.equals(that.headquartersAddress)  && hqTelephoneNumber.equals(that.hqTelephoneNumber)
                && hqEmail.equals(that.hqEmail) && website.equals(that.website) && bankBranches.equals(that.bankBranches);
    }

    /**
     * Method that gets the hashCode of the Bank
     * @return int, representing the hashCode of the Bank
     */
    @Override
    public int hashCode() {
        return Objects.hash(bankName, headquartersAddress, hqTelephoneNumber, hqEmail, website, bankBranches);
    }
}
