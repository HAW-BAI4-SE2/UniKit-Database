package net.unikit.database.implementations;

/**
 * An id for an appointment.
 * @author Andreas Berks
 * @since 1.2.1
 */
public abstract class AppointmentID extends AbstractID<Integer> {
    protected AppointmentID(Integer value) {
        super(value);
    }
}
