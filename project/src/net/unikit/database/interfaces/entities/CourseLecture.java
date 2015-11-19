package net.unikit.database.interfaces.entities;

import net.unikit.database.interfaces.ids.CourseLectureId;

import java.util.List;

public interface CourseLecture extends DidacticUnit {
    CourseLectureId getId();

    Course getCourse();
    void setCourse(Course course);

    List<Appointment> getAppointments();
}
