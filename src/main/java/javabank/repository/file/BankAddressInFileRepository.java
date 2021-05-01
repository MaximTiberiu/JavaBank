package javabank.repository.file;

import javabank.domain.BankAddress;
import javabank.domain.validators.Validator;

public class BankAddressInFileRepository extends AbstractInFileRepository<Long, BankAddress> {
    /**
     * Constructor that creates a new BankAddressFileRepository
     * @param fileName  String, representing the name of the file where the data is loaded from / stored to
     * @param validator Validator<BankAddress>, representing the validator of the BankAddressFileRepository
     */
    public BankAddressInFileRepository(String fileName, Validator<BankAddress> validator) {
        super(fileName, validator);
    }

    /**
     * Method that extracts a BankAddress having a specified list of attributes
     * @param attributes String[], representing the attributes of the BankAddress to be extracted
     * @return BankAddress, representing the extracted BankAddress based on the given attributes
     */
    @Override
    public BankAddress extractEntity(String[] attributes) {
        BankAddress bankAddress = new BankAddress(attributes[1], Integer.parseInt(attributes[2]), attributes[3], attributes[4],
                Integer.parseInt(attributes[5]), attributes[6]);
        bankAddress.setId(Long.parseLong(attributes[0]));
        return bankAddress;
    }

    /**
     * Method that creates a list of String attributes for CSVReader
     * @param entity BankAddress, representing the entity whose list of attributes is being determined
     * @return String[], representing the list of attributes
     */
    @Override
    public String[] createEntityAsStringList(BankAddress entity) {
        return new String[]{entity.getId().toString(), entity.getStreetName(), String.valueOf(entity.getNumber()), entity.getCityName(),
                entity.getCountyName(), String.valueOf(entity.getPostalCode()), entity.getCountryName()};
    }
}
