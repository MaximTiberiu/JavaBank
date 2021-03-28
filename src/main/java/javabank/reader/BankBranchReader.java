package javabank.reader;

import javabank.domain.BankAddress;
import javabank.domain.BankBranch;
import javabank.domain.Client;

import java.io.IOException;
import java.util.ArrayList;

public class BankBranchReader implements Reader<BankBranch> {
    /**
     * Method that reads a BankBranch from the System.in
     * @return BankBranch, representing the read Bank
     * @throws IOException, representing an exception
     */
    @Override
    public BankBranch read() throws IOException {
        System.out.println("Please introduce bank branch details!");
        Long idBankBranch = new ReaderID().read();

        String bicCode;
        System.out.print("BIC Code: ");
        bicCode = bufferedReader.readLine();

        String swiftCode;
        System.out.print("SWIFT Code: ");
        swiftCode = bufferedReader.readLine();

        BankAddress bankAddress;
        BankAddressReader bankAddressReader = new BankAddressReader();
        bankAddress = bankAddressReader.read();

        String bankTelephoneNumber;
        System.out.print("Telephone number: ");
        bankTelephoneNumber = bufferedReader.readLine();

        String bankEmail;
        System.out.print("Email address: ");
        bankEmail = bufferedReader.readLine();

        ArrayList<Client> clients = new ArrayList<Client>();

        BankBranch bankBranch =  new BankBranch(bicCode, swiftCode, bankAddress, bankTelephoneNumber, bankEmail, clients);
        bankBranch.setId(idBankBranch);
        return bankBranch;
    }
}
