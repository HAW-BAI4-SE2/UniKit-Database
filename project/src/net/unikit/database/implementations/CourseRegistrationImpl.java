package net.unikit.database.implementations;

import net.unikit.database.interfaces.entities.Course;
import net.unikit.database.interfaces.entities.CourseRegistration;
import net.unikit.database.interfaces.entities.Student;
import net.unikit.database.internal.interfaces.entities.CourseRegistrationModel;

import java.util.Date;

/**
 * Created by Andreas on 26.11.2015.
 */
final class CourseRegistrationImpl implements CourseRegistration {
    static class IDImpl implements CourseRegistration.ID {
        private Integer value;

        IDImpl(Integer value) {
            this.value = value;
        }

        @Override
        public Integer getValue() {
            return value;
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
    public Student getStudent() {
        // TODO
        throw new UnsupportedOperationException();
    }

    @Override
    public void setStudent(Student student) {
        // TODO
        throw new UnsupportedOperationException();
    }

    public Course getCourse() {
        // TODO
        throw new UnsupportedOperationException();
    }

    public void setCourse(Course course) {
        // TODO
        throw new UnsupportedOperationException();
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
}
