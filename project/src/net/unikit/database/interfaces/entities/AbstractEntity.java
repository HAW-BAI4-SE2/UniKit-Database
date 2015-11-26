package net.unikit.database.interfaces.entities;

/**
 * An abstract entity.
 * @author Andreas Berks
 * @since 1.2.1
 */
public interface AbstractEntity {
    /**
     * An id for an entity.
     */
    interface ID<T> {
        T getValue();
    }
}
