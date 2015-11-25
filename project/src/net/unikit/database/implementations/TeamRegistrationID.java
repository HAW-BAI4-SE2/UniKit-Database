package net.unikit.database.implementations;

/**
 * An id for a team registration.
 * @author Andreas Berks
 * @since 1.2.1
 */
public final class TeamRegistrationID extends AbstractID<Integer> {
    private TeamRegistrationID(Integer value) {
        super(value);
    }

    public static TeamRegistrationID create(Integer value) {
        return new TeamRegistrationID(value);
    }
}
