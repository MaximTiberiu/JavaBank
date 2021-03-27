package javabank.reader;

import javabank.domain.BankAccount;
import javabank.domain.Client;
import javabank.domain.ClientCredentials;

import java.io.IOException;
import java.util.ArrayList;

public class ClientReader implements Reader<Client>{
    /**
     * Method that reads a Client from System.in
     * @return Client, representing the read Client
     * @throws IOException, representing an exception
     */
    @Override
    public Client read() throws IOException {
        System.out.println("Please introduce client details!");
        String firstName;
        System.out.print("First name: ");
        firstName = bufferedReader.readLine();

        String lastName;
        System.out.print("Last name: ");
        lastName = bufferedReader.readLine();

        String CNP;
        System.out.print("CNP: ");
        CNP = bufferedReader.readLine();

        String telephoneNumber;
        System.out.print("Telephone number: ");
        telephoneNumber = bufferedReader.readLine();

        String email;
        System.out.print("Email: ");
        email = bufferedReader.readLine();

        ClientCredentials credentials;
        ClientCredentialsReader clientCredentialsReader = new ClientCredentialsReader();
        credentials = clientCredentialsReader.read();

        ArrayList<BankAccount> bankAccounts = new ArrayList<BankAccount>();
        return new Client(firstName, lastName, CNP, telephoneNumber, email, credentials, bankAccounts);
    }
}
