package net.unikit.database.implementations;

import com.google.common.collect.ImmutableList;
import net.unikit.database.exceptions.*;
import net.unikit.database.external.interfaces.entities.FieldOfStudyModel;
import net.unikit.database.interfaces.entities.FieldOfStudy;
import net.unikit.database.interfaces.managers.FieldOfStudyManager;

import java.util.List;

/**
 * Created by Andreas on 26.11.2015.
 */
final class FieldOfStudyManagerImpl implements FieldOfStudyManager {
    private DatabaseManagerImpl databaseManager;

    private FieldOfStudyManagerImpl(DatabaseManagerImpl databaseManager) {
        this.databaseManager = databaseManager;
    }

    static FieldOfStudyManager create(DatabaseManagerImpl databaseManager) {
        return new FieldOfStudyManagerImpl(databaseManager);
    }

    @Override
    public List<FieldOfStudy> getAllEntities() {
        List<FieldOfStudyModel> allEntities = databaseManager.getExternalDatabaseManager().getFieldOfStudyModelManager().getAllEntities();
        ImmutableList.Builder<FieldOfStudy> builder = ImmutableList.builder();
        for (FieldOfStudyModel entity : allEntities) {
            builder.add(FieldOfStudyImpl.create(entity));
        }
        return builder.build();
    }

    @Override
    public FieldOfStudy getEntity(FieldOfStudy.ID id) throws EntityNotFoundException {
        try {
            FieldOfStudyModel entity = databaseManager.getExternalDatabaseManager().getFieldOfStudyModelManager().getEntity(id.getValue());
            return FieldOfStudyImpl.create(entity);
        } catch (ModelNotFoundExceptionCommon e) {
            throw new EntityNotFoundException(id);
        }
    }

    @Override
    public void updateEntity(FieldOfStudy entity) throws EntityNotFoundException, ConstraintViolationException {
        FieldOfStudyModel model = ((FieldOfStudyImpl)(entity)).model;
        try {
            databaseManager.getExternalDatabaseManager().getFieldOfStudyModelManager().updateEntity(model);
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
    public void deleteEntity(FieldOfStudy entity) throws EntityNotFoundException {
        FieldOfStudyModel model = ((FieldOfStudyImpl)(entity)).model;
        try {
            databaseManager.getExternalDatabaseManager().getFieldOfStudyModelManager().deleteEntity(model);
        } catch (ModelNotFoundExceptionCommon e) {
            throw new EntityNotFoundException(entity);
        } catch (ModelNotAddedExceptionCommon modelNotAddedExceptionCommon) {
            throw new EntityNotAddedException(entity);
        }
    }

    @Override
    public FieldOfStudy.ID addEntity(FieldOfStudy entity) throws ConstraintViolationException {
        FieldOfStudyModel model = ((FieldOfStudyImpl)(entity)).model;
        Integer id = null;
        try {
            id = databaseManager.getExternalDatabaseManager().getFieldOfStudyModelManager().addEntity(model);
        } catch (ConstraintViolationExceptionCommon e) {
            throw new ConstraintViolationException(e.getCause(), entity);
        } catch (MissingPropertyExceptionCommon missingPropertyExceptionCommon) {
            throw new MissingPropertyException(missingPropertyExceptionCommon.getCause(), entity);
        }
        return new FieldOfStudyImpl.IDImpl(id);
    }

    @Override
    public FieldOfStudy createEntity() {
        FieldOfStudyModel model = databaseManager.getExternalDatabaseManager().getFieldOfStudyModelManager().createEntity();
        return FieldOfStudyImpl.create(model);
    }

    @Override
    public FieldOfStudy.ID createID(Integer value) {
        return new FieldOfStudyImpl.IDImpl(value);
    }
}
