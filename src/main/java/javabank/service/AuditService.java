package javabank.service;

import com.opencsv.CSVWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

public class AuditService {
    private static AuditService auditService = null;

    private AuditService() {}

    public static AuditService getInstance() {
        if (auditService == null) {
            auditService = new AuditService();
        }
        return auditService;
    }

    public void write(String action) {
        try {
            File file = new File("src/main/resources/audit/audit.csv");

            // creates the audit file if it doesn't exist
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(file, true); // append mode = true
            CSVWriter csvWriter = new CSVWriter(fileWriter);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            // adding header to csv if the file is empty
            if (file.length() == 0) {
                String[] header = {"Action", "Timestamp"};
                csvWriter.writeNext(header);
            }

            // add data to csv
            String[] data = {action, timestamp.toString()};
            csvWriter.writeNext(data);
            csvWriter.close();

        } catch (IOException e) {
            System.out.println("Problem handling the files!");
            e.printStackTrace();
        }
    }

    public void write(String action, Long clientID) {
        try {
            File file = new File("src/main/resources/audit/audit.csv");

            // creates the audit file if it doesn't exist
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(file, true); // append mode = true
            CSVWriter csvWriter = new CSVWriter(fileWriter);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            // adding header to csv if the file is empty
            if (file.length() == 0) {
                String[] header = {"Action", "Timestamp"};
                csvWriter.writeNext(header);
            }

            // add data to csv
            String actionParam = action + " - client@" + clientID.toString();
            String[] data = {actionParam, timestamp.toString()};
            csvWriter.writeNext(data);
            csvWriter.close();

        } catch (IOException e) {
            System.out.println("Problem handling the files!");
            e.printStackTrace();
        }
    }
}
