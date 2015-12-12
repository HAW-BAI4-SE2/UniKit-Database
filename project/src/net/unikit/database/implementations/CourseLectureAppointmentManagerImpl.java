package net.unikit.database.implementations;

import com.google.common.collect.ImmutableList;
import net.unikit.database.exceptions.*;
import net.unikit.database.external.interfaces.entities.CourseLectureAppointmentModel;
import net.unikit.database.interfaces.entities.CourseLectureAppointment;
import net.unikit.database.interfaces.managers.CourseLectureAppointmentManager;

import java.util.List;

/**
 * Created by Andreas on 26.11.2015.
 */
final class CourseLectureAppointmentManagerImpl implements CourseLectureAppointmentManager {
    private DatabaseManagerImpl databaseManager;

    private CourseLectureAppointmentManagerImpl(DatabaseManagerImpl databaseManager) {
        this.databaseManager = databaseManager;
    }

    static CourseLectureAppointmentManager create(DatabaseManagerImpl databaseManager) {
        return new CourseLectureAppointmentManagerImpl(databaseManager);
    }

    @Override
    public List<CourseLectureAppointment> getAllEntities() {
        List<CourseLectureAppointmentModel> allEntities = databaseManager.getExternalDatabaseManager().getCourseLectureAppointmentModelManager().getAllEntities();
        ImmutableList.Builder<CourseLectureAppointment> builder = ImmutableList.builder();
        for (CourseLectureAppointmentModel entity : allEntities) {
            builder.add(CourseLectureAppointmentImpl.create(entity));
        }
        return builder.build();
    }

    @Override
    public CourseLectureAppointment getEntity(CourseLectureAppointment.ID id) throws EntityNotFoundException {
        try {
            CourseLectureAppointmentModel entity = databaseManager.getExternalDatabaseManager().getCourseLectureAppointmentModelManager().getEntity(id.getValue());
            return CourseLectureAppointmentImpl.create(entity);
        } catch (ModelNotFoundExceptionCommon e) {
            throw new EntityNotFoundException(id);
        }
    }

    @Override
    public void updateEntity(CourseLectureAppointment entity) throws EntityNotFoundException, ConstraintViolationException {
        CourseLectureAppointmentModel model = ((CourseLectureAppointmentImpl)(entity)).model;
        try {
            databaseManager.getExternalDatabaseManager().getCourseLectureAppointmentModelManager().updateEntity(model);
        } catch (ModelNotFoundExceptionCommon e) {
            throw new EntityNotFoundException(entity);
        } catch (ConstraintViolationExceptionCommon e) {
            throw new ConstraintViolationException(e.getCause(), entity);
        } catch (ModelNotAddedExceptionCommon modelNotAddedExceptionCommon) {
            throw new EntityNotAddedException(entity);
        }
    }

    @Override
    public void deleteEntity(CourseLectureAppointment entity) throws EntityNotFoundException {
        CourseLectureAppointmentModel model = ((CourseLectureAppointmentImpl)(entity)).model;
        try {
            databaseManager.getExternalDatabaseManager().getCourseLectureAppointmentModelManager().deleteEntity(model);
        } catch (ModelNotFoundExceptionCommon e) {
            throw new EntityNotFoundException(entity);
        } catch (ModelNotAddedExceptionCommon modelNotAddedExceptionCommon) {
            throw new EntityNotAddedException(entity);
        }
    }

    @Override
    public CourseLectureAppointment.ID addEntity(CourseLectureAppointment entity) throws ConstraintViolationException {
        CourseLectureAppointmentModel model = ((CourseLectureAppointmentImpl)(entity)).model;
        Integer id = null;
        try {
            id = databaseManager.getExternalDatabaseManager().getCourseLectureAppointmentModelManager().addEntity(model);
        } catch (ConstraintViolationExceptionCommon e) {
            throw new ConstraintViolationException(e.getCause(), entity);
        }
        return new CourseLectureAppointmentImpl.IDImpl(id);
    }

    @Override
    public CourseLectureAppointment createEntity() {
        CourseLectureAppointmentModel model = databaseManager.getExternalDatabaseManager().getCourseLectureAppointmentModelManager().createEntity();
        return CourseLectureAppointmentImpl.create(model);
    }

    @Override
    public CourseLectureAppointment.ID createID(Integer value) {
        return new CourseLectureAppointmentImpl.IDImpl(value);
    }
}
