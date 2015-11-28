package net.unikit.database.implementations;

import com.google.common.collect.ImmutableList;
import net.unikit.database.internal.interfaces.entities.CourseRegistrationModel;
import net.unikit.database.interfaces.entities.CourseRegistration;
import net.unikit.database.interfaces.managers.CourseRegistrationManager;

import java.util.List;

/**
 * Created by Andreas on 26.11.2015.
 */
final class CourseRegistrationManagerImpl implements CourseRegistrationManager {
    private DatabaseManagerImpl databaseManager;

    private CourseRegistrationManagerImpl(DatabaseManagerImpl databaseManager) {
        this.databaseManager = databaseManager;
    }

    static CourseRegistrationManager create(DatabaseManagerImpl databaseManager) {
        return new CourseRegistrationManagerImpl(databaseManager);
    }

    @Override
    public List<CourseRegistration> getAllEntities() {
        List<CourseRegistrationModel> allEntities = databaseManager.getInternalDatabaseManager().getCourseRegistrationModelManager().getAllEntities();
        ImmutableList.Builder<CourseRegistration> builder = ImmutableList.builder();
        for (CourseRegistrationModel entity : allEntities) {
            builder.add(CourseRegistrationImpl.create(entity));
        }
        return builder.build();
    }

    @Override
    public CourseRegistration getEntity(CourseRegistration.ID id) {
        CourseRegistrationModel entity = databaseManager.getInternalDatabaseManager().getCourseRegistrationModelManager().getEntity(id.getValue());
        return CourseRegistrationImpl.create(entity);
    }

    @Override
    public void updateEntity(CourseRegistration entity) {
        CourseRegistrationModel model = ((CourseRegistrationImpl)(entity)).model;
        databaseManager.getInternalDatabaseManager().getCourseRegistrationModelManager().updateEntity(model);
    }

    @Override
    public void deleteEntity(CourseRegistration entity) {
        CourseRegistrationModel model = ((CourseRegistrationImpl)(entity)).model;
        databaseManager.getInternalDatabaseManager().getCourseRegistrationModelManager().deleteEntity(model);
    }

    @Override
    public CourseRegistration.ID addEntity(CourseRegistration entity) {
        CourseRegistrationModel model = ((CourseRegistrationImpl)(entity)).model;
        Integer id = databaseManager.getInternalDatabaseManager().getCourseRegistrationModelManager().addEntity(model);
        return new CourseRegistrationImpl.IDImpl(id);
    }

    @Override
    public CourseRegistration createEntity() {
        CourseRegistrationModel model = databaseManager.getInternalDatabaseManager().getCourseRegistrationModelManager().createEntity();
        return CourseRegistrationImpl.create(model);
    }
}
