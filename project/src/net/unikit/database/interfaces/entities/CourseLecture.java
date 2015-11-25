package net.unikit.database.interfaces.entities;

import net.unikit.database.interfaces.ids.CourseLectureID;

import java.util.List;

public interface CourseLecture extends DidacticUnit, AbstractEntity {
    CourseLectureID getId();

    Course getCourse();
    void setCourse(Course course);

    List<Appointment> getAppointments();
}
