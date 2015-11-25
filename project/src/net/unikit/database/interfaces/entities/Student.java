package net.unikit.database.interfaces.entities;

import net.unikit.database.implementations.StudentNumber;

import java.util.List;

/**
 * A student.
 * @author Andreas Berks
 * @since 1.2.1
 */
public interface Student extends AbstractEntity {
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

	String getFirstName();
	void setFirstName(String firstName);

	String getLastName();
	void setLastName(String lastName);

	String getEmail();
	void setEmail(String email);

	FieldOfStudy getFieldOfStudy();
	void setFieldOfStudy(FieldOfStudy fieldOfStudy);

	int getSemester();
	void setSemester(int semester);

	List<Course> getCompletedCourses();

	List<CourseRegistration> getCourseRegistrations();

	List<MembershipRequest> getMembershipRequests();

	List<TeamInvitation> getTeamInvitations();

	List<TeamRegistration> getTeamRegistrations();
}
