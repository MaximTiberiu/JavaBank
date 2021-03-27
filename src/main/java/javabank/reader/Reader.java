package javabank.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

public interface Reader<E> {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Abstract method that reads an entity from the System.in
     * @return E, representing the read entity
     * @throws IOException, representing an exception
     * @throws ParseException, representing an exception
     */
    E read() throws IOException, ParseException;
}
