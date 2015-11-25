package net.unikit.database.interfaces.entities;

import net.unikit.database.interfaces.ids.CourseLectureAppointmentID;

import java.util.Date;

/**
 * An appointment which is associated to a course lecture.
 * @author Andreas Berks
 * @since 1.2.1
 */
public interface CourseLectureAppointment extends Appointment, AbstractEntity {
	CourseLectureAppointmentID getId();

	CourseLecture getCourseLecture();
	void setCourseLecture(CourseLecture courseGroup);

	Date getStartDate();
	void setStartDate(Date startDate);

	Date getEndDate();
	void setEndDate(Date endDate);
}
