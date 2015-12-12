package net.unikit.database.exceptions;

import net.unikit.database.interfaces.entities.AbstractEntity;

/**
 * Created by Andreas on 12.12.2015.
 */
public final class EntityNotAddedException extends EntityNotFoundException {
    public EntityNotAddedException(AbstractEntity entity) {
        super(entity);
    }
}
