package net.unikit.database.implementations;

import com.google.common.collect.ImmutableList;
import net.unikit.database.external.interfaces.entities.CourseGroupModel;
import net.unikit.database.interfaces.entities.CourseGroup;
import net.unikit.database.interfaces.managers.CourseGroupManager;

import java.util.List;

/**
 * Created by Andreas on 26.11.2015.
 */
final class CourseGroupManagerImpl implements CourseGroupManager {
    private DatabaseManagerImpl databaseManager;

    private CourseGroupManagerImpl(DatabaseManagerImpl databaseManager) {
        this.databaseManager = databaseManager;
    }

    static CourseGroupManager create(DatabaseManagerImpl databaseManager) {
        return new CourseGroupManagerImpl(databaseManager);
    }

    @Override
    public List<CourseGroup> getAllEntities() {
        List<CourseGroupModel> allEntities = databaseManager.getExternalDatabaseManager().getCourseGroupModelManager().getAllEntities();
        ImmutableList.Builder<CourseGroup> builder = ImmutableList.builder();
        for (CourseGroupModel entity : allEntities) {
            builder.add(CourseGroupImpl.create(entity));
        }
        return builder.build();
    }

    @Override
    public CourseGroup getEntity(CourseGroup.ID id) {
        CourseGroupModel entity = databaseManager.getExternalDatabaseManager().getCourseGroupModelManager().getEntity(id.getValue());
        return CourseGroupImpl.create(entity);
    }

    @Override
    public void updateEntity(CourseGroup entity) {
        CourseGroupModel model = ((CourseGroupImpl)(entity)).model;
        databaseManager.getExternalDatabaseManager().getCourseGroupModelManager().updateEntity(model);
    }

    @Override
    public void deleteEntity(CourseGroup entity) {
        CourseGroupModel model = ((CourseGroupImpl)(entity)).model;
        databaseManager.getExternalDatabaseManager().getCourseGroupModelManager().deleteEntity(model);
    }

    @Override
    public CourseGroup.ID addEntity(CourseGroup entity) {
        CourseGroupModel model = ((CourseGroupImpl)(entity)).model;
        Integer id = databaseManager.getExternalDatabaseManager().getCourseGroupModelManager().addEntity(model);
        return new CourseGroupImpl.IDImpl(id);
    }

    @Override
    public CourseGroup createEntity() {
        CourseGroupModel model = databaseManager.getExternalDatabaseManager().getCourseGroupModelManager().createEntity();
        return CourseGroupImpl.create(model);
    }
}
