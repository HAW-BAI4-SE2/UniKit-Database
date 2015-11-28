package net.unikit.database.implementations;

import com.google.common.collect.ImmutableList;
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
    public CourseLectureAppointment getEntity(CourseLectureAppointment.ID id) {
        CourseLectureAppointmentModel entity = databaseManager.getExternalDatabaseManager().getCourseLectureAppointmentModelManager().getEntity(id.getValue());
        return CourseLectureAppointmentImpl.create(entity);
    }

    @Override
    public void updateEntity(CourseLectureAppointment entity) {
        CourseLectureAppointmentModel model = ((CourseLectureAppointmentImpl)(entity)).model;
        databaseManager.getExternalDatabaseManager().getCourseLectureAppointmentModelManager().updateEntity(model);
    }

    @Override
    public void deleteEntity(CourseLectureAppointment entity) {
        CourseLectureAppointmentModel model = ((CourseLectureAppointmentImpl)(entity)).model;
        databaseManager.getExternalDatabaseManager().getCourseLectureAppointmentModelManager().deleteEntity(model);
    }

    @Override
    public CourseLectureAppointment.ID addEntity(CourseLectureAppointment entity) {
        CourseLectureAppointmentModel model = ((CourseLectureAppointmentImpl)(entity)).model;
        Integer id = databaseManager.getExternalDatabaseManager().getCourseLectureAppointmentModelManager().addEntity(model);
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
