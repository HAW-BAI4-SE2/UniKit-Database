package net.unikit.database.interfaces.entities;

import java.util.Date;

/**
 * An appointment which is associated to a didactic unit.
 * @author Andreas Berks
 * @since 1.2.1
 */
public interface Appointment<DidacticUnitType extends DidacticUnit> {
    /**
     * An id for an appointment.
     */
    interface ID extends AbstractEntity.ID<Integer> {}

    /**
     * Getter for the identifier of the entity.
     * @return The identifier of the entity
     */
    ID getId();

    /**
     * Getter for the didactic unit that is associated with the appointment.
     * @return The didactic unit that is associated with the appointment
     */
    DidacticUnitType getDidacticUnit();

    /**
     * Setter for the didactic unit that is associated with the appointment.
     * @param didacticUnit The didactic unit that is associated with the appointment
     */
    void setDidacticUnit(DidacticUnitType didacticUnit);

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
