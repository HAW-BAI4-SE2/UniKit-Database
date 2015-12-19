package net.unikit.database.interfaces.entities;

import net.unikit.database.exceptions.EntityNotFoundException;

import java.util.Date;
import java.util.List;

/**
 * A team which is associated to a course.
 * @author Andreas Berks
 * @since 1.2.1
 */
public interface Team extends AbstractEntity {
	/**
	 * An id for a team.
	 */
	interface ID extends AbstractEntity.ID<Integer> {}

	/**
	 * Getter for the identifier of the entity.
	 * @return The identifier of the entity
	 */
	ID getId();

	/**
	 * Getter for the name of the team.
	 * @return The name of the team
	 */
	String getName();

	/**
	 * Setter for the name of the team.
	 * @param name The name of the team
	 */
	void setName(String name);

	/**
	 * Getter for the course which is associated to the team.
	 * @return The course which is associated to the team
	 */
	Course getCourse() throws EntityNotFoundException;

	/**
	 * Setter for the course which is associated to the team.
	 * @param course The course which is associated to the team
	 */
	void setCourse(Course course);

	/**
	 * Getter for the student which created the invitation.
	 * @return The student which created the invitation
	 */
	Student getCreatedBy() throws EntityNotFoundException;

	/**
	 * Setter for the student which created the invitation.
	 * @param createdBy The student which created the invitation
	 */
	void setCreatedBy(Student createdBy);

	/**
	 * Getter for the membership requests for the team.
	 * Returns a immutable list of {@link MembershipRequest}.
	 * @return The membership requests for the team
	 */
	List<MembershipRequest> getMembershipRequests();

	/**
	 * Getter for the invitations of the team.
	 * Returns a immutable list of {@link TeamInvitation}.
	 * @return The invitations of the team
	 */
	List<TeamInvitation> getTeamInvitations();

	/**
	 * Getter for the registrations of the team.
	 * Returns a immutable list of {@link TeamRegistration}.
	 * @return The registrations of the team
	 */
	List<TeamRegistration> getTeamRegistrations();

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
