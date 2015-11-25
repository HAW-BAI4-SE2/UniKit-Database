package net.unikit.database.interfaces.entities;

import net.unikit.database.interfaces.ids.TeamInvitationID;

import java.util.Date;

/**
 * A invitation which is associated to a team.
 * Membership requests will be done by students which are in the team.
 * If a student gets invited to a team he is called invitee.
 * @author Andreas Berks
 * @since 1.2.1
 */
public interface TeamInvitation extends AbstractEntity {
	/**
	 * Getter for the identifier of the entity.
	 * @return The identifier of the entity
	 */
	TeamInvitationID getId();

	Student getInvitee();
	void setInvitee(Student invitee);

	Team getTeam();
	void setTeam(Team team);

	Student getCreatedBy();
	void setCreatedBy(Student createdBy);

	Date getCreatedAt();

	Date getUpdatedAt();
}
