package net.unikit.database.implementations;

/**
 * An id for an entry.
 * @author Andreas Berks
 * @since 1.2.1
 */
public abstract class AbstractID<T> {
    private T value;

    protected AbstractID(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
