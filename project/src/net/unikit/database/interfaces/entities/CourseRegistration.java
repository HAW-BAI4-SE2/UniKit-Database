package net.unikit.database.interfaces.entities;

import net.unikit.database.interfaces.ids.CourseRegistrationId;

import java.util.Date;

public interface CourseRegistration {
//	private CourseRegistrationId id;
//	private Student student;
//	private Course course;
//	private boolean currentlyAssignedToTeam;
//	private Date createdAt;
//	private Date updatedAt;

	CourseRegistrationId getId();

	Student getStudent();
	void setStudent(Student student);

	Course getCourse();
	void setCourse(Course course);

	boolean isCurrentlyAssignedToTeam();
	void setCurrentlyAssignedToTeam(boolean currentlyAssignedToTeam);

	Date getCreatedAt();

	Date getUpdatedAt();
}
