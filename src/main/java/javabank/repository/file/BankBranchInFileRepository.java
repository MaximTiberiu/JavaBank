package javabank.repository.file;

import javabank.domain.BankBranch;
import javabank.domain.validators.Validator;

public class BankBranchInFileRepository extends AbstractInFileRepository<Long, BankBranch> {
    /**
     * Constructor that creates a new InMemoryRepository
     *
     * @param fileName  String, representing the name of the file where the data is loaded from / stored to
     * @param validator Validator<E>, representing the validator of the AbstractFileRepository
     */
    public BankBranchInFileRepository(String fileName, Validator<BankBranch> validator) {
        super(fileName, validator);
    }

    /**
     * Method that extracts an E entity having a specified list of attributes
     *
     * @param attributes String[], representing the attributes of the entity to be extracted
     * @return E, representing the extracted entity based on the given attributes
     */
    @Override
    public BankBranch extractEntity(String[] attributes) {
        return null;
    }

    /**
     * Method that creates a list of String attributes for CSVReader
     *
     * @param entity Entity, representing the entity whose list of attributes is being determined
     * @return String[], representing the list of attributes
     */
    @Override
    public String[] createEntityAsStringList(BankBranch entity) {
        return new String[0];
    }
}
