package net.unikit.database.interfaces.entities;

import net.unikit.database.interfaces.ids.DidacticUnitID;

import java.util.List;

/**
 * A didactic unit which is associated to a course.
 * A didactic unit can be a course lecture or a course group.
 * @author Andreas Berks
 * @since 1.2.1
 */
public interface DidacticUnit {
    DidacticUnitID getId();

    Course getCourse();
    void setCourse(Course course);

    List<Appointment> getAppointments();
}
