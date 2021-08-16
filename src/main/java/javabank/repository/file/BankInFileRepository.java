package javabank.repository.file;

import javabank.domain.Bank;
import javabank.domain.validators.Validator;
import javabank.repository.database.BankAddressDatabaseRepository;

public class BankInFileRepository extends AbstractInFileRepository<Long, Bank> {
    BankAddressDatabaseRepository bankAddressDatabaseRepository;
    BankBranchInFileRepository bankBranchInFileRepository;
    /**
     * Constructor that creates a new InMemoryRepository
     *
     * @param fileName  String, representing the name of the file where the data is loaded from / stored to
     * @param validator Validator<E>,                                       representing the validator of the AbstractFileRepository
     * @param bankAddressDatabaseRepository, BankAddressDatabaseRepository, representing the BankAddress repository
     * @param bankBranchInFileRepository , BankBranchInFileRepository,      representing the BankBranch repository
     */
    public BankInFileRepository(String fileName, Validator<Bank> validator, BankAddressDatabaseRepository bankAddressDatabaseRepository,
                                BankBranchInFileRepository bankBranchInFileRepository) {
        super(fileName, validator);
        this.bankAddressDatabaseRepository = bankAddressDatabaseRepository;
        this.bankBranchInFileRepository = bankBranchInFileRepository;
    }

    /**
     * Method that extracts a Bank having a specified list of attributes
     * @param attributes String[], representing the attributes of the entity to be extracted
     * @return Bank, representing the extracted Bank based on the given attributes
     */
    @Override
    public Bank extractEntity(String[] attributes) {
//        BankAddress bankAddress = BankAddressDatabaseRepository.findOne(Long.parseLong(attributes[2]));
//        Bank bank = new Bank(attributes[1], bankAddress, attributes[3], attributes[4], attributes[5]);
//        bank.setId(Long.parseLong(attributes[0]));
//        return bank;
        return null;
    }

    @Override
    public String[] createEntityAsStringList(Bank entity) {
        return new String[0];
    }
}
