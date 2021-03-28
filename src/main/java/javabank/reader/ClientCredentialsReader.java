package javabank.reader;

import javabank.domain.ClientCredentials;

import java.io.IOException;
import java.text.ParseException;

public class ClientCredentialsReader implements Reader<ClientCredentials> {
    /**
     * Method that reads a ClientCredentials from System.in
     * @return ClientCredentials, representing the read ClientCredentials
     * @throws IOException, representing an exception
     */
    @Override
    public ClientCredentials read() throws IOException {
        System.out.println("Please introduce client credentials!");
        Long idClientCredentials = new ReaderID().read();

        String username;
        System.out.print("Username: ");
        username = bufferedReader.readLine();

        String password;
        System.out.print("Password: ");
        password = bufferedReader.readLine();

        ClientCredentials clientCredentials = new ClientCredentials(username, password);
        clientCredentials.setId(idClientCredentials);
        return clientCredentials;
    }
}
