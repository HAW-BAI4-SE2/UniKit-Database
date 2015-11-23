package net.unikit.database.interfaces.entities;

import net.unikit.database.interfaces.ids.CourseRegistrationID;

import java.util.Date;

public interface CourseRegistration extends AbstractEntity {
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
