package net.unikit.database.interfaces.managers;

import java.util.List;

public interface AbstractManager<E, I> {
    List<E> getAllEntities();
    E getEntity(I id);
    void updateEntity(E entity);
    void deleteEntity(E entity);
    I addEntity(E entity);
    E createEntity();
}
