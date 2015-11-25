package net.unikit.database.implementations;

/**
 * An id for a course.
 * @author Andreas Berks
 * @since 1.2.1
 */
public final class CourseID extends AbstractID<Integer> {
    private CourseID(Integer value) {
        super(value);
    }

    public static CourseID create(Integer value) {
        return new CourseID(value);
    }
}
