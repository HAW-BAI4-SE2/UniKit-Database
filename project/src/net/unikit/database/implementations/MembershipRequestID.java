package net.unikit.database.implementations;

/**
 * An id for a membership request.
 * @author Andreas Berks
 * @since 1.2.1
 */
public final class MembershipRequestID extends AbstractID<Integer> {
    private MembershipRequestID(Integer value) {
        super(value);
    }

    public static MembershipRequestID create(Integer value) {
        return new MembershipRequestID(value);
    }
}
