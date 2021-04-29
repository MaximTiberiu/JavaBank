package javabank.service;

import javabank.domain.BankAccount;
import javabank.domain.validators.ValidationException;
import javabank.repository.memory.InMemoryRepository;
import javabank.service.validators.BankAccountValidatorService;
import javabank.service.validators.ValidatorService;

import java.text.ParseException;

public class BankAccountService {
    private final InMemoryRepository<Long, BankAccount> bankAccountInMemoryRepository;
    private final ValidatorService<BankAccount> bankAccountValidatorService = new BankAccountValidatorService();

    /**
     * Constructor that creates a new BankAccount
     * @param bankAccountInMemoryRepository InMemoryRepository<Long, BankAccount>, representing the Repository that handles the BankAccount data
     */
    public BankAccountService(InMemoryRepository<Long, BankAccount> bankAccountInMemoryRepository) {
        this.bankAccountInMemoryRepository = bankAccountInMemoryRepository;
    }

    /**
     * Method that adds a new BankAccount
     * @param bankAccountParam BankAccount, representing the Bank to be added
     * @return  null,                   if the given BankAccount is saved
     *          non-null BankAccount,   otherwise (eg. BankAccount with the same id already exists)
     * @throws ValidationException, if the BankAccount to be added already exists
     * @throws ParseException, an exception
     */
    public BankAccount addBankAccount(BankAccount bankAccountParam) throws ValidationException, ParseException {
        BankAccount bankAccount = bankAccountInMemoryRepository.save(bankAccountParam);
        bankAccountValidatorService.validateAdd(bankAccount);
        return bankAccount;
    }

    /**
     * Method that deletes a BankAccount
     * @param bankAccountIDParam, representing the ID of the BankAccount to be deleted
     * @return  null,                   if the BankAccount to be deleted doesn't exist
     *          non-null BankAccount,   otherwise: representing the BankAccount that was deleted
     * @throws ValidationException, if the BankAccount to be deleted doesn't exist
     */
    public BankAccount deleteBankAccount(Long bankAccountIDParam) throws ValidationException {
        BankAccount bankAccount = bankAccountInMemoryRepository.delete(bankAccountIDParam);
        bankAccountValidatorService.validateDelete(bankAccount);
        return bankAccount;
    }
}
