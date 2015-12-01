package net.unikit.database.interfaces.managers;

import net.unikit.database.exceptions.EntityNotFoundException;
import net.unikit.database.interfaces.entities.Student;
import net.unikit.database.interfaces.entities.Team;
import net.unikit.database.interfaces.entities.TeamInvitation;

/**
 * A manager for the team invitations.
 * @author Andreas Berks
 * @since 1.2.1
 */
public interface TeamInvitationManager extends AbstractManager<TeamInvitation, Integer, TeamInvitation.ID> {

    /**
     * Finds the invitation by the invited student and the invitng team
     * @param invitedStudent the student who was invited
     * @param invitingTeam the inviting team
     * @return the invitation from the team to the student
     * @throws NullPointerException thrown if invitation couldn't be found ("Invitation")
     */
    TeamInvitation getInvitation(Student invitedStudent, Team invitingTeam) throws EntityNotFoundException;
}
