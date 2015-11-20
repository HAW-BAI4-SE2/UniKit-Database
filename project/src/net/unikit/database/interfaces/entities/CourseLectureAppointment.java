package net.unikit.database.interfaces.entities;

import net.unikit.database.interfaces.ids.CourseLectureAppointmentId;

import java.util.Date;

public interface CourseLectureAppointment extends Appointment, AbstractEntity {
	CourseLectureAppointmentId getId();

	CourseLecture getCourseLecture();
	void setCourseLecture(CourseLecture courseGroup);

	Date getStartDate();
	void setStartDate(Date startDate);

	Date getEndDate();
	void setEndDate(Date endDate);
}
