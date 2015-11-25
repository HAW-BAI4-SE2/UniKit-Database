package net.unikit.database.implementations;

/**
 * An id for a team.
 * @author Andreas Berks
 * @since 1.2.1
 */
public final class TeamID extends AbstractID<Integer> {
    private TeamID(Integer value) {
        super(value);
    }

    public static TeamID create(Integer value) {
        return new TeamID(value);
    }
}
