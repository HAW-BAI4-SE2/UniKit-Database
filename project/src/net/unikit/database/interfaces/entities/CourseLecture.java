package net.unikit.database.interfaces.entities;

import net.unikit.database.interfaces.ids.CourseLectureID;

import java.util.List;

/**
 * A course lecture which is associated to a course.
 * @author Andreas Berks
 * @since 1.2.1
 */
public interface CourseLecture extends DidacticUnit, AbstractEntity {
    CourseLectureID getId();

    Course getCourse();
    void setCourse(Course course);

    List<Appointment> getAppointments();
}
