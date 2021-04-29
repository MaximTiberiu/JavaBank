package javabank.reader;

import javabank.domain.BankAccount;
import javabank.domain.Card;
import javabank.domain.Tuple;
import javabank.domain.banking.operations.Operation;
import javabank.domain.validators.BankAccountValidator;
import javabank.domain.validators.CardValidator;
import javabank.domain.validators.OperationValidator;
import javabank.domain.validators.ValidationException;
import javabank.repository.memory.InMemoryRepository;

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

        InMemoryRepository<Long, Card> validCards = new InMemoryRepository<>(new CardValidator());
        InMemoryRepository<Long, Operation> validOperations = new InMemoryRepository<>(new OperationValidator());

        InMemoryRepository<Long, Tuple<Operation, Card>> bankingOperations = new InMemoryRepository<>(BankAccountValidator::validateBankingOperation);

        BankAccount bankAccount = new BankAccount(ibanCode, balance, validCards, validOperations, bankingOperations);
        bankAccount.setId(idBankAccount);
        return bankAccount;
    }
}
