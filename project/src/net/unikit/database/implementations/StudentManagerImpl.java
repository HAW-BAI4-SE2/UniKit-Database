package net.unikit.database.implementations;

import com.google.common.collect.ImmutableList;
import net.unikit.database.exceptions.EntityNotFoundException;
import net.unikit.database.exceptions.ModelNotFoundException;
import net.unikit.database.external.interfaces.entities.StudentModel;
import net.unikit.database.interfaces.entities.Student;
import net.unikit.database.interfaces.managers.StudentManager;

import java.util.List;

/**
 * Created by Andreas on 26.11.2015.
 */
final class StudentManagerImpl implements StudentManager {
    private DatabaseManagerImpl databaseManager;

    private StudentManagerImpl(DatabaseManagerImpl databaseManager) {
        this.databaseManager = databaseManager;
    }

    static StudentManager create(DatabaseManagerImpl databaseManager) {
        return new StudentManagerImpl(databaseManager);
    }

    @Override
    public List<Student> getAllEntities() {
        List<StudentModel> allEntities = databaseManager.getExternalDatabaseManager().getStudentModelManager().getAllEntities();
        ImmutableList.Builder<Student> builder = ImmutableList.builder();
        for (StudentModel entity : allEntities) {
            builder.add(StudentImpl.create(entity));
        }
        return builder.build();
    }

    @Override
    public Student getEntity(Student.StudentNumber id) throws EntityNotFoundException {
        try {
            StudentModel entity = databaseManager.getExternalDatabaseManager().getStudentModelManager().getEntity(id.getValue());
            return StudentImpl.create(entity);
        } catch (ModelNotFoundException e) {
            throw new EntityNotFoundException(id);
        }
    }

    @Override
    public void updateEntity(Student entity) throws EntityNotFoundException {
        StudentModel model = ((StudentImpl)(entity)).model;
        try {
            databaseManager.getExternalDatabaseManager().getStudentModelManager().updateEntity(model);
        } catch (ModelNotFoundException e) {
            throw new EntityNotFoundException(entity);
        }
    }

    @Override
    public void deleteEntity(Student entity) throws EntityNotFoundException {
        StudentModel model = ((StudentImpl)(entity)).model;
        try {
            databaseManager.getExternalDatabaseManager().getStudentModelManager().deleteEntity(model);
        } catch (ModelNotFoundException e) {
            throw new EntityNotFoundException(entity);
        }
    }

    @Override
    public Student.StudentNumber addEntity(Student entity) {
        StudentModel model = ((StudentImpl)(entity)).model;
        String id = databaseManager.getExternalDatabaseManager().getStudentModelManager().addEntity(model);
        return new StudentImpl.StudentNumberImpl(id);
    }

    @Override
    public Student createEntity() {
        StudentModel model = databaseManager.getExternalDatabaseManager().getStudentModelManager().createEntity();
        return StudentImpl.create(model);
    }

    @Override
    public Student.StudentNumber createID(String value) {
        return new StudentImpl.StudentNumberImpl(value);
    }
}
