package net.unikit.database.implementations;

import com.google.common.collect.ImmutableList;
import net.unikit.database.exceptions.ConstraintViolationExceptionCommon;
import net.unikit.database.exceptions.ConstraintViolationException;
import net.unikit.database.exceptions.EntityNotFoundException;
import net.unikit.database.exceptions.ModelNotFoundExceptionCommon;
import net.unikit.database.external.interfaces.entities.CourseGroupAppointmentModel;
import net.unikit.database.interfaces.entities.CourseGroupAppointment;
import net.unikit.database.interfaces.managers.CourseGroupAppointmentManager;

import java.util.List;

/**
 * Created by Andreas on 26.11.2015.
 */
final class CourseGroupAppointmentManagerImpl implements CourseGroupAppointmentManager {
    private DatabaseManagerImpl databaseManager;

    private CourseGroupAppointmentManagerImpl(DatabaseManagerImpl databaseManager) {
        this.databaseManager = databaseManager;
    }

    static CourseGroupAppointmentManager create(DatabaseManagerImpl databaseManager) {
        return new CourseGroupAppointmentManagerImpl(databaseManager);
    }

    @Override
    public List<CourseGroupAppointment> getAllEntities() {
        List<CourseGroupAppointmentModel> allEntities = databaseManager.getExternalDatabaseManager().getCourseGroupAppointmentModelManager().getAllEntities();
        ImmutableList.Builder<CourseGroupAppointment> builder = ImmutableList.builder();
        for (CourseGroupAppointmentModel entity : allEntities) {
            builder.add(CourseGroupAppointmentImpl.create(entity));
        }
        return builder.build();
    }

    @Override
    public CourseGroupAppointment getEntity(CourseGroupAppointment.ID id) throws EntityNotFoundException {
        try {
            CourseGroupAppointmentModel entity = databaseManager.getExternalDatabaseManager().getCourseGroupAppointmentModelManager().getEntity(id.getValue());
            return CourseGroupAppointmentImpl.create(entity);
        } catch (ModelNotFoundExceptionCommon e) {
            throw new EntityNotFoundException(id);
        }
    }

    @Override
    public void updateEntity(CourseGroupAppointment entity) throws EntityNotFoundException, ConstraintViolationException {
        CourseGroupAppointmentModel model = ((CourseGroupAppointmentImpl)(entity)).model;
        try {
            databaseManager.getExternalDatabaseManager().getCourseGroupAppointmentModelManager().updateEntity(model);
        } catch (ModelNotFoundExceptionCommon e) {
            throw new EntityNotFoundException(entity);
        } catch (ConstraintViolationExceptionCommon e) {
            throw new ConstraintViolationException(e.getCause(), entity);
        }
    }

    @Override
    public void deleteEntity(CourseGroupAppointment entity) throws EntityNotFoundException {
        CourseGroupAppointmentModel model = ((CourseGroupAppointmentImpl)(entity)).model;
        try {
            databaseManager.getExternalDatabaseManager().getCourseGroupAppointmentModelManager().deleteEntity(model);
        } catch (ModelNotFoundExceptionCommon e) {
            throw new EntityNotFoundException(entity);
        }
    }

    @Override
    public CourseGroupAppointment.ID addEntity(CourseGroupAppointment entity) throws ConstraintViolationException {
        CourseGroupAppointmentModel model = ((CourseGroupAppointmentImpl)(entity)).model;
        Integer id = null;
        try {
            id = databaseManager.getExternalDatabaseManager().getCourseGroupAppointmentModelManager().addEntity(model);
        } catch (ConstraintViolationExceptionCommon e) {
            throw new ConstraintViolationException(e.getCause(), entity);
        }
        return new CourseGroupAppointmentImpl.IDImpl(id);
    }

    @Override
    public CourseGroupAppointment createEntity() {
        CourseGroupAppointmentModel model = databaseManager.getExternalDatabaseManager().getCourseGroupAppointmentModelManager().createEntity();
        return CourseGroupAppointmentImpl.create(model);
    }

    @Override
    public CourseGroupAppointment.ID createID(Integer value) {
        return new CourseGroupAppointmentImpl.IDImpl(value);
    }
}
