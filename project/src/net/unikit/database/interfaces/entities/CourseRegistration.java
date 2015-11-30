package net.unikit.database.interfaces.entities;

import net.unikit.database.exceptions.EntityNotFoundException;

import java.util.Date;

/**
 * A course registration which is associated to a course.
 * Course registrations will be done by students and means that the student is enrolled in the course.
 * @author Andreas Berks
 * @since 1.2.1
 */
public interface CourseRegistration extends AbstractEntity {
	/**
	 * An id for a course registration.
	 */
	interface ID extends AbstractEntity.ID<Integer> {}

	/**
	 * Getter for the identifier of the entity.
	 * @return The identifier of the entity
	 */
	ID getId();

	/**
	 * Getter for the student which has done the registration.
	 * @return The student which has done the registration
	 */
	Student getStudent() throws EntityNotFoundException;

	/**
	 * Setter for the student which has done the registration.
	 * @param student The student which has done the registration
	 */
	void setStudent(Student student);

	/**
	 * Getter for the course for which the student has done the registration.
	 * @return The course for which the student has done the registration
	 */
	Course getCourse() throws EntityNotFoundException;

	/**
	 * Setter for the course for which the student has done the registration.
	 * @param course The course for which the student has done the registration
	 */
	void setCourse(Course course);

	/**
	 * Getter for the flag which states if the registration is already assigned to a team.
	 * @return The flag which states if the registration is already assigned to a team
	 */
	boolean isCurrentlyAssignedToTeam();

	/**
	 * Setter for the flag which states if the registration is already assigned to a team.
	 * @param currentlyAssignedToTeam The flag which states if the registration is already assigned to a team
	 */
	void setCurrentlyAssignedToTeam(boolean currentlyAssignedToTeam);

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
