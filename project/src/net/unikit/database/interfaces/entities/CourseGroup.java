package net.unikit.database.interfaces.entities;

import net.unikit.database.interfaces.ids.CourseGroupId;

import java.util.List;

public interface CourseGroup {
//	private CourseGroupId id;
//	private Course course;
//	private List<Appointment> appointments;
//	private int groupNumber;
//	private int maxGroupSize;

	CourseGroupId getId();

	Course getCourse();
	void setCourse(Course course);

	List<Appointment> getAppointments();
	void setAppointments(List<Appointment> appointments);

	int getGroupNumber();
	void setGroupNumber(int groupNumber);

	int getMaxGroupSize();
	void setMaxGroupSize(int maxGroupSize);
}
