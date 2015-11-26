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

    CourseGroupAppointmentModel model;

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
        return getCourseGroup();
    }

    @Override
    public void setDidacticUnit(CourseGroup didacticUnit) {
        setCourseGroup(didacticUnit);
    }

    @Override
    public CourseGroup getCourseGroup() {
        return CourseGroupImpl.create(model.getCourseGroup());
    }

    @Override
    public void setCourseGroup(CourseGroup courseGroup) {
        model.setCourseGroup(((CourseGroupImpl)(courseGroup)).model);
    }

    @Override
    public Date getStartDate() {
        return model.getStartDate();
    }

    @Override
    public void setStartDate(Date startDate) {
        model.setStartDate(startDate);
    }

    @Override
    public Date getEndDate() {
        return model.getEndDate();
    }

    @Override
    public void setEndDate(Date endDate) {
        model.setEndDate(endDate);
    }
}
