package net.unikit.database.interfaces.entities;

import net.unikit.database.interfaces.ids.StudentNumber;

import java.util.List;

public interface Student {
//	private StudentNumber studentNumber;
//	private String firstName;
//	private String lastName;
//	private String email;
//	private FieldOfStudy fieldOfStudy;
//	private int semester;
//	private List<Course> completedCourses;

	StudentNumber getStudentNumber();
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
	void setCompletedCourses(List<Course> completedCourses);

	List<Course> getRegisteredCourses();
	void setRegisteredCourses(List<Course> registeredCourses);

	List<Team> getRegisteredTeams();
	void setRegisteredTeams(List<Team> registeredTeams);
}
