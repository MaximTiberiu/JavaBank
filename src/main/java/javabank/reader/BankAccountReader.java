package javabank.reader;

import javabank.domain.BankAccount;
import javabank.domain.BankingOperation;
import javabank.domain.Card;
import javabank.domain.banking.operations.Operations;

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
        String ibanCode;
        System.out.print("IBAN Code: ");
        ibanCode = bufferedReader.readLine();

        ArrayList<Card> validCards = new ArrayList<Card>();
        ArrayList<Operations> validOperations = new ArrayList<Operations>();
        ArrayList<BankingOperation> bankingOperations = new ArrayList<BankingOperation>();

        return new BankAccount(ibanCode, validCards, validOperations, bankingOperations);
    }
}
