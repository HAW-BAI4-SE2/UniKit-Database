package net.unikit.database.interfaces.entities;

import java.util.List;

/**
 * A course lecture which is associated to a course.
 * @author Andreas Berks
 * @since 1.2.1
 */
public interface CourseLecture extends DidacticUnit<CourseLecture, CourseLectureAppointment>, AbstractEntity {
    /**
     * An id for an course lecture.
     */
    interface ID extends DidacticUnit.ID {}

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
     * Returns a immutable list of {@link CourseLectureAppointment}.
     * @return The appointments of the course lecture
     */
    List<CourseLectureAppointment> getAppointments();
}
