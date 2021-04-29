package javabank.service;

import javabank.domain.BankBranch;
import javabank.domain.validators.ValidationException;
import javabank.repository.memory.InMemoryRepository;
import javabank.service.validators.BankBranchValidatorService;
import javabank.service.validators.ValidatorService;

import java.text.ParseException;

public class BankBranchService {
    private final InMemoryRepository<Long, BankBranch> bankBranchInMemoryRepository;
    private final ValidatorService<BankBranch> bankBranchValidatorService = new BankBranchValidatorService();

    /**
     * Constructor that creates a new BankBranchService
     * @param bankBranchInMemoryRepository InMemoryRepository<Long, BankBranch>, representing the Repository that handles the BankBranch data
     */
    public BankBranchService(InMemoryRepository<Long, BankBranch> bankBranchInMemoryRepository) {
        this.bankBranchInMemoryRepository = bankBranchInMemoryRepository;
    }

    /**
     * Method that adds a new Bank
     * @param bankBranchParam BankBranch, representing the BankBranch to be added
     * @return  null,                   if the given BankBranch is saved
     *          non-null BankBranch,    otherwise (eg. BankBranch with the same id already exists)
     * @throws ValidationException, if the BankBranch to be added already exists
     * @throws ParseException, an exception
     */
    public BankBranch addBankBranch(BankBranch bankBranchParam) throws ValidationException, ParseException {
        BankBranch bankBranch = bankBranchInMemoryRepository.save(bankBranchParam);
        bankBranchValidatorService.validateAdd(bankBranch);
        return bankBranch;
    }

    /**
     * Method that deletes a Bank
     * @param bankBranchIDParam, representing the ID of the BankBranch to be deleted
     * @return  null,                   if the BankBranch to be deleted doesn't exist
     *          non-null BankBranch,    otherwise: representing the BankBranch that was deleted
     * @throws ValidationException, if the BankBranch to be deleted doesn't exist
     */
    public BankBranch deleteBankBranch(Long bankBranchIDParam) throws ValidationException {
        BankBranch bankBranch = bankBranchInMemoryRepository.delete(bankBranchIDParam);
        bankBranchValidatorService.validateDelete(bankBranch);
        return bankBranch;
    }
}
