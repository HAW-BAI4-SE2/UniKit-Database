package net.unikit.database.interfaces.managers;

import net.unikit.database.exceptions.ConstraintViolationException;
import net.unikit.database.exceptions.EntityNotFoundException;
import net.unikit.database.interfaces.entities.AbstractEntity;

import java.io.Serializable;
import java.util.List;

/**
 * An abstract manager for the entries of a database table.
 * @author Andreas Berks
 * @since 1.2.1
 */
public interface AbstractManager<EntityType extends AbstractEntity, IdBaseType extends Serializable, IdType extends AbstractEntity.ID<IdBaseType>> {
    /**
     * Getter for all entities of the table.
     * @return All entities of the table
     */
    List<EntityType> getAllEntities();

    /**
     * Getter for an entity of the table specified by an identifier.
     * @param id The identifier of the wanted entity
     * @return The entity of the table specified by an identifier
     */
    EntityType getEntity(IdType id) throws EntityNotFoundException;

    /**
     * Updates an existing entity in the table.
     * @param entity Entity object with new attribute values which should be applied to the existing entity
     */
    void updateEntity(EntityType entity) throws EntityNotFoundException, ConstraintViolationException;

    /**
     * Deletes an existing entity in the table.
     * @param entity The Entity which should be deleted
     */
    void deleteEntity(EntityType entity) throws EntityNotFoundException;

    /**
     * Adds a new entity to the table.
     * @param entity The Entity which should be added
     * @return
     */
    IdType addEntity(EntityType entity) throws ConstraintViolationException;

    /**
     * Creates an empty entity object which must be initialized with setter methods.
     * @return An empty entity object
     */
    EntityType createEntity();

    /**
     * Creates an id for an entity.
     */
    IdType createID(IdBaseType value);
}
