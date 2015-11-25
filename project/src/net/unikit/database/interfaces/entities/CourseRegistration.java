package net.unikit.database.interfaces.entities;

import net.unikit.database.interfaces.ids.CourseRegistrationID;

import java.util.Date;

/**
 * A course registration which is associated to a course.
 * Course registrations will be done by students and means that the student is enrolled in the course.
 * @author Andreas Berks
 * @since 1.2.1
 */
public interface CourseRegistration extends AbstractEntity {
	/**
	 * Getter for the identifier of the entity.
	 * @return The identifier of the entity
	 */
	CourseRegistrationID getId();

	Student getStudent();
	void setStudent(Student student);

	Course getCourse();
	void setCourse(Course course);

	boolean isCurrentlyAssignedToTeam();
	void setCurrentlyAssignedToTeam(boolean currentlyAssignedToTeam);

	Date getCreatedAt();

	Date getUpdatedAt();
}
