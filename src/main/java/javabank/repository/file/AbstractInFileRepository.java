package javabank.repository.file;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import javabank.domain.Entity;
import javabank.domain.validators.Validator;
import javabank.repository.memory.InMemoryRepository;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractInFileRepository<ID, E extends Entity<ID>> extends InMemoryRepository<ID, E> {
    String fileName;

    /**
     * Constructor that creates a new InMemoryRepository
     * @param fileName String, representing the name of the file where the data is loaded from / stored to
     * @param validator Validator<E>, representing the validator of the AbstractFileRepository
     */
    public AbstractInFileRepository(String fileName, Validator<E> validator) {
        super(validator);
        this.fileName = fileName;

        File file = new File(fileName);
        if(file.length() != 0) {
            loadData();
        }
    }

    /**
     * Method that loads the data from file
     */
    private void loadData() {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(fileName));
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build(); // first row is the header of the .csv file
            List<String[]> lines = csvReader.readAll();

            lines.forEach(line -> {
                E e = extractEntity(line);
                try {
                    super.save(e);
                }
                catch (ParseException parseException) {
                    parseException.printStackTrace();
                }
            });
        }
        catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method that reloads the data from file
     */
    private void reload() {
        Iterable<E> currentEntities = super.findAll();
        try {
            PrintWriter writer = new PrintWriter(fileName);
            writer.print("");
            writer.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File to reaload doesn't exist!");
        }
        currentEntities.forEach(this::writeToFile);
    }

    /**
     * Method that extracts an E entity having a specified list of attributes
     * @param attributes String[], representing the attributes of the entity to be extracted
     * @return E, representing the extracted entity based on the given attributes
     */
    public abstract E extractEntity(String[] attributes);

    /**
     * Method that creates a list of String attributes for CSVReader
     * @param entity Entity, representing the entity whose list of attributes is being determined
     * @return String[], representing the list of attributes
     */
    public abstract String[] createEntityAsStringList(E entity);

    /**
     * Method that adds a new entity to the AbstractIInFileRepository
     * @param entity E, representing the entity to be added
     *                  entity must be not null
     * @return  null,               if the given entity is saved
     *          non-null entity,    otherwise (eg. already exists)
     * @throws ParseException, representing an exception
     */
    @Override
    public E save(E entity) throws ParseException {
        E e = super.save(entity);
        if (e == null) {
            writeToFile(entity);
        }
        return e;
    }

    /**
     * Method that deletes an entity from the AbstractInFileRepository
     * @param id ID, representing the id of the entity to be deleted
     *           id must not be null
     * @return E, representing the removed entity or null if the entity doesn't exist
     */
    @Override
    public E delete(ID id) {
        E e = super.delete(id);
        if (e != null) {
          this.reload();
        }
        return e;
    }

    // TODO: update() override

    /**
     * Method that writes the entity to the file
     * @param entity E, representing the entity to be written to the file
     */
    protected void writeToFile(E entity) {
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(fileName, true))) {
            csvWriter.writeNext(createEntityAsStringList(entity));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
