package net.unikit.database.implementations;

/**
 * An id for a course group appointment.
 * @author Andreas Berks
 * @since 1.2.1
 */
public final class CourseGroupAppointmentID extends AppointmentID {
    private CourseGroupAppointmentID(Integer value) {
        super(value);
    }

    public static CourseGroupAppointmentID create(Integer value) {
        return new CourseGroupAppointmentID(value);
    }
}
