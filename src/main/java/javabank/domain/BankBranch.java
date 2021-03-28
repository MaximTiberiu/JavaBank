package javabank.domain;

import java.util.ArrayList;
import java.util.Objects;

public class BankBranch extends Entity<Long>{
    private String bicCode;
    private String swiftCode;
    private BankAddress bankAddress;
    private String bankTelephoneNumber;
    private String bankEmail;
    private ArrayList<Client> clients;

    /**
     *
     * @param bicCode String,               representing the BIC Code of the BankBranch
     * @param swiftCode String,             representing the SWIFT Code of the BankBranch
     * @param bankAddress BankAddress,      representing the address of the BankBranch
     * @param bankTelephoneNumber String,   representing the telephone number of the BankBranch
     * @param bankEmail String,             representing the email address of the BankBranch
     * @param clients ArrayList<Client>,    representing a list of the bank's clients
     */
    public BankBranch(String bicCode, String swiftCode, BankAddress bankAddress, String bankTelephoneNumber, String bankEmail,ArrayList<Client> clients) {
        this.bicCode = bicCode;
        this.swiftCode = swiftCode;
        this.bankAddress = bankAddress;
        this.bankTelephoneNumber = bankTelephoneNumber;
        this.bankEmail = bankEmail;
        this.clients = clients;
    }

    /**
     * @return String, representing the BIC Code of the BankBranch
     */
    public String getBicCode() {
        return bicCode;
    }

    /**
     * @param bicCode String, representing the new BIC Code of the BankBranch
     */
    public void setBicCode(String bicCode) {
        this.bicCode = bicCode;
    }

    /**
     * @return String, representing the SWIFT Code of the BankBranch
     */
    public String getSwiftCode() {
        return swiftCode;
    }

    /**
     * @param swiftCode String, representing the new SWIFT Code of the BankBranch
     */
    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    /**
     * @return  BankAddress, representing the address of the BankBranch
     */
    public BankAddress getBankAddress() {
        return bankAddress;
    }

    /**
     * @param bankAddress BankAddress, representing the new address of the BankBranch
     */
    public void setBankAddress(BankAddress bankAddress) {
        this.bankAddress = bankAddress;
    }

    /**
     * @return String, representing the telephone number of the BankBranch
     */
    public String getBankTelephoneNumber() {
        return bankTelephoneNumber;
    }

    /**
     * @param bankTelephoneNumber String, representing the new telephone number of the BankBranch
     */
    public void setBankTelephoneNumber(String bankTelephoneNumber) {
        this.bankTelephoneNumber = bankTelephoneNumber;
    }

    /**
     * @return String, representing the email address of the BankBranch
     */
    public String getBankEmail() {
        return bankEmail;
    }

    /**
     * @param bankEmail String, representing the new email address of the BankBranch
     */
    public void setBankEmail(String bankEmail) {
        this.bankEmail = bankEmail;
    }

    /**
     * @return ArrayList<Client>, representing a list of the bank's clients
     */
    public ArrayList<Client> getClients() {
        return clients;
    }

    /**
     * @param clients ArrayList<Client>, representing a new list of the bank's clients
     */
    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    /**
     * @return String, representing the serialization of a BankBranch
     */
    @Override
    public String toString() {
        return "BankBranch{" +
                "ID='" + getId() + '\'' +
                ", bicCode='" + bicCode + '\'' +
                ", swiftCode='" + swiftCode + '\'' +
                ", bankAddress=" + bankAddress +
                ", bankTelephoneNumber='" + bankTelephoneNumber + '\'' +
                ", bankEmail='" + bankEmail + '\'' +
                ", clients=" + clients +
                '}';
    }

    /**
     * Method that verifies if two BankBranch objects are equal
     * @param obj Object, representing the Object to be verified
     * @return  true,   if the bicCode of the BankBranch is equal to the bicCode of the Object,
     *                  the swiftCode of the BankBranch is equal to the swiftCode of the Object,
     *                  the bankAddress of the BankBranch is equal to the bankAddress of the Object,
     *                  the bankTelephoneNumber of the BankBranch is equal to the bankTelephoneNumber of the Object,
     *                  the bankEmail of the BankBranch is equal to the bankEmail of the Object,
     *                  and the clients list of the BankBranch is equal to the clients list of the Object
     *          false,  otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BankBranch that = (BankBranch) obj;
        return bicCode.equals(that.bicCode) && swiftCode.equals(that.swiftCode) && bankAddress.equals(that.bankAddress) && bankTelephoneNumber.equals(that.bankTelephoneNumber)
                && bankEmail.equals(that.bankEmail) && Objects.equals(clients, that.clients);
    }

    /**
     * Method that gets the hashCode of the Bank
     * @return int, representing the hashCode of the BankBranch
     */
    @Override
    public int hashCode() {
        return Objects.hash(bicCode, swiftCode, bankAddress, bankTelephoneNumber, bankEmail, clients);
    }
}
