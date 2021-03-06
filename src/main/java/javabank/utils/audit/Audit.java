package javabank.utils.audit;

public enum Audit {
    // Application startup
    START_APP,
    STOP_APP,

    // Login & Signup
    LOGIN_ADMIN,
    LOGIN_CLIENT,
    SIGNUP_CLIENT,

    // Admin permissions
    ADD_BANK, DELETE_BANK, EDIT_BANK, // Bank
    ADD_BANKBRANCH, DELETE_BANKBRANCH, EDIT_BANKBRANCH, // BankBranch
    ADD_BANKADDRESS, DELETE_BANKADDRESS, EDIT_BANKADDRESS, // BankAddress
    DELETE_CLIENT_ADMIN, // Client
    DELETE_BANKACCOUNT_ADMIN, // BankAccount

    // Client permissions
    DELETE_CLIENT_CLIENT, // Client
    ADD_BANKACCOUNT, DELETE_BANKACCOUNT_CLIENT, EDIT_BANKACCOUNT, // BankAccount
    ADD_CARD, DELETE_CARD, // Card
    ADD_OPERATION, DELETE_OPERATION, // Operation
    ADD_BANKING_OPERATION, EDIT_BANKING_OPERATION, DELETE_BANKING_OPERATION // Banking Operations
}

