package net.unikit.database.interfaces.entities;

import net.unikit.database.interfaces.ids.CourseGroupId;

import java.util.List;

public interface CourseGroup extends AbstractEntity {
	CourseGroupId getId();

	Course getCourse();
	void setCourse(Course course);

	int getGroupNumber();
	void setGroupNumber(int groupNumber);

	int getMaxGroupSize();
	void setMaxGroupSize(int maxGroupSize);

	List<CourseGroupAppointment> getAppointments();
}
