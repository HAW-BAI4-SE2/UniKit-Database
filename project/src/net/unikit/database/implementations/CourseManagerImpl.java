package net.unikit.database.implementations;

import com.google.common.collect.ImmutableList;
import net.unikit.database.exceptions.*;
import net.unikit.database.external.interfaces.entities.CourseModel;
import net.unikit.database.interfaces.entities.Course;
import net.unikit.database.interfaces.managers.CourseManager;

import java.util.List;

/**
 * Created by Andreas on 26.11.2015.
 */
final class CourseManagerImpl implements CourseManager {
    private DatabaseManagerImpl databaseManager;

    private CourseManagerImpl(DatabaseManagerImpl databaseManager) {
        this.databaseManager = databaseManager;
    }

    static CourseManager create(DatabaseManagerImpl databaseManager) {
        return new CourseManagerImpl(databaseManager);
    }

    @Override
    public List<Course> getAllEntities() {
        List<CourseModel> allEntities = databaseManager.getExternalDatabaseManager().getCourseModelManager().getAllEntities();
        ImmutableList.Builder<Course> builder = ImmutableList.builder();
        for (CourseModel entity : allEntities) {
            builder.add(CourseImpl.create(entity));
        }
        return builder.build();
    }

    @Override
    public Course getEntity(Course.ID id) throws EntityNotFoundException {
        try {
            CourseModel entity = databaseManager.getExternalDatabaseManager().getCourseModelManager().getEntity(id.getValue());
            return CourseImpl.create(entity);
        } catch (ModelNotFoundExceptionCommon e) {
            throw new EntityNotFoundException(id);
        }
    }

    @Override
    public void updateEntity(Course entity) throws EntityNotFoundException, ConstraintViolationException {
        CourseModel model = ((CourseImpl)(entity)).model;
        try {
            databaseManager.getExternalDatabaseManager().getCourseModelManager().updateEntity(model);
        } catch (ModelNotFoundExceptionCommon e) {
            throw new EntityNotFoundException(entity);
        } catch (ConstraintViolationExceptionCommon e) {
            throw new ConstraintViolationException(e.getCause(), entity);
        } catch (ModelNotAddedExceptionCommon modelNotAddedExceptionCommon) {
            throw new EntityNotAddedException(entity);
        } catch (MissingPropertyExceptionCommon missingPropertyExceptionCommon) {
            throw new MissingPropertyException(missingPropertyExceptionCommon.getCause(), entity);
        }
    }

    @Override
    public void deleteEntity(Course entity) throws EntityNotFoundException {
        CourseModel model = ((CourseImpl)(entity)).model;
        try {
            databaseManager.getExternalDatabaseManager().getCourseModelManager().deleteEntity(model);
        } catch (ModelNotFoundExceptionCommon e) {
            throw new EntityNotFoundException(entity);
        } catch (ModelNotAddedExceptionCommon modelNotAddedExceptionCommon) {
            throw new EntityNotAddedException(entity);
        }
    }

    @Override
    public Course.ID addEntity(Course entity) throws ConstraintViolationException {
        CourseModel model = ((CourseImpl)(entity)).model;
        Integer id = null;
        try {
            id = databaseManager.getExternalDatabaseManager().getCourseModelManager().addEntity(model);
        } catch (ConstraintViolationExceptionCommon e) {
            throw new ConstraintViolationException(e.getCause(), entity);
        } catch (MissingPropertyExceptionCommon missingPropertyExceptionCommon) {
            throw new MissingPropertyException(missingPropertyExceptionCommon.getCause(), entity);
        }
        return new CourseImpl.IDImpl(id);
    }

    @Override
    public Course createEntity() {
        CourseModel model = databaseManager.getExternalDatabaseManager().getCourseModelManager().createEntity();
        return CourseImpl.create(model);
    }

    @Override
    public Course.ID createID(Integer value) {
        return new CourseImpl.IDImpl(value);
    }
}
