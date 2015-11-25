package net.unikit.database.interfaces.entities;

import net.unikit.database.implementations.AppointmentID;

import java.util.Date;

/**
 * An appointment which is associated to a didactic unit.
 * @author Andreas Berks
 * @since 1.2.1
 */
public interface Appointment {
    /**
     * Getter for the identifier of the entity.
     * @return The identifier of the entity
     */
    AppointmentID getId();

    /**
     * Getter for the didactic unit that is associated with the appointment.
     * @return The didactic unit that is associated with the appointment
     */
    DidacticUnit getDidacticUnit();

    /**
     * Setter for the didactic unit that is associated with the appointment.
     * @param didacticUnit The didactic unit that is associated with the appointment
     */
    void setDidacticUnit(DidacticUnit didacticUnit);

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
