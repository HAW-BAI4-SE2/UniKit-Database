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
    @Override
    public List<CourseGroup> getAllEntities() {
        List<CourseGroupModel> allEntities = DatabaseManagerFactory.getExternalDatabaseManager().getCourseGroupModelManager().getAllEntities();
        ImmutableList.Builder<CourseGroup> builder = ImmutableList.builder();
        for (CourseGroupModel entity : allEntities) {
            builder.add(CourseGroupImpl.create(entity));
        }
        return builder.build();
    }

    @Override
    public CourseGroup getEntity(CourseGroup.ID id) {
        CourseGroupModel entity = DatabaseManagerFactory.getExternalDatabaseManager().getCourseGroupModelManager().getEntity(id.getValue());
        return CourseGroupImpl.create(entity);
    }

    @Override
    public void updateEntity(CourseGroup entity) {
        CourseGroupModel model = ((CourseGroupImpl)(entity)).model;
        DatabaseManagerFactory.getExternalDatabaseManager().getCourseGroupModelManager().updateEntity(model);
    }

    @Override
    public void deleteEntity(CourseGroup entity) {
        CourseGroupModel model = ((CourseGroupImpl)(entity)).model;
        DatabaseManagerFactory.getExternalDatabaseManager().getCourseGroupModelManager().deleteEntity(model);
    }

    @Override
    public CourseGroup.ID addEntity(CourseGroup entity) {
        CourseGroupModel model = ((CourseGroupImpl)(entity)).model;
        Integer id = DatabaseManagerFactory.getExternalDatabaseManager().getCourseGroupModelManager().addEntity(model);
        return new CourseGroupImpl.IDImpl(id);
    }

    @Override
    public CourseGroup createEntity() {
        return CourseGroupImpl.create(null);
    }
}
