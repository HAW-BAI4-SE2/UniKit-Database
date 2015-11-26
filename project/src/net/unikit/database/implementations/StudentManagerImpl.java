package net.unikit.database.implementations;

import com.google.common.collect.ImmutableList;
import net.unikit.database.external.interfaces.entities.StudentModel;
import net.unikit.database.interfaces.entities.Student;
import net.unikit.database.interfaces.managers.StudentManager;

import java.util.List;

/**
 * Created by Andreas on 26.11.2015.
 */
final class StudentManagerImpl implements StudentManager {
    @Override
    public List<Student> getAllEntities() {
        List<StudentModel> allEntities = DatabaseManagerFactory.getExternalDatabaseManager().getStudentModelManager().getAllEntities();
        ImmutableList.Builder<Student> builder = ImmutableList.builder();
        for (StudentModel entity : allEntities) {
            builder.add(StudentImpl.create(entity));
        }
        return builder.build();
    }

    @Override
    public Student getEntity(Student.StudentNumber id) {
        StudentModel entity = DatabaseManagerFactory.getExternalDatabaseManager().getStudentModelManager().getEntity(id.getValue());
        return StudentImpl.create(entity);
    }

    @Override
    public void updateEntity(Student entity) {
        StudentModel model = ((StudentImpl)(entity)).model;
        DatabaseManagerFactory.getExternalDatabaseManager().getStudentModelManager().updateEntity(model);
    }

    @Override
    public void deleteEntity(Student entity) {
        StudentModel model = ((StudentImpl)(entity)).model;
        DatabaseManagerFactory.getExternalDatabaseManager().getStudentModelManager().deleteEntity(model);
    }

    @Override
    public Student.StudentNumber addEntity(Student entity) {
        StudentModel model = ((StudentImpl)(entity)).model;
        String id = DatabaseManagerFactory.getExternalDatabaseManager().getStudentModelManager().addEntity(model);
        return new StudentImpl.StudentNumberImpl(id);
    }

    @Override
    public Student createEntity() {
        return StudentImpl.create(null);
    }
}
