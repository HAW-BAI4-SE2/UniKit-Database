package net.unikit.database.implementations;

import net.unikit.database.interfaces.entities.Course;
import net.unikit.database.interfaces.entities.CourseRegistration;
import net.unikit.database.interfaces.entities.Student;

import java.util.Date;

/**
 * Created by Andreas on 26.11.2015.
 */
final class CourseRegistrationImpl implements CourseRegistration {
    @Override
    public ID getId() {
        return null;
    }

    @Override
    public Student getStudent() {
        return null;
    }

    @Override
    public void setStudent(Student student) {

    }

    @Override
    public Course getCourse() {
        return null;
    }

    @Override
    public void setCourse(Course course) {

    }

    @Override
    public boolean isCurrentlyAssignedToTeam() {
        return false;
    }

    @Override
    public void setCurrentlyAssignedToTeam(boolean currentlyAssignedToTeam) {

    }

    @Override
    public Date getCreatedAt() {
        return null;
    }

    @Override
    public Date getUpdatedAt() {
        return null;
    }
}
