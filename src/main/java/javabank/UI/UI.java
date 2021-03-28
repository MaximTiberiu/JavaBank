package javabank.UI;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UI {
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
                        // loginAdmin();
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

}
