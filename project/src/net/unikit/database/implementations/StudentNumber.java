package net.unikit.database.implementations;

/**
 * A student number which identifies a student.
 * @author Andreas Berks
 * @since 1.2.1
 */
public final class StudentNumber extends AbstractID<String> {
    private StudentNumber(String value) {
        super(value);
    }

    public static StudentNumber create(String value) {
        return new StudentNumber(value);
    }
}
