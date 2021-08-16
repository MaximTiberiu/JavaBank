package javabank.UI;

import javabank.domain.validators.BankBranchValidator;
import javabank.domain.validators.BankValidator;
import javabank.repository.database.BankAddressDatabaseRepository;
import javabank.repository.file.BankBranchInFileRepository;
import javabank.repository.file.BankInFileRepository;
import javabank.service.AuditService;
import javabank.utils.audit.Audit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UI {
//    String url = "jdbc:sqlserver://DESKTOP-OSUR0CD\\SQLEXPRESS;database=JavaBank";
//    String username = "admin";
//    String password = "javabank123456";
//    BankAddressDatabaseRepository bankAddressDatabaseRepository = new BankAddressDatabaseRepository(url, username, password);
//    BankBranchInFileRepository bankBranchInFileRepository = new BankBranchInFileRepository("src/main/resources/CSV - InFileRepository/BankBranch.csv", new BankBranchValidator());
//    BankInFileRepository bankInFileRepository = new BankInFileRepository("src/main/java/javabank/repository/file/BankInFileRepository.java", new BankValidator(), bankAddressDatabaseRepository, bankBranchInFileRepository);

    AuditService auditService = AuditService.getInstance();
    Audit audit;

    private void mainMenu() {
        System.out.println("-------------------------------------------------");
        System.out.println("\t\t\t\t\tJavaBank");
        System.out.println("-------------------------------------------------");
        System.out.println("\n\nPlease select an option from the menu below: ");
        System.out.println("1. Login");
        System.out.println("2. Create a New Account");
        System.out.println("3. Quit");
    }

    private void loginMenu() {
        System.out.println("-------------------------------------------------");
        System.out.println("\t\t\t\t\tLogin");
        System.out.println("-------------------------------------------------");
        System.out.println("\n\nPlease select an option from the menu below: ");
        System.out.println("1. Login as Client");
        System.out.println("2. Login as Admin");
        System.out.println("3. Return to Main Menu");
        System.out.println("4. Quit");
    }

    private void createAccountMenu() {
        System.out.println("-------------------------------------------------");
        System.out.println("\t\t\t\t\tCreate an Account");
        System.out.println("-------------------------------------------------");
        System.out.println("\n\nPlease select an option from the menu below: ");
        System.out.println("1. Signup as Client");
        System.out.println("2. Return to Main Menu");
        System.out.println("3. Quit");
    }

    public void startApp() throws IOException {
        auditService.write(Audit.START_APP.toString());
        int command;
        while(true) {
            try {
                mainMenu();
                System.out.print("Please select your choice: ");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                command = Integer.parseInt(bufferedReader.readLine());

                switch(command) {
                    case 1:
                        login();
                        return;
                    case 2:
                        createAccount();
                        return;
                    case 3:
                        auditService.write(Audit.STOP_APP.toString());
                        return;
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void login() throws IOException {
        int command;
        while(true) {
            try {
                loginMenu();
                System.out.print("Please select your choice: ");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                command = Integer.parseInt(bufferedReader.readLine());

                switch(command) {
                    case 1:
                        // loginClient();
                        return;
                    case 2:
                        loginAdmin();
                        return;
                    case 3:
                        startApp();
                        return;
                    case 4:
                        return;
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void createAccount() throws IOException {
        int command;
        while(true) {
            try {
                createAccountMenu();
                System.out.print("Please select your choice: ");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                command = Integer.parseInt(bufferedReader.readLine());

                switch(command) {
                    case 1:
                        // createAccountClient();
                        return;
                    case 2:
                        startApp();
                        return;
                    case 3:
                        return;
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void loginAdmin() throws IOException {
        String username, password;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("-------------------------------------------------");
        System.out.println("\t\t\t\t\tLogin as Admin");
        System.out.println("-------------------------------------------------");
        System.out.println("\n\nPlease enter the username and the password: ");

        System.out.print("Username: ");
        username = bufferedReader.readLine();
        System.out.print("Passowrd: ");
        password = bufferedReader.readLine();

        if(username.equals("admin") && password.equals("javabank123456")) {
            auditService.write(Audit.LOGIN_ADMIN.toString());
            // adminPanel();
        } else {
            loginAdmin();
        }
    }
}
