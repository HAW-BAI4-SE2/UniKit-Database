package net.unikit.database.implementations;

import net.unikit.database.interfaces.entities.AbstractEntity;
import net.unikit.database.interfaces.managers.AbstractManager;

import java.util.List;

/**
 * Created by Andreas on 26.11.2015.
 */
abstract class AbstractManagerImpl<EntityType extends AbstractEntity, IdType extends AbstractEntity.ID>
        implements AbstractManager<EntityType, IdType> {
    @Override
    public List<EntityType> getAllEntities() {
        return null;
    }

    @Override
    public EntityType getEntity(IdType id) {
        return null;
    }

    @Override
    public void updateEntity(EntityType entity) {

    }

    @Override
    public void deleteEntity(EntityType entity) {

    }

    @Override
    public IdType addEntity(EntityType entity) {
        return null;
    }

    @Override
    public EntityType createEntity() {
        return null;
    }
}
