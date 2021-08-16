package javabank.repository.database;

import javabank.domain.Client;
import javabank.repository.AbstractRepository;

import java.text.ParseException;

public class ClientDatabaseRepository implements AbstractRepository<Long, Client> {

    /**
     * Method that gets a specific entity in the Repository
     *
     * @param aLong ID, representing the id of the entity to be returned
     *              id must not be null
     * @return the entity with the specified id
     * or null, if there is no entity with the given id
     */
    @Override
    public Client findOne(Long aLong) {
        return null;
    }

    /**
     * Method that gets all the entities in the Repository
     *
     * @return Iterable<E>, representing all the entities
     */
    @Override
    public Iterable<Client> findAll() {
        return null;
    }

    /**
     * Method that adds a new entity to the Repository
     *
     * @param entity E, representing the entity to be added
     *               entity must be not null
     * @return null,       if the given entity is saved
     * the entity, otherwise
     */
    @Override
    public Client save(Client entity) throws ParseException {
        return null;
    }

    /**
     * Method that removes the entity with the specified id from the Repository
     *
     * @param aLong ID, representing the id of the entity to be deleted
     *              id must not be null
     * @return the removed entity or null, if there is no entity with the given id
     */
    @Override
    public Client delete(Long aLong) {
        return null;
    }

    /**
     * Method that updates an entity in the Repository
     *
     * @param entity E, representing the new entity
     *               entity must not be null
     * @return null,       if the entity is updated
     * the entity, otherwise
     */
    @Override
    public Client update(Client entity) throws ParseException {
        return null;
    }
}
