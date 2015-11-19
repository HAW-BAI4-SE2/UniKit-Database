package net.unikit.database.interfaces.entities;

import net.unikit.database.interfaces.ids.AppointmentId;

import java.util.Date;

public interface Appointment {
//	private AppointmentId id;
//	private Date startDate;
//	private Date endDate;

	AppointmentId getId();

	Date getStartDate();
	void setStartDate(Date startDate);

	Date getEndDate();
	void setEndDate(Date endDate);
}
