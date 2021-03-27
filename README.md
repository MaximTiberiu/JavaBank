# JavaBank
> Banking App for Advanced Programming Elements Project

## Table of contents
* [General info](#general-info)
* [Stages of development](#stages-of-development)
* [Technologies](#technologies)
* [Status](#status)
* [License](#license)

## General info
* JavaBank is a basic banking application. The application is developed as a university project for the Advanced Programming Elements course.
* The application contains a list of banks. The user can create a bank account at the banks listed in the application. List of features include:
    * Bank Transfers;
    * Basic Payments;  
    * Bill Payments;
    * Cashback;
    * Subscriptions;
    * Vaults;
    * Getting statistics about user's bank account;
    * Cards;
    * Withdrawal;
    * Loans;
    * Account management.
    

## Stages of development
1. **First Stage**
    * Create a list based on the chosen topic with at least 10 actions/queries that can be done within the system, and a list with at least 8 types of objects.
    * Implement an application in Java based on the above.
    * The application will contain:
        * simple classes with private/protected attributes and access methods;
        * at least 2 different collections capable of handling previously defined  objects (eq List, Set, Map, etc.);
        * the use of inheritance for the creations of additional classes and their use in collections;
        * at least one service class exposing the operations of the system;
        * a Main class from which calls to services are made.
    
2. **Second Stage**
    * Extend the project from the first stage by achieving persistence using file:
        * CSV files will be made for at least 4 of the classes defined in the first stage. Each column in the file is separated by a comma;
        * Generic singleton services will be provided for writing and reading from files;
        * When starting the program, the data from the files will be uploaded using the created services.
    * Perform an audit service. A service will be performed to write to a CSV file each time one of the actions described in the first stage is performed *(File Structure: action_name, timestamp)*.

3. **Third Stage**
    * Replace the services performed in the second stage with services that ensure persistence using the database using JDBC. Perform services that exposes **CRUD** operations for at least 4 of the defined classes.

## Technologies
* Java SE 13 Platform - used for the main development of the application;
* IntelliJ IDEA Ultimate - the used IDE;
* Gradle - Build Automation Tool.

## Status
Project is: *in process of developing the first stage*

## License
The project is licensed under the terms of the **MIT** license.
> You can check out the full license [here](https://github.com/MaximTiberiu/JavaBank/blob/main/LICENSE).