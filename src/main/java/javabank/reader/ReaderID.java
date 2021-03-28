package javabank.reader;

import java.io.IOException;

public class ReaderID implements Reader<Long>{

    /**
     * Method that reads an ID from the System.in
     * @return Long, representing the read ID
     * @throws IOException, representing an exception
     */
    @Override
    public Long read() throws IOException {
        long id;
        String idAsString;
        while(true) {
            System.out.println("Introduce the ID: ");
            idAsString = bufferedReader.readLine();
            try {
                id = Long.parseLong(idAsString);
                break;
            } catch (NumberFormatException e) {
                System.err.println("Introduce a valid ID - a number");
            }
        }
        return id;
    }
}
