package net.unikit.database.interfaces.entities;

import net.unikit.database.interfaces.ids.AppointmentID;

import java.util.Date;

/**
 * An appointment which is associated to a didactic unit.
 * @author Andreas Berks
 * @since 1.2.1
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
