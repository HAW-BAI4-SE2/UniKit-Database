package net.unikit.database.implementations;

/**
 * An id for a course group.
 * @author Andreas Berks
 * @since 1.2.1
 */
public final class CourseGroupID extends DidacticUnitID {
    private CourseGroupID(Integer value) {
        super(value);
    }

    public static CourseGroupID create(Integer value) {
        return new CourseGroupID(value);
    }
}
