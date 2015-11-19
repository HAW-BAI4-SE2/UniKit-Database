package net.unikit.database.interfaces.entities;

import net.unikit.database.interfaces.ids.StudentNumber;

import java.util.List;

public interface Student {
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
}
