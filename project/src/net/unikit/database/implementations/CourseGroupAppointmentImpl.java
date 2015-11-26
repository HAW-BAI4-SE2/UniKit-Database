package net.unikit.database.implementations;

import net.unikit.database.external.interfaces.entities.CourseGroupAppointmentModel;
import net.unikit.database.interfaces.entities.CourseGroup;
import net.unikit.database.interfaces.entities.CourseGroupAppointment;

import java.util.Date;

/**
 * Created by Andreas on 26.11.2015.
 */
final class CourseGroupAppointmentImpl implements CourseGroupAppointment {
    static class IDImpl implements CourseGroupAppointment.ID {
        private Integer value;

        IDImpl(Integer value) {
            this.value = value;
        }

        @Override
        public Integer getValue() {
            return value;
        }
    }

    private CourseGroupAppointmentModel model;

    private CourseGroupAppointmentImpl(CourseGroupAppointmentModel model) {
        this.model = model;
    }

    public static CourseGroupAppointment create(CourseGroupAppointmentModel model) {
        return new CourseGroupAppointmentImpl(model);
    }

    @Override
    public ID getId() {
        return new IDImpl(model.getId());
    }

    @Override
    public CourseGroup getDidacticUnit() {
        return null;
    }

    @Override
    public void setDidacticUnit(CourseGroup didacticUnit) {

    }

    @Override
    public CourseGroup getCourseGroup() {
        return null;
    }

    @Override
    public void setCourseGroup(CourseGroup courseGroup) {

    }

    @Override
    public Date getStartDate() {
        return null;
    }

    @Override
    public void setStartDate(Date startDate) {

    }

    @Override
    public Date getEndDate() {
        return null;
    }

    @Override
    public void setEndDate(Date endDate) {

    }
}
