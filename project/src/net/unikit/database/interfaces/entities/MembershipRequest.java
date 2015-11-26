package net.unikit.database.interfaces.entities;

import java.util.Date;

/**
 * A membership request which is associated to a team.
 * Membership requests will be done by students without team.
 * If a student creates a membership request for a team he is called applicant.
 * @author Andreas Berks
 * @since 1.2.1
 */
public interface MembershipRequest extends AbstractEntity {
	/**
	 * An id for a membership request.
	 */
	interface ID extends AbstractEntity.ID<Integer> {}

	/**
	 * Getter for the identifier of the entity.
	 * @return The identifier of the entity
	 */
	ID getId();

	/**
	 * Getter for the applicant.
	 * @return The applicant
	 */
	Student getApplicant();

	/**
	 * Setter for the applicant.
	 * @param applicant The applicant
	 */
	void setApplicant(Student applicant);

	/**
	 * Getter for the team which is associated with the membership request.
	 * @return The team which is associated with the membership request
	 */
	Team getTeam();

	/**
	 * Setter for the team which is associated with the membership request.
	 * @param team The team which is associated with the membership request
	 */
	void setTeam(Team team);

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
