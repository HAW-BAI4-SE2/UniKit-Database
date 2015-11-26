package net.unikit.database.implementations;

import net.unikit.database.interfaces.entities.Course;
import net.unikit.database.interfaces.entities.CourseLecture;
import net.unikit.database.interfaces.entities.CourseLectureAppointment;

import java.util.List;

/**
 * Created by Andreas on 26.11.2015.
 */
final class CourseLectureImpl implements CourseLecture {
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
    public List<CourseLectureAppointment> getAppointments() {
        return null;
    }
}
