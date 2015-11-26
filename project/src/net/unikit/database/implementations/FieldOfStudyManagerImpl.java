package net.unikit.database.implementations;

import com.google.common.collect.ImmutableList;
import net.unikit.database.external.interfaces.entities.FieldOfStudyModel;
import net.unikit.database.interfaces.entities.FieldOfStudy;
import net.unikit.database.interfaces.managers.FieldOfStudyManager;

import java.util.List;

/**
 * Created by Andreas on 26.11.2015.
 */
final class FieldOfStudyManagerImpl implements FieldOfStudyManager {
    @Override
    public List<FieldOfStudy> getAllEntities() {
        List<FieldOfStudyModel> allEntities = DatabaseManagerFactory.getExternalDatabaseManager().getFieldOfStudyModelManager().getAllEntities();
        ImmutableList.Builder<FieldOfStudy> builder = ImmutableList.builder();
        for (FieldOfStudyModel entity : allEntities) {
            builder.add(FieldOfStudyImpl.create(entity));
        }
        return builder.build();
    }

    @Override
    public FieldOfStudy getEntity(FieldOfStudy.ID id) {
        FieldOfStudyModel entity = DatabaseManagerFactory.getExternalDatabaseManager().getFieldOfStudyModelManager().getEntity(id.getValue());
        return FieldOfStudyImpl.create(entity);
    }

    @Override
    public void updateEntity(FieldOfStudy entity) {
        FieldOfStudyModel model = ((FieldOfStudyImpl)(entity)).model;
        DatabaseManagerFactory.getExternalDatabaseManager().getFieldOfStudyModelManager().updateEntity(model);
    }

    @Override
    public void deleteEntity(FieldOfStudy entity) {
        FieldOfStudyModel model = ((FieldOfStudyImpl)(entity)).model;
        DatabaseManagerFactory.getExternalDatabaseManager().getFieldOfStudyModelManager().deleteEntity(model);
    }

    @Override
    public FieldOfStudy.ID addEntity(FieldOfStudy entity) {
        FieldOfStudyModel model = ((FieldOfStudyImpl)(entity)).model;
        Integer id = DatabaseManagerFactory.getExternalDatabaseManager().getFieldOfStudyModelManager().addEntity(model);
        return new FieldOfStudyImpl.IDImpl(id);
    }

    @Override
    public FieldOfStudy createEntity() {
        return FieldOfStudyImpl.create(null);
    }
}
