package net.unikit.database.interfaces.entities;

import java.io.Serializable;

/**
 * An abstract entity.
 * @author Andreas Berks
 * @since 1.2.1
 */
public interface AbstractEntity {
    /**
     * An id for an entity.
     */
    interface ID<T extends Serializable> {
        T getValue();
    }
}
