package net.unikit.database.implementations;

import com.google.common.collect.ImmutableList;
import net.unikit.database.exceptions.*;
import net.unikit.database.external.interfaces.entities.CourseLectureModel;
import net.unikit.database.interfaces.entities.CourseLecture;
import net.unikit.database.interfaces.managers.CourseLectureManager;

import java.util.List;

/**
 * Created by Andreas on 26.11.2015.
 */
final class CourseLectureManagerImpl implements CourseLectureManager {
    private DatabaseManagerImpl databaseManager;

    private CourseLectureManagerImpl(DatabaseManagerImpl databaseManager) {
        this.databaseManager = databaseManager;
    }

    static CourseLectureManager create(DatabaseManagerImpl databaseManager) {
        return new CourseLectureManagerImpl(databaseManager);
    }

    @Override
    public List<CourseLecture> getAllEntities() {
        List<CourseLectureModel> allEntities = databaseManager.getExternalDatabaseManager().getCourseLectureModelManager().getAllEntities();
        ImmutableList.Builder<CourseLecture> builder = ImmutableList.builder();
        for (CourseLectureModel entity : allEntities) {
            builder.add(CourseLectureImpl.create(entity));
        }
        return builder.build();
    }

    @Override
    public CourseLecture getEntity(CourseLecture.ID id) throws EntityNotFoundException {
        try {
            CourseLectureModel entity = databaseManager.getExternalDatabaseManager().getCourseLectureModelManager().getEntity(id.getValue());
            return CourseLectureImpl.create(entity);
        } catch (ModelNotFoundExceptionCommon e) {
            throw new EntityNotFoundException(id);
        }
    }

    @Override
    public void updateEntity(CourseLecture entity) throws EntityNotFoundException, ConstraintViolationException {
        CourseLectureModel model = ((CourseLectureImpl)(entity)).model;
        try {
            databaseManager.getExternalDatabaseManager().getCourseLectureModelManager().updateEntity(model);
        } catch (ModelNotFoundExceptionCommon e) {
            throw new EntityNotFoundException(entity);
        } catch (ConstraintViolationExceptionCommon e) {
            throw new ConstraintViolationException(e.getCause(), entity);
        } catch (ModelNotAddedExceptionCommon modelNotAddedExceptionCommon) {
            throw new EntityNotAddedException(entity);
        }
    }

    @Override
    public void deleteEntity(CourseLecture entity) throws EntityNotFoundException {
        CourseLectureModel model = ((CourseLectureImpl)(entity)).model;
        try {
            databaseManager.getExternalDatabaseManager().getCourseLectureModelManager().deleteEntity(model);
        } catch (ModelNotFoundExceptionCommon e) {
            throw new EntityNotFoundException(entity);
        } catch (ModelNotAddedExceptionCommon modelNotAddedExceptionCommon) {
            throw new EntityNotAddedException(entity);
        }
    }

    @Override
    public CourseLecture.ID addEntity(CourseLecture entity) throws ConstraintViolationException {
        CourseLectureModel model = ((CourseLectureImpl)(entity)).model;
        Integer id = null;
        try {
            id = databaseManager.getExternalDatabaseManager().getCourseLectureModelManager().addEntity(model);
        } catch (ConstraintViolationExceptionCommon e) {
            throw new ConstraintViolationException(e.getCause(), entity);
        }
        return new CourseLectureImpl.IDImpl(id);
    }

    @Override
    public CourseLecture createEntity() {
        CourseLectureModel model = databaseManager.getExternalDatabaseManager().getCourseLectureModelManager().createEntity();
        return CourseLectureImpl.create(model);
    }

    @Override
    public CourseLecture.ID createID(Integer value) {
        return new CourseLectureImpl.IDImpl(value);
    }
}
