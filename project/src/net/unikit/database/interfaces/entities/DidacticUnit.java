package net.unikit.database.interfaces.entities;

import net.unikit.database.interfaces.ids.DidacticUnitId;

import java.util.List;

/**
 * Created by Andreas on 20.11.2015.
 */
public interface DidacticUnit {
    DidacticUnitId getId();

    Course getCourse();
    void setCourse(Course course);

    List<Appointment> getAppointments();
}
