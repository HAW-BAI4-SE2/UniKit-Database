package net.unikit.database.implementations;

import net.unikit.database.exceptions.EntityNotFoundException;
import net.unikit.database.interfaces.entities.Course;
import net.unikit.database.interfaces.entities.CourseRegistration;
import net.unikit.database.interfaces.entities.Student;
import net.unikit.database.internal.interfaces.entities.CourseRegistrationModel;

import java.util.Date;

/**
 * Created by Andreas on 26.11.2015.
 */
final class CourseRegistrationImpl extends AbstractEntityImpl implements CourseRegistration {
    static class IDImpl extends AbstractEntityImpl.IDImpl<Integer> implements CourseRegistration.ID  {
        public IDImpl(Integer value) {
            super(value);
        }
    }

    CourseRegistrationModel model;

    private CourseRegistrationImpl(CourseRegistrationModel model) {
        this.model = model;
    }

    public static CourseRegistration create(CourseRegistrationModel model) {
        return new CourseRegistrationImpl(model);
    }

    @Override
    public ID getId() {
        return new IDImpl(model.getId());
    }

    @Override
    public Student getStudent() throws EntityNotFoundException {
        Student.StudentNumber id = new StudentImpl.StudentNumberImpl(model.getStudentNumber());
        return DatabaseManagerFactory.getDatabaseManager().getStudentManager().getEntity(id);
    }

    @Override
    public void setStudent(Student student) {
        model.setStudentNumber(student.getStudentNumber().getValue());
    }

    @Override
    public Course getCourse() throws EntityNotFoundException {
        Course.ID id = new CourseImpl.IDImpl(model.getCourseId());
        return DatabaseManagerFactory.getDatabaseManager().getCourseManager().getEntity(id);
    }

    @Override
    public void setCourse(Course course) {
        model.setCourseId(course.getId().getValue());
    }

    @Override
    public boolean isCurrentlyAssignedToTeam() {
        return model.isCurrentlyAssignedToTeam();
    }

    @Override
    public void setCurrentlyAssignedToTeam(boolean b) {
        model.setCurrentlyAssignedToTeam(b);
    }

    @Override
    public Date getCreatedAt() {
        return model.getCreatedAt();
    }

    @Override
    public Date getUpdatedAt() {
        return model.getUpdatedAt();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CourseRegistrationImpl)) return false;

        CourseRegistrationImpl that = (CourseRegistrationImpl) o;

        return !(model != null ? !model.equals(that.model) : that.model != null);

    }

    @Override
    public int hashCode() {
        return model != null ? model.hashCode() : 0;
    }
}
