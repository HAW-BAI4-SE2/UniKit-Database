package net.unikit.database.implementations;

import com.google.common.collect.ImmutableList;
import net.unikit.database.external.interfaces.entities.CourseLectureModel;
import net.unikit.database.interfaces.entities.CourseLecture;
import net.unikit.database.interfaces.managers.CourseLectureManager;

import java.util.List;

/**
 * Created by Andreas on 26.11.2015.
 */
final class CourseLectureManagerImpl implements CourseLectureManager {
    @Override
    public List<CourseLecture> getAllEntities() {
        List<CourseLectureModel> allEntities = DatabaseManagerFactory.getExternalDatabaseManager().getCourseLectureModelManager().getAllEntities();
        ImmutableList.Builder<CourseLecture> builder = ImmutableList.builder();
        for (CourseLectureModel entity : allEntities) {
            builder.add(CourseLectureImpl.create(entity));
        }
        return builder.build();
    }

    @Override
    public CourseLecture getEntity(CourseLecture.ID id) {
        CourseLectureModel entity = DatabaseManagerFactory.getExternalDatabaseManager().getCourseLectureModelManager().getEntity(id.getValue());
        return CourseLectureImpl.create(entity);
    }

    @Override
    public void updateEntity(CourseLecture entity) {
        CourseLectureModel model = ((CourseLectureImpl)(entity)).model;
        DatabaseManagerFactory.getExternalDatabaseManager().getCourseLectureModelManager().updateEntity(model);
    }

    @Override
    public void deleteEntity(CourseLecture entity) {
        CourseLectureModel model = ((CourseLectureImpl)(entity)).model;
        DatabaseManagerFactory.getExternalDatabaseManager().getCourseLectureModelManager().deleteEntity(model);
    }

    @Override
    public CourseLecture.ID addEntity(CourseLecture entity) {
        CourseLectureModel model = ((CourseLectureImpl)(entity)).model;
        Integer id = DatabaseManagerFactory.getExternalDatabaseManager().getCourseLectureModelManager().addEntity(model);
        return new CourseLectureImpl.IDImpl(id);
    }

    @Override
    public CourseLecture createEntity() {
        CourseLectureModel model = DatabaseManagerFactory.getExternalDatabaseManager().getCourseLectureModelManager().createEntity();
        return CourseLectureImpl.create(model);
    }
}
