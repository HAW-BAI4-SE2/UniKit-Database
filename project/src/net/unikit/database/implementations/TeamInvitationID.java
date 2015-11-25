package net.unikit.database.implementations;

/**
 * An id for a team invitation.
 * @author Andreas Berks
 * @since 1.2.1
 */
public final class TeamInvitationID extends AbstractID<Integer> {
    private TeamInvitationID(Integer value) {
        super(value);
    }

    public static TeamInvitationID create(Integer value) {
        return new TeamInvitationID(value);
    }
}
