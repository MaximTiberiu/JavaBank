package javabank.console;

import javabank.UI.UI;
import javabank.domain.Bank;
import javabank.domain.BankAddress;
import javabank.domain.validators.BankAddressValidator;
import javabank.domain.validators.BankBranchValidator;
import javabank.domain.validators.BankValidator;
import javabank.reader.BankReader;
import javabank.repository.database.BankAddressDatabaseRepository;
import javabank.repository.file.BankAddressInFileRepository;
import javabank.repository.file.BankBranchInFileRepository;
import javabank.repository.file.BankInFileRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
//        UI consoleApplication = new UI();
//        consoleApplication.startApp();

//        BankAddressValidator bankAddressValidator = new BankAddressValidator();
//        BankAddressInFileRepository bankAddressFileRepository = new BankAddressInFileRepository("src/main/resources/CSV - InFileRepository/BankAddress.csv", bankAddressValidator);
//        BankAddress ba = new BankAddress("Str. Revolutiei", 123, "Bucuresti", "Bucuresti", 123456, "Romania");
//        ba.setId(1234L);
//        bankAddressFileRepository.save(ba);



//        String url = "jdbc:sqlserver://DESKTOP-OSUR0CD\\SQLEXPRESS;database=JavaBank";
//        String username = "admin";
//        String password = "javabank123456";
//        BankAddressDatabaseRepository bankAddressDatabaseRepository = new BankAddressDatabaseRepository(url, username, password);
//        BankAddress ba = new BankAddress("Str. Progresului", 205, "Bucuresti", "Bucuresti", 703365, "Romania");
//        ba.setId(1234L);
//        bankAddressDatabaseRepository.save(ba);
//        System.out.println(ba.toString());
    }
}
