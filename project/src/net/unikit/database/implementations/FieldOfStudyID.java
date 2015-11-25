package net.unikit.database.implementations;

/**
 * An id for a field of study.
 * @author Andreas Berks
 * @since 1.2.1
 */
public final class FieldOfStudyID extends AbstractID<Integer> {
    private FieldOfStudyID(Integer value) {
        super(value);
    }

    public static FieldOfStudyID create(Integer value) {
        return new FieldOfStudyID(value);
    }
}
