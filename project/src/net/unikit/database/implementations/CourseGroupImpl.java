package net.unikit.database.implementations;

import net.unikit.database.interfaces.entities.Course;
import net.unikit.database.interfaces.entities.CourseGroup;
import net.unikit.database.interfaces.entities.CourseGroupAppointment;

import java.util.List;

/**
 * Created by Andreas on 26.11.2015.
 */
final class CourseGroupImpl implements CourseGroup {
    @Override
    public ID getId() {
        return null;
    }

    @Override
    public Course getCourse() {
        return null;
    }

    @Override
    public void setCourse(Course course) {

    }

    @Override
    public int getGroupNumber() {
        return 0;
    }

    @Override
    public void setGroupNumber(int groupNumber) {

    }

    @Override
    public int getMaxGroupSize() {
        return 0;
    }

    @Override
    public void setMaxGroupSize(int maxGroupSize) {

    }

    @Override
    public List<CourseGroupAppointment> getAppointments() {
        return null;
    }
}
