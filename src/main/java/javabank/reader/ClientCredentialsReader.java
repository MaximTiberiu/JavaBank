package javabank.reader;

import javabank.domain.ClientCredentials;

import java.io.IOException;
import java.text.ParseException;

public class ClientCredentialsReader implements Reader<ClientCredentials> {
    /**
     * Method that reads a ClientCredentials from System.in
     * @return ClientCredentials, representing the read ClientCredentials
     * @throws IOException, representing an exception
     * @throws ParseException, representing an exception
     */
    @Override
    public ClientCredentials read() throws IOException, ParseException {
        System.out.println("Please introduce client credentials!");
        String username;
        System.out.print("Username: ");
        username = bufferedReader.readLine();

        String password;
        System.out.print("Password: ");
        password = bufferedReader.readLine();
        return new ClientCredentials(username, password);
    }
}
