package net.unikit.database.interfaces.entities;

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
	 * An id for a team invitation.
	 */
	interface ID extends AbstractEntity.ID<Integer> {}

	/**
	 * Getter for the identifier of the entity.
	 * @return The identifier of the entity
	 */
	ID getId();

	/**
	 * Getter for the invitee.
	 * @return The invitee
	 */
	Student getInvitee();

	/**
	 * Setter for the invitee.
	 * @param invitee The invitee
	 */
	void setInvitee(Student invitee);

	/**
	 * Getter for the team which is associated with the invitation.
	 * @return The team which is associated with the invitation
	 */
	Team getTeam();

	/**
	 * Setter for the team which is associated with the invitation.
	 * @param team The team which is associated with the invitation
	 */
	void setTeam(Team team);

	/**
	 * Getter for the student which created the invitation.
	 * @return The student which created the invitation
	 */
	Student getCreatedBy();

	/**
	 * Setter for the student which created the invitation.
	 * @param createdBy The student which created the invitation
	 */
	void setCreatedBy(Student createdBy);

	/**
	 * Getter for the date in which the entry was written to the database.
	 * @return The date in which the entry was written to the database
	 */
	Date getCreatedAt();

	/**
	 * Getter for the date in which the entry was updated in the database the last time.
	 * @return The date in which the entry was updated in the database the last time
	 */
	Date getUpdatedAt();
}
