package net.unikit.database.exceptions;

import net.unikit.database.interfaces.entities.AbstractEntity;

/**
 * Created by Andreas on 30.11.2015.
 */
public class EntityNotFoundException extends Exception {
    private AbstractEntity entity;
    private AbstractEntity.ID id;

    public EntityNotFoundException(AbstractEntity entity) {
        this.entity = entity;
        this.id = null;
    }

    public EntityNotFoundException(AbstractEntity.ID id) {
        this.entity = null;
        this.id = id;
    }

    public AbstractEntity getEntity() {
        return entity;
    }

    public AbstractEntity.ID getId() {
        return id;
    }
}
