package javabank.repository;

import javabank.domain.Entity;
import java.text.ParseException;

/**
 * CRUD operations abstract repository (interface)
 * @param <ID> - type E must have an attribute of type ID
 * @param <E> - type of entities saved in repository
 */
public interface AbstractRepository<ID, E extends Entity<ID>> {

    /**
     * Method that gets a specific entity in the Repository
     * @param id ID, representing the id of the entity to be returned
     *            id must not be null
     * @return  the entity with the specified id
     *          or null, if there is no entity with the given id
     */
    E findOne(ID id);

    /**
     * Method that gets all the entities in the Repository
     * @return Iterable<E>, representing all the entities
     */
    Iterable<E> findAll();

    /**
     * Method that adds a new entity to the Repository
     * @param entity E, representing the entity to be added
     *               entity must be not null
     * @return  null,       if the given entity is saved
     *          the entity, otherwise
     */
    E save(E entity) throws ParseException;

    /**
     * Method that removes the entity with the specified id from the Repository
     * @param id ID, representing the id of the entity to be deleted
     *           id must not be null
     * @return the removed entity or null, if there is no entity with the given id
     */
    E delete(ID id);

    /**
     * Method that updates an entity in the Repository
     * @param entity E, representing the new entity
     *               entity must not be null
     * @return  null,       if the entity is updated
     *          the entity, otherwise
     */
    E update(E entity) throws ParseException;
}
