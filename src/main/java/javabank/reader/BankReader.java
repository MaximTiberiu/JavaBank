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

        Bank bank = new Bank();
        bank.setBankName(bankName);
        bank.setHeadquartersAddress(headquartersAddress);
        bank.setHqTelephoneNumber(hqTelephoneNumber);
        bank.setHqEmail(hqEmail);
        bank.setWebsite(website);
        ArrayList<BankBranch> bankBranches = new ArrayList<BankBranch>();
        return bank;
    }
}
