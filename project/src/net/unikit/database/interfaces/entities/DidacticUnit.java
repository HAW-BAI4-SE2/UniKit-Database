package net.unikit.database.interfaces.entities;

import java.util.List;

/**
 * A didactic unit which is associated to a course.
 * A didactic unit can be a course lecture or a course group.
 * @author Andreas Berks
 * @since 1.2.1
 */
public interface DidacticUnit<DidacticUnitType extends DidacticUnit, AppointmentType extends Appointment<DidacticUnitType>> {
    /**
     * An id for an course group.
     */
    interface ID extends AbstractEntity.ID<Integer> {}

    /**
     * Getter for the identifier of the entity.
     * @return The identifier of the entity
     */
    ID getId();

    /**
     * Getter for the course that is associated with the course lecture.
     * @return The course that is associated with the course lecture
     */
    Course getCourse();

    /**
     * Setter for the course that is associated with the course lecture.
     * @param course The course that is associated with the course lecture
     */
    void setCourse(Course course);

    /**
     * Getter for the appointments of the course lecture.
     * Returns a immutable list of {@link Appointment}.
     * @return The appointments of the course lecture
     */
    List<AppointmentType> getAppointments();
}
