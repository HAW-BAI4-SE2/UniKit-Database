package net.unikit.database.interfaces.entities;

import net.unikit.database.interfaces.ids.DidacticUnitId;

import java.util.List;

public interface DidacticUnit extends AbstractEntity {
    DidacticUnitId getId();

    Course getCourse();
    void setCourse(Course course);

    List<Appointment> getAppointments();
}
