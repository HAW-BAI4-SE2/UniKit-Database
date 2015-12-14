package net.unikit.database.exceptions;

import net.unikit.database.interfaces.entities.AbstractEntity;

/**
 * Created by Andreas on 30.11.2015.
 */
public class ConstraintViolationException extends Exception {
    private AbstractEntity entity;

    public ConstraintViolationException(Throwable cause, AbstractEntity entity) {
        super(cause);
        this.entity = entity;
    }

    public AbstractEntity getEntity() {
        return entity;
    }
}
