package javabank.repository.memory;

import javabank.domain.Entity;
import javabank.domain.validators.Validator;
import javabank.repository.AbstractRepository;
import javabank.domain.validators.ValidationException;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class InMemoryRepository<ID, E extends Entity<ID>> implements AbstractRepository<ID, E> {
    private final Validator<E> validator;
    protected Map<ID, E> entities;

    /**
     * Constructor that creates a new InMemoryRepository
     * @param validator Validator<E>, representing the validator of the InMemoryRepository
     */
    public InMemoryRepository(Validator<E> validator) {
        this.validator = validator;
        entities = new HashMap<ID, E>();
    }

    /**
     * Method that gets a specific entity in the Repository
     * @param id ID, representing the id of the entity to be returned
     *               id must not be null
     * @return E,   representing the entity with the specified id
     *              or null, if there is no entity with the given id
     * @throws IllegalArgumentException if the id is null
     */
    @Override
    public E findOne(ID id) {
        if (id == null) {
            throw new IllegalArgumentException("ID must be not null");
        }
        return entities.get(id);
    }

    /**
     * Method that gets all the entities in the Repository
     *
     * @return Iterable<E>, representing all the entities
     */
    @Override
    public Iterable<E> findAll() {
        return entities.values();
    }

    /**
     * Method that adds a new entity to the Repository
     * @param entity E, representing the entity to be added
     *                  entity must be not null
     * @return  null,       if the given entity is saved
     *          the entity, otherwise
     * @throws ValidationException, if the entity is not valid
     * @throws IllegalArgumentException, if the given entity is null
     */
    @Override
    public E save(E entity) throws ParseException {
        if (entity == null) {
            throw new IllegalArgumentException("Entity must be not null");
        }
        validator.validate(entity);
        if (entities.get(entity.getId()) != null) {
            return entity;
        }
        else entities.put(entity.getId(), entity);
        return null;
    }

    /**
     * Method that removes the entity with the specified id from the Repository
     *
     * @param id ID, representing the id of the entity to be deleted
     *           id must not be null
     * @return the removed entity or null, if there is no entity with the given id
     * @throws IllegalArgumentException, if the given id is null
     */
    @Override
    public E delete(ID id) {
        return entities.remove(id);
    }

    /**
     * Method that updates an entity in the Repository
     * @param entity E, representing the new entity
     *               entity must not be null
     * @return null,    if the entity is updated
     *                  the entity, otherwise
     * @throws IllegalArgumentException, if the given entity is null
     * @throws ValidationException, id the entity is not valid
     */
    @Override
    public E update(E entity) throws ParseException {
        if (entity == null) {
            throw new IllegalArgumentException("Entity must be not null");
        }
        validator.validate(entity);
        entities.put(entity.getId(), entity);

        if (entities.get(entity.getId()) != null) {
            entities.put(entity.getId(), entity);
            return null;
        }
        return entity;
    }
}
