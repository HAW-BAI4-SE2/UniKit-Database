package net.unikit.database.implementations;

import net.unikit.database.external.interfaces.entities.CourseLectureAppointmentModel;
import net.unikit.database.interfaces.entities.CourseLecture;
import net.unikit.database.interfaces.entities.CourseLectureAppointment;

import java.util.Date;

/**
 * Created by Andreas on 26.11.2015.
 */
final class CourseLectureAppointmentImpl implements CourseLectureAppointment {
    static class IDImpl implements CourseLectureAppointment.ID {
        private Integer value;

        IDImpl(Integer value) {
            this.value = value;
        }

        @Override
        public Integer getValue() {
            return value;
        }
    }

    private CourseLectureAppointmentModel model;

    private CourseLectureAppointmentImpl(CourseLectureAppointmentModel model) {
        this.model = model;
    }

    public static CourseLectureAppointment create(CourseLectureAppointmentModel model) {
        return new CourseLectureAppointmentImpl(model);
    }

    @Override
    public ID getId() {
        return new IDImpl(model.getId());
    }

    @Override
    public CourseLecture getDidacticUnit() {
        return null;
    }

    @Override
    public void setDidacticUnit(CourseLecture didacticUnit) {

    }

    @Override
    public CourseLecture getCourseLecture() {
        return null;
    }

    @Override
    public void setCourseLecture(CourseLecture courseLecture) {

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
