package javabank.reader;

import javabank.domain.Bank;
import javabank.domain.BankAddress;
import javabank.domain.BankBranch;
import javabank.domain.validators.BankBranchValidator;
import javabank.repository.memory.InMemoryRepository;

import java.io.IOException;

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

        InMemoryRepository<Long, BankBranch> bankBranches = new InMemoryRepository<>(new BankBranchValidator());

        Bank bank = new Bank(bankName, headquartersAddress, hqTelephoneNumber, hqEmail, website, bankBranches);
        bank.setId(idBank);
        return bank;
    }
}
