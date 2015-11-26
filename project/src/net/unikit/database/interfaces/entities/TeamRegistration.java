package net.unikit.database.interfaces.entities;

import java.util.Date;

/**
 * A registration which is associated to a team.
 * Team registrations will be done by students and means that the student is member of the team.
 * @author Andreas Berks
 * @since 1.2.1
 */
public interface TeamRegistration extends AbstractEntity {
	/**
	 * An id for a team registration.
	 */
	interface ID extends AbstractEntity.ID<Integer> {}

	/**
	 * Getter for the identifier of the entity.
	 * @return The identifier of the entity
	 */
	ID getId();

	/**
	 * Getter for the student which is member of the team.
	 * @return The student which is member of the team
	 */
	Student getStudent();

	/**
	 * Setter for the the student which is member of the team.
	 * @param student The student which is member of the team
	 */
	void setStudent(Student student);

	/**
	 * Getter for the team which is associated with the registration.
	 * @return The team which is associated with the registration
	 */
	Team getTeam();

	/**
	 * Setter for the team which is associated with the registration.
	 * @param team The team which is associated with the registration
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
