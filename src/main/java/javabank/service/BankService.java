package javabank.service;

import javabank.domain.Bank;
import javabank.domain.validators.ValidationException;
import javabank.repository.memory.InMemoryRepository;
import javabank.service.validators.BankValidatorService;
import javabank.service.validators.ValidatorService;

import java.text.ParseException;

public class BankService {
    private final InMemoryRepository<Long, Bank> bankInMemoryRepository;
    private final ValidatorService<Bank> bankValidatorService = new BankValidatorService();

    /**
     * Constructor that creates a new BankService
     * @param bankInMemoryRepository InMemoryRepository<Long, Bank>, representing the Repository that handles the Bank data
     */
    public BankService(InMemoryRepository<Long, Bank> bankInMemoryRepository) {
        this.bankInMemoryRepository = bankInMemoryRepository;
    }

    /**
     * Method that adds a new Bank
     * @param bankParam Bank, representing the Bank to be added
     * @return  null,           if the given Bank is saved
     *          non-null Bank,  otherwise (eg. Bank with the same id already exists)
     * @throws ValidationException, if the Bank to be added already exists
     * @throws ParseException, an exception
     */
    public Bank addBank(Bank bankParam) throws ValidationException, ParseException {
        Bank bank = bankInMemoryRepository.save(bankParam);
        bankValidatorService.validateAdd(bank);
        return bank;
    }

    /**
     * Method that deletes a Bank
     * @param bankIDParam, representing the ID of the Bank to be deleted
     * @return  null,           if the Bank to be deleted doesn't exist
     *          non-null Bank,  otherwise: representing the Bank that was deleted
     * @throws ValidationException, if the Bank to be deleted doesn't exist
     */
    public Bank deleteBank(Long bankIDParam) throws ValidationException {
        Bank bank = bankInMemoryRepository.delete(bankIDParam);
        bankValidatorService.validateDelete(bank);
        return bank;
    }
}
