package net.unikit.database.interfaces.entities;

import net.unikit.database.exceptions.EntityNotFoundException;

import java.util.List;

/**
 * A student.
 * @author Andreas Berks
 * @since 1.2.1
 */
public interface Student extends AbstractEntity {
	/**
	 * A student number which identifies a student.
	 */
	interface StudentNumber extends AbstractEntity.ID<String> {}

	/**
	 * Getter for the student number which identifies the student.
	 * @return The student number which identifies the student
	 */
	StudentNumber getStudentNumber();

	/**
	 * Setter for the student number which identifies the student.
	 * @param studentNumber The student number which identifies the student
	 */
	void setStudentNumber(StudentNumber studentNumber);

	/**
	 * Getter for the first name of the student.
	 * @return The first name of the student
	 */
	String getFirstName();

	/**
	 * Setter for the first name of the student.
	 * @param firstName The first name of the student
	 */
	void setFirstName(String firstName);

	/**
	 * Getter for the last name of the student.
	 * @return The last name of the student
	 */
	String getLastName();

	/**
	 * Setter for the last name of the student.
	 * @param lastName The last name of the student
	 */
	void setLastName(String lastName);

	/**
	 * Getter for the email address of the student.
	 * @return The email address of the student
	 */
	String getEmail();

	/**
	 * Setter for the email address of the student.
	 * @param email The email address of the student
	 */
	void setEmail(String email);

	/**
	 * Getter for the field of study in which the student is enrolled.
	 * @return The field of study in which the student is enrolled
	 */
	FieldOfStudy getFieldOfStudy();

	/**
	 * Setter for the field of study in which the student is enrolled.
	 * @param fieldOfStudy The field of study in which the student is enrolled
	 */
	void setFieldOfStudy(FieldOfStudy fieldOfStudy);

	/**
	 * Getter for the semester in which the student is enrolled.
	 * @return The semester in which the student is enrolled
	 */
	int getSemester();

	/**
	 * Setter for the semester in which the student is enrolled.
	 * @param semester The semester in which the student is enrolled
	 */
	void setSemester(int semester);

	/**
	 * Getter for the completed courses of the student.
	 * Returns a immutable list of {@link Course}.
	 * @return The completed courses of the student
	 */
	List<Course> getCompletedCourses();

	/**
	 * Getter for the course registrations of the student.
	 * Returns a immutable list of {@link CourseRegistration}.
	 * @return The course registrations of the student
	 */
	List<CourseRegistration> getCourseRegistrations() throws EntityNotFoundException;

	/**
	 * Getter for the membership requests of the student.
	 * Returns a immutable list of {@link MembershipRequest}.
	 * @return The membership requests of the student
	 */
	List<MembershipRequest> getMembershipRequests() throws EntityNotFoundException;

	/**
	 * Getter for the team invitations of the student.
	 * Returns a immutable list of {@link TeamInvitation}.
	 * @return The team invitations of the student
	 */
	List<TeamInvitation> getTeamInvitations() throws EntityNotFoundException;

	/**
	 * Getter for the teams of the student.
	 * Returns a immutable list of {@link TeamRegistration}.
	 * @return The teams of the student
	 */
	List<TeamRegistration> getTeamRegistrations() throws EntityNotFoundException;
}
