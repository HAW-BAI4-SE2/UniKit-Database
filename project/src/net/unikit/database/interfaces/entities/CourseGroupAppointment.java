package net.unikit.database.interfaces.entities;

import net.unikit.database.implementations.CourseGroupAppointmentID;

import java.util.Date;

/**
 * An appointment which is associated to a course group.
 * @author Andreas Berks
 * @since 1.2.1
 */
public interface CourseGroupAppointment extends Appointment, AbstractEntity {
	/**
	 * Getter for the identifier of the entity.
	 * @return The identifier of the entity
	 */
	CourseGroupAppointmentID getId();

	CourseGroup getCourseGroup();
	void setCourseGroup(CourseGroup courseGroup);

	Date getStartDate();
	void setStartDate(Date startDate);

	Date getEndDate();
	void setEndDate(Date endDate);
}
