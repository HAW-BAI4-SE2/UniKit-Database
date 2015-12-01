package net.unikit.database.interfaces.managers;

import net.unikit.database.interfaces.entities.MembershipRequest;
import net.unikit.database.interfaces.entities.Student;
import net.unikit.database.interfaces.entities.Team;

/**
 * A manager for the membership requests.
 * @author Andreas Berks
 * @since 1.2.1
 */
public interface MembershipRequestManager extends AbstractManager<MembershipRequest, Integer, MembershipRequest.ID> {
    /**
     *
     * @param requestingStudent
     * @param team
     * @return
     */
    MembershipRequest getMembershipRequest(Student requestingStudent, Team team);
}
