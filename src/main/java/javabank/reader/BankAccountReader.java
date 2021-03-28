package javabank.reader;

import javabank.domain.BankAccount;
import javabank.domain.Card;
import javabank.domain.Tuple;
import javabank.domain.banking.operations.Operation;

import java.io.IOException;
import java.util.ArrayList;

public class BankAccountReader implements Reader<BankAccount> {

    /**
     * Abstract method that reads a BankAccount from the System.in
     *
     * @return E, representing the read BankAccount
     * @throws IOException, representing an exception
     */
    @Override
    public BankAccount read() throws IOException {
        System.out.println("Please introduce the bank account details!");
        Long idBankAccount = new ReaderID().read();

        String ibanCode;
        System.out.print("IBAN Code: ");
        ibanCode = bufferedReader.readLine();

        double balance;
        System.out.println("Balance: ");
        balance = Double.parseDouble(bufferedReader.readLine());

        ArrayList<Card> validCards = new ArrayList<Card>();
        ArrayList<Operation> validOperations = new ArrayList<Operation>();
        ArrayList<Tuple<Operation, Card>> bankingOperations = new ArrayList<Tuple<Operation, Card>>();

        BankAccount bankAccount = new BankAccount(ibanCode, balance, validCards, validOperations, bankingOperations);
        bankAccount.setId(idBankAccount);
        return bankAccount;
    }
}
