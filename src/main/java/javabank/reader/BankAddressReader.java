package javabank.reader;

import javabank.domain.BankAddress;

import java.io.IOException;

public class BankAddressReader implements Reader<BankAddress>{
    /**
     * Method that reads a BankAddress from the System.in
     * @return BankAddress, representing the read BankAddress
     * @throws IOException, representing an exception
     */
    @Override
    public BankAddress read() throws IOException {
        System.out.println("Please introduce the bank address! ");
        Long idBankAddress = new ReaderID().read();

        String streetName;
        System.out.print("Street name: ");
        streetName = bufferedReader.readLine();

        int number;
        System.out.print("Building number: ");
        number = Integer.parseInt(bufferedReader.readLine());

        String cityName;
        System.out.print("City: ");
        cityName = bufferedReader.readLine();

        String countyName;
        System.out.print("County: ");
        countyName = bufferedReader.readLine();

        int postalCode;
        System.out.print("Postal Code: ");
        postalCode = Integer.parseInt(bufferedReader.readLine());

        String countryName;
        System.out.print("Country: ");
        countryName = bufferedReader.readLine();

        BankAddress bankAddress = new BankAddress(streetName, number, cityName, countyName, postalCode, countryName);
        bankAddress.setId(idBankAddress);
        return bankAddress;
    }
}
