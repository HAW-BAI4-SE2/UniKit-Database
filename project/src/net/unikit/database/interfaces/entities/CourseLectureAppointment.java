package net.unikit.database.interfaces.entities;

import java.util.Date;

/**
 * An appointment which is associated to a course lecture.
 * @author Andreas Berks
 * @since 1.2.1
 */
public interface CourseLectureAppointment extends Appointment<CourseLecture>, AbstractEntity {
	/**
	 * An id for a course lecture appointment.
	 */
	interface ID extends Appointment.ID {}

	/**
	 * Getter for the identifier of the entity.
	 * @return The identifier of the entity
	 */
	ID getId();

	/**
	 * Getter for the course lecture that is associated with the appointment.
	 * @return The course lecture that is associated with the appointment
	 */
	CourseLecture getCourseLecture();

	/**
	 * Setter for the course lecture that is associated with the appointment.
	 * @param courseLecture The course lecture that is associated with the appointment
	 */
	void setCourseLecture(CourseLecture courseLecture);

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
