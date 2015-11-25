package net.unikit.database.implementations;

/**
 * An id for a course lecture appointment.
 * @author Andreas Berks
 * @since 1.2.1
 */
public final class CourseLectureAppointmentID extends AppointmentID {
    private CourseLectureAppointmentID(Integer value) {
        super(value);
    }

    public static CourseLectureAppointmentID create(Integer value) {
        return new CourseLectureAppointmentID(value);
    }
}
