package javabank.repository.database;

import javabank.domain.Bank;
import javabank.domain.BankAddress;
import javabank.domain.validators.BankBranchValidator;
import javabank.repository.AbstractRepository;
import javabank.repository.file.BankBranchInFileRepository;

import java.sql.*;
import java.text.ParseException;

public class BankDatabaseRepository implements AbstractRepository<Long, Bank> {
    private String url;
    private String username;
    private String password;

    /**
     * Constructor that creates a new BankDatabaseRepository
     * @param url String,       representing the URL of the database
     * @param username String,  representing the username of the user connecting to the database
     * @param password String,  representing the password of the user connecting to the database
     */
    public BankDatabaseRepository(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    /**
     * Method that gets a specific Bank
     * @param aLong Long, representing the id of the bank to be returned
     *              id must not be null
     * @return the bank with the specified id
     *          or null, if there is no entity with the given id
     */
    @Override
    public Bank findOne(Long aLong) {
        try(Connection connection = DriverManager.getConnection(url, username, password)) {
            String command =
                    "SELECT * " +
                    "FROM banks " +
                    "WHERE id =  " + aLong;
            PreparedStatement preparedStatement = connection.prepareStatement(command);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                return getBank(resultSet);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * Method that gets all the entities in the Repository
     * @return Iterable<E>, representing all the entities
     */
    @Override
    public Iterable<Bank> findAll() {
        return null;
    }

    /**
     * Method that adds a new entity to the Repository
     * @param entity E, representing the entity to be added
     *               entity must be not null
     * @return null,       if the given entity is saved
     * the entity, otherwise
     */
    @Override
    public Bank save(Bank entity) throws ParseException {
        return null;
    }

    /**
     * Method that removes the entity with the specified id from the Repository
     * @param aLong ID, representing the id of the entity to be deleted
     *              id must not be null
     * @return the removed entity or null, if there is no entity with the given id
     */
    @Override
    public Bank delete(Long aLong) {
        return null;
    }

    /**
     * Method that updates an entity in the Repository
     * @param entity E, representing the new entity entity must not be null
     * @return null,       if the entity is updated the entity, otherwise
     */
    @Override
    public Bank update(Bank entity) throws ParseException {
        return null;
    }

    private Bank getBank(ResultSet resultSet) throws SQLException {
        Long bankID = resultSet.getLong("id");
        String bankName = resultSet.getString("bankName");
        BankAddress headquartersAddress = new BankAddress("-", 0, "-", "-", 123456, "-");
        // TODO: add HQ Address
        String hqTelephoneNumber = resultSet.getString("hqTelephoneNumber");
        String hqEmail = resultSet.getString("hqEmail");
        String website = resultSet.getString("website");
        // TODO: add bankBranches
        BankBranchInFileRepository bankBranches = null; // TODO!!

        Bank bank = new Bank(bankName, headquartersAddress, hqTelephoneNumber, hqEmail, website, bankBranches);
        bank.setId(bankID);
        return bank;
    }
}
