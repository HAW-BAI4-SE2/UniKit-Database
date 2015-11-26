package net.unikit.database.interfaces.entities;

import java.util.Date;

/**
 * An appointment which is associated to a course group.
 * @author Andreas Berks
 * @since 1.2.1
 */
public interface CourseGroupAppointment extends Appointment<CourseGroup>, AbstractEntity {
	/**
	 * An id for a course group appointment.
	 */
	interface ID extends Appointment.ID {}

	/**
	 * Getter for the identifier of the entity.
	 * @return The identifier of the entity
	 */
	ID getId();

	/**
	 * Getter for the course group that is associated with the appointment.
	 * @return The course group that is associated with the appointment
	 */
	CourseGroup getCourseGroup();

	/**
	 * Setter for the course group that is associated with the appointment.
	 * @param courseGroup The course group that is associated with the appointment
	 */
	void setCourseGroup(CourseGroup courseGroup);

	/**
	 * Getter for the start date of the appointment.
	 * @return The start date of the appointment
	 */
	Date getStartDate();

	/**
	 * Setter for the start date of the appointment.
	 * @param startDate The start date of the appointment
	 */
	void setStartDate(Date startDate);

	/**
	 * Getter for the end date of the appointment.
	 * @return The end date of the appointment
	 */
	Date getEndDate();

	/**
	 * Setter for the end date of the appointment.
	 * @param endDate The end date of the appointment
	 */
	void setEndDate(Date endDate);
}
