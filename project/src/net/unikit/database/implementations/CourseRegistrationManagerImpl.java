package net.unikit.database.implementations;

import com.google.common.collect.ImmutableList;
import net.unikit.database.exceptions.ConstraintViolationExceptionCommon;
import net.unikit.database.exceptions.ConstraintViolationException;
import net.unikit.database.exceptions.EntityNotFoundException;
import net.unikit.database.exceptions.ModelNotFoundExceptionCommon;
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
    public CourseRegistration getEntity(CourseRegistration.ID id) throws EntityNotFoundException {
        try {
            CourseRegistrationModel entity = databaseManager.getInternalDatabaseManager().getCourseRegistrationModelManager().getEntity(id.getValue());
            return CourseRegistrationImpl.create(entity);
        } catch (ModelNotFoundExceptionCommon e) {
            throw new EntityNotFoundException(id);
        }
    }

    @Override
    public void updateEntity(CourseRegistration entity) throws EntityNotFoundException, ConstraintViolationException {
        CourseRegistrationModel model = ((CourseRegistrationImpl)(entity)).model;
        try {
            databaseManager.getInternalDatabaseManager().getCourseRegistrationModelManager().updateEntity(model);
        } catch (ModelNotFoundExceptionCommon e) {
            throw new EntityNotFoundException(entity);
        } catch (ConstraintViolationExceptionCommon e) {
            throw new ConstraintViolationException(e.getCause(), entity);
        }
    }

    @Override
    public void deleteEntity(CourseRegistration entity) throws EntityNotFoundException {
        CourseRegistrationModel model = ((CourseRegistrationImpl)(entity)).model;
        try {
            databaseManager.getInternalDatabaseManager().getCourseRegistrationModelManager().deleteEntity(model);
        } catch (ModelNotFoundExceptionCommon e) {
            throw new EntityNotFoundException(entity);
        }
    }

    @Override
    public CourseRegistration.ID addEntity(CourseRegistration entity) throws ConstraintViolationException {
        CourseRegistrationModel model = ((CourseRegistrationImpl)(entity)).model;
        Integer id = null;
        try {
            id = databaseManager.getInternalDatabaseManager().getCourseRegistrationModelManager().addEntity(model);
        } catch (ConstraintViolationExceptionCommon e) {
            throw new ConstraintViolationException(e.getCause(), entity);
        }
        return new CourseRegistrationImpl.IDImpl(id);
    }

    @Override
    public CourseRegistration createEntity() {
        CourseRegistrationModel model = databaseManager.getInternalDatabaseManager().getCourseRegistrationModelManager().createEntity();
        return CourseRegistrationImpl.create(model);
    }

    @Override
    public CourseRegistration.ID createID(Integer value) {
        return new CourseRegistrationImpl.IDImpl(value);
    }
}
