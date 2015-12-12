package net.unikit.database.implementations;

import com.google.common.collect.ImmutableList;
import net.unikit.database.exceptions.*;
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
    public CourseGroup getEntity(CourseGroup.ID id) throws EntityNotFoundException {
        try {
            CourseGroupModel entity = databaseManager.getExternalDatabaseManager().getCourseGroupModelManager().getEntity(id.getValue());
            return CourseGroupImpl.create(entity);
        } catch (ModelNotFoundExceptionCommon e) {
            throw new EntityNotFoundException(id);
        }
    }

    @Override
    public void updateEntity(CourseGroup entity) throws EntityNotFoundException, ConstraintViolationException {
        CourseGroupModel model = ((CourseGroupImpl)(entity)).model;
        try {
            databaseManager.getExternalDatabaseManager().getCourseGroupModelManager().updateEntity(model);
        } catch (ModelNotFoundExceptionCommon e) {
            throw new EntityNotFoundException(entity);
        } catch (ConstraintViolationExceptionCommon e) {
            throw new ConstraintViolationException(e.getCause(), entity);
        } catch (ModelNotAddedExceptionCommon modelNotAddedExceptionCommon) {
            throw new EntityNotAddedException(entity);
        }
    }

    @Override
    public void deleteEntity(CourseGroup entity) throws EntityNotFoundException {
        CourseGroupModel model = ((CourseGroupImpl)(entity)).model;
        try {
            databaseManager.getExternalDatabaseManager().getCourseGroupModelManager().deleteEntity(model);
        } catch (ModelNotFoundExceptionCommon e) {
            throw new EntityNotFoundException(entity);
        } catch (ModelNotAddedExceptionCommon modelNotAddedExceptionCommon) {
            throw new EntityNotAddedException(entity);
        }
    }

    @Override
    public CourseGroup.ID addEntity(CourseGroup entity) throws ConstraintViolationException {
        CourseGroupModel model = ((CourseGroupImpl)(entity)).model;
        Integer id = null;
        try {
            id = databaseManager.getExternalDatabaseManager().getCourseGroupModelManager().addEntity(model);
        } catch (ConstraintViolationExceptionCommon e) {
            throw new ConstraintViolationException(e.getCause(), entity);
        }
        return new CourseGroupImpl.IDImpl(id);
    }

    @Override
    public CourseGroup createEntity() {
        CourseGroupModel model = databaseManager.getExternalDatabaseManager().getCourseGroupModelManager().createEntity();
        return CourseGroupImpl.create(model);
    }

    @Override
    public CourseGroup.ID createID(Integer value) {
        return new CourseGroupImpl.IDImpl(value);
    }
}
