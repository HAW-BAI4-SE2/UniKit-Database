package net.unikit.database.interfaces.entities;

import net.unikit.database.interfaces.ids.CourseGroupAppointmentId;

import java.util.Date;

public interface CourseGroupAppointment extends Appointment, AbstractEntity {
	CourseGroupAppointmentId getId();

	CourseGroup getCourseGroup();
	void setCourseGroup(CourseGroup courseGroup);

	Date getStartDate();
	void setStartDate(Date startDate);

	Date getEndDate();
	void setEndDate(Date endDate);
}
