package net.unikit.database.exceptions;

import net.unikit.database.interfaces.entities.AbstractEntity;

/**
 * Created by Andreas on 14.12.2015.
 */
public final class MissingPropertyException extends ConstraintViolationException {
    public MissingPropertyException(Throwable cause, AbstractEntity entity) {
        super(cause, entity);
    }
}
