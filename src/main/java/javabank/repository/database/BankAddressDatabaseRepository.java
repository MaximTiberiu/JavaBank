package javabank.repository.database;

import javabank.domain.BankAddress;
import javabank.repository.AbstractRepository;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class BankAddressDatabaseRepository implements AbstractRepository<Long, BankAddress> {
    String url;
    String username;
    String password;

    /**
     * Constructor that creates a new BankAddressDatabaseRepository
     * @param url String,       representing the URL of the database
     * @param username String,  representing the username of the user connecting to the database
     * @param password String,  representing the password of the user connecting to the database
     */
    public BankAddressDatabaseRepository(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    /**
     * Method that gets a specific BankAddress in the Repository
     * @param aLong Long,   representing the id of the entity to be returned
     *                      id must not be null
     * @return  the entity with the specified id
     *          or null, if there is no entity with the given id
     */
    @Override
    public BankAddress findOne(Long aLong) {
        try(Connection connection = DriverManager.getConnection(url, username, password)) {
            String command =
                    "SELECT * " +
                    "FROM bankAddresses " +
                    "WHERE id = " + aLong;
            PreparedStatement preparedStatement = connection.prepareStatement(command);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return getBankAddress(resultSet);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * Method that gets all the BankAddress entities in the Repository
     * @return Iterable<BankAddress>, representing all the BankAddress entities
     */
    @Override
    public Iterable<BankAddress> findAll() {
        List<BankAddress> bankAddressList = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(url, username, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM bankAddresses");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                bankAddressList.add(getBankAddress(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bankAddressList;
    }

    /**
     * Method that adds a new entity to the Repository
     * @param entity BankAddress,   representing the entity to be added
     *                              entity must be not null
     * @return null,    if the given entity is saved
     *                  the entity, otherwise
     */
    @Override
    public BankAddress save(BankAddress entity) throws ParseException {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String command = "";
            if (entity.getId() == null) {
                command =   "INSERT INTO bankAddresses (streetName, number, cityName, countyName, postalCode, countryName) " +
                            "VALUES ('" + entity.getStreetName() + "', " + entity.getNumber() + ", '" + entity.getCityName() + "', " +
                            "'" +  entity.getCountyName() + "', " + entity.getPostalCode() + ", '" + entity.getCountryName() + "')";
            } else {
                command =   "INSERT INTO bankAddresses (id, streetName, number, cityName, countyName, postalCode, countryName) " +
                        "VALUES (" + entity.getId() + ", '" + entity.getStreetName() + "', " + entity.getNumber() + ", '" + entity.getCityName() + "', " +
                        "'" +  entity.getCountyName() + "', " + entity.getPostalCode() + ", '" + entity.getCountryName() + "')";
            }
            PreparedStatement preparedStatement = connection.prepareStatement(command);
            try {
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return getBankAddress(resultSet);
                }
            } catch (SQLException e) {
                return entity;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * Method that removes the entity with the specified id from the Repository
     * @param aLong ID, representing the id of the entity to be deleted
     *              id must not be null
     * @return the removed entity or null, if there is no entity with the given id
     */
    @Override
    public BankAddress delete(Long aLong) {
        try(Connection connection = DriverManager.getConnection(url, username, password)) {
            String command = "DELETE FROM bankAddresses WHERE id = " + aLong;
            PreparedStatement preparedStatement = connection.prepareStatement(command);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                return getBankAddress(resultSet);
            }
        } catch(SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * Method that updates an entity in the Repository
     * @param entity E, representing the new entity
     *               entity must not be null
     * @return null,       if the entity is updated
     * the entity, otherwise
     */
    @Override
    public BankAddress update(BankAddress entity) throws ParseException {
        try(Connection connection = DriverManager.getConnection(url, username, password)) {
            String command = "UPDATE bankAddresses SET " +
                    "streetName = '" + entity.getStreetName() + "', " +
                    "number = " + entity.getNumber() + ", " +
                    "cityName = '" + entity.getCityName() + "', " +
                    "countyName = '" + entity.getCountyName() + "', " +
                    "postalCode = " + entity.getPostalCode() + ", " +
                    "countryName = '" + entity.getCountryName() + "' " +
                    "WHERE id = " + entity.getId();
            PreparedStatement preparedStatement = connection.prepareStatement(command);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                return null;
            }
        } catch(SQLException throwables) {
            throwables.printStackTrace();
        }
        return entity;
    }

    private BankAddress getBankAddress(ResultSet resultSet) throws SQLException {
        Long bankAddressID = resultSet.getLong("id");
        String streetName = resultSet.getString("streetName");
        int number = resultSet.getInt("number");
        String cityName = resultSet.getString("cityName");
        String countyName = resultSet.getString("countyName");
        int postalCode = resultSet.getInt("postalCode");
        String countryName = resultSet.getString("countryName");

        BankAddress bankAddress = new BankAddress(streetName, number, cityName, countyName, postalCode, countryName);
        bankAddress.setId(bankAddressID);
        return bankAddress;
    }
}
