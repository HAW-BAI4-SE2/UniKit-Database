package net.unikit.database.interfaces.managers;

import net.unikit.database.interfaces.entities.AbstractEntity;

import java.util.List;

public interface AbstractManager<EntityType extends AbstractEntity, IdType> {
    List<EntityType> getAllEntities();
    EntityType getEntity(IdType id);
    void updateEntity(EntityType entity);
    void deleteEntity(EntityType entity);
    IdType addEntity(EntityType entity);
    EntityType createEntity();
}
