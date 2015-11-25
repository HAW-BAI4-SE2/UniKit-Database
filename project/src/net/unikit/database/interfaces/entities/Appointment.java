package net.unikit.database.interfaces.entities;

import net.unikit.database.interfaces.ids.AppointmentID;

import java.util.Date;

/**
 * Created by Andreas on 20.11.2015.
 */
public interface Appointment {
    AppointmentID getId();

    DidacticUnit getDidacticUnit();
    void setDidacticUnit(DidacticUnit didacticUnit);

    Date getStartDate();
    void setStartDate(Date startDate);

    Date getEndDate();
    void setEndDate(Date endDate);
}
