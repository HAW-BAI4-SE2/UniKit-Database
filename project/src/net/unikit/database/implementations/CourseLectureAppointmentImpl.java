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

    CourseLectureAppointmentModel model;

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
        return getCourseLecture();
    }

    @Override
    public void setDidacticUnit(CourseLecture didacticUnit) {
        setCourseLecture(didacticUnit);
    }

    @Override
    public CourseLecture getCourseLecture() {
        return CourseLectureImpl.create(model.getCourseLecture());
    }

    @Override
    public void setCourseLecture(CourseLecture courseLecture) {
        model.setCourseLecture(((CourseLectureImpl)(courseLecture)).model);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CourseLectureAppointmentImpl)) return false;

        CourseLectureAppointmentImpl that = (CourseLectureAppointmentImpl) o;

        return !(model != null ? !model.equals(that.model) : that.model != null);

    }

    @Override
    public int hashCode() {
        return model != null ? model.hashCode() : 0;
    }
}
