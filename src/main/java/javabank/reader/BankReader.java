package javabank.reader;

import javabank.domain.Bank;
import javabank.domain.BankAddress;
import javabank.domain.BankBranch;

import java.io.IOException;
import java.util.ArrayList;

public class BankReader implements Reader<Bank>{
    /**
     * Method that reads a Bank from the System.in
     * @return Bank, representing the read Bank
     * @throws IOException, representing an exception
     */
    @Override
    public Bank read() throws IOException {
        System.out.println("Please introduce bank details!");
        Long idBank = new ReaderID().read();

        String bankName;
        System.out.print("Bank name: ");
        bankName = bufferedReader.readLine();

        BankAddress headquartersAddress;
        BankAddressReader bankAddressReader = new BankAddressReader();
        headquartersAddress = bankAddressReader.read();

        String hqTelephoneNumber;
        System.out.print("Telephone number: ");
        hqTelephoneNumber = bufferedReader.readLine();

        String hqEmail;
        System.out.print("Email address: ");
        hqEmail = bufferedReader.readLine();

        String website;
        System.out.print("Website: ");
        website = bufferedReader.readLine();

        ArrayList<BankBranch> bankBranches = new ArrayList<BankBranch>();

        Bank bank = new Bank(bankName, headquartersAddress, hqTelephoneNumber, hqEmail, website, bankBranches);
        bank.setId(idBank);
        return bank;
    }
}
