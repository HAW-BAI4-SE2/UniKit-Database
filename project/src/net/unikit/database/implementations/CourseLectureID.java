package net.unikit.database.implementations;

/**
 * An id for a course lecture.
 * @author Andreas Berks
 * @since 1.2.1
 */
public final class CourseLectureID extends DidacticUnitID {
    private CourseLectureID(Integer value) {
        super(value);
    }

    public static CourseLectureID create(Integer value) {
        return new CourseLectureID(value);
    }
}
