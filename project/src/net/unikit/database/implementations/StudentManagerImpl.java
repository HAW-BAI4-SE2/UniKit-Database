package net.unikit.database.implementations;

import com.google.common.collect.ImmutableList;
import net.unikit.database.exceptions.*;
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
        } catch (ModelNotFoundExceptionCommon e) {
            throw new EntityNotFoundException(id);
        }
    }

    @Override
    public void updateEntity(Student entity) throws EntityNotFoundException, ConstraintViolationException {
        StudentModel model = ((StudentImpl)(entity)).model;
        try {
            databaseManager.getExternalDatabaseManager().getStudentModelManager().updateEntity(model);
        } catch (ModelNotFoundExceptionCommon e) {
            throw new EntityNotFoundException(entity);
        } catch (ConstraintViolationExceptionCommon e) {
            throw new ConstraintViolationException(e.getCause(), entity);
        } catch (ModelNotAddedExceptionCommon modelNotAddedExceptionCommon) {
            throw new EntityNotAddedException(entity);
        }
    }

    @Override
    public void deleteEntity(Student entity) throws EntityNotFoundException {
        StudentModel model = ((StudentImpl)(entity)).model;
        try {
            databaseManager.getExternalDatabaseManager().getStudentModelManager().deleteEntity(model);
        } catch (ModelNotFoundExceptionCommon e) {
            throw new EntityNotFoundException(entity);
        } catch (ModelNotAddedExceptionCommon modelNotAddedExceptionCommon) {
            throw new EntityNotAddedException(entity);
        }
    }

    @Override
    public Student.StudentNumber addEntity(Student entity) throws ConstraintViolationException {
        StudentModel model = ((StudentImpl)(entity)).model;
        String id = null;
        try {
            id = databaseManager.getExternalDatabaseManager().getStudentModelManager().addEntity(model);
        } catch (ConstraintViolationExceptionCommon e) {
            throw new ConstraintViolationException(e.getCause(), entity);
        }
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

    @Override
    public Student getStudent(String sNumber) throws EntityNotFoundException {
        Student.StudentNumber studentNumber = createID(sNumber);
        return getEntity(studentNumber);
    }
}
