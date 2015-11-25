package net.unikit.database.implementations;

/**
 * An id for a course registration.
 * @author Andreas Berks
 * @since 1.2.1
 */
public final class CourseRegistrationID extends AbstractID<Integer> {
    private CourseRegistrationID(Integer value) {
        super(value);
    }

    public static CourseRegistrationID create(Integer value) {
        return new CourseRegistrationID(value);
    }
}
