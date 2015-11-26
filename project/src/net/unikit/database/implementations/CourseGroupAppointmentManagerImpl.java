package net.unikit.database.implementations;

import com.google.common.collect.ImmutableList;
import net.unikit.database.external.interfaces.entities.CourseGroupAppointmentModel;
import net.unikit.database.interfaces.entities.CourseGroupAppointment;
import net.unikit.database.interfaces.managers.CourseGroupAppointmentManager;

import java.util.List;

/**
 * Created by Andreas on 26.11.2015.
 */
final class CourseGroupAppointmentManagerImpl implements CourseGroupAppointmentManager {
    @Override
    public List<CourseGroupAppointment> getAllEntities() {
        List<CourseGroupAppointmentModel> allEntities = DatabaseManagerFactory.getExternalDatabaseManager().getCourseGroupAppointmentModelManager().getAllEntities();
        ImmutableList.Builder<CourseGroupAppointment> builder = ImmutableList.builder();
        for (CourseGroupAppointmentModel entity : allEntities) {
            builder.add(CourseGroupAppointmentImpl.create(entity));
        }
        return builder.build();
    }

    @Override
    public CourseGroupAppointment getEntity(CourseGroupAppointment.ID id) {
        CourseGroupAppointmentModel entity = DatabaseManagerFactory.getExternalDatabaseManager().getCourseGroupAppointmentModelManager().getEntity(id.getValue());
        return CourseGroupAppointmentImpl.create(entity);
    }

    @Override
    public void updateEntity(CourseGroupAppointment entity) {
        CourseGroupAppointmentModel model = ((CourseGroupAppointmentImpl)(entity)).model;
        DatabaseManagerFactory.getExternalDatabaseManager().getCourseGroupAppointmentModelManager().updateEntity(model);
    }

    @Override
    public void deleteEntity(CourseGroupAppointment entity) {
        CourseGroupAppointmentModel model = ((CourseGroupAppointmentImpl)(entity)).model;
        DatabaseManagerFactory.getExternalDatabaseManager().getCourseGroupAppointmentModelManager().deleteEntity(model);
    }

    @Override
    public CourseGroupAppointment.ID addEntity(CourseGroupAppointment entity) {
        CourseGroupAppointmentModel model = ((CourseGroupAppointmentImpl)(entity)).model;
        Integer id = DatabaseManagerFactory.getExternalDatabaseManager().getCourseGroupAppointmentModelManager().addEntity(model);
        return new CourseGroupAppointmentImpl.IDImpl(id);
    }

    @Override
    public CourseGroupAppointment createEntity() {
        CourseGroupAppointmentModel model = DatabaseManagerFactory.getExternalDatabaseManager().getCourseGroupAppointmentModelManager().createEntity();
        return CourseGroupAppointmentImpl.create(model);
    }
}
