package net.unikit.database.interfaces.entities;

import net.unikit.database.interfaces.ids.CourseLectureId;

import java.util.List;

public interface CourseLecture {
//	private CourseLectureId id;
//	private Course course;
//	private List<Appointment> appointments;

    CourseLectureId getId();

    Course getCourse();
    void setCourse(Course course);

    List<Appointment> getAppointments();
    void setAppointments(List<Appointment> appointments);
}
