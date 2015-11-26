package net.unikit.database.implementations;

import com.google.common.collect.ImmutableList;
import net.unikit.database.external.interfaces.entities.CourseModel;
import net.unikit.database.interfaces.entities.Course;
import net.unikit.database.interfaces.managers.CourseManager;

import java.util.List;

/**
 * Created by Andreas on 26.11.2015.
 */
final class CourseManagerImpl implements CourseManager {
    @Override
    public List<Course> getAllEntities() {
        List<CourseModel> allEntities = DatabaseManagerFactory.getExternalDatabaseManager().getCourseModelManager().getAllEntities();
        ImmutableList.Builder<Course> builder = ImmutableList.builder();
        for (CourseModel entity : allEntities) {
            builder.add(CourseImpl.create(entity));
        }
        return builder.build();
    }

    @Override
    public Course getEntity(Course.ID id) {
        CourseModel entity = DatabaseManagerFactory.getExternalDatabaseManager().getCourseModelManager().getEntity(id.getValue());
        return CourseImpl.create(entity);
    }

    @Override
    public void updateEntity(Course entity) {
        CourseModel model = ((CourseImpl)(entity)).model;
        DatabaseManagerFactory.getExternalDatabaseManager().getCourseModelManager().updateEntity(model);
    }

    @Override
    public void deleteEntity(Course entity) {
        CourseModel model = ((CourseImpl)(entity)).model;
        DatabaseManagerFactory.getExternalDatabaseManager().getCourseModelManager().deleteEntity(model);
    }

    @Override
    public Course.ID addEntity(Course entity) {
        CourseModel model = ((CourseImpl)(entity)).model;
        Integer id = DatabaseManagerFactory.getExternalDatabaseManager().getCourseModelManager().addEntity(model);
        return new CourseImpl.IDImpl(id);
    }

    @Override
    public Course createEntity() {
        return CourseImpl.create(null);
    }
}
