package net.unikit.database.interfaces.entities;

import net.unikit.database.implementations.DidacticUnitID;

import java.util.List;

/**
 * A didactic unit which is associated to a course.
 * A didactic unit can be a course lecture or a course group.
 * @author Andreas Berks
 * @since 1.2.1
 */
public interface DidacticUnit {
    /**
     * Getter for the identifier of the entity.
     * @return The identifier of the entity
     */
    DidacticUnitID getId();

    Course getCourse();
    void setCourse(Course course);

    List<Appointment> getAppointments();
}
