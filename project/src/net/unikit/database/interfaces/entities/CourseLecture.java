package net.unikit.database.interfaces.entities;

import net.unikit.database.interfaces.ids.CourseLectureId;

import java.util.List;

public interface CourseLecture extends AbstractEntity {
    CourseLectureId getId();

    Course getCourse();
    void setCourse(Course course);

    List<CourseGroupAppointment> getAppointments();
}
