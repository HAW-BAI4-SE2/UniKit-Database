package net.unikit.database.implementations;

import com.google.common.collect.ImmutableList;
import net.unikit.database.external.interfaces.entities.CourseLectureAppointmentModel;
import net.unikit.database.external.interfaces.entities.CourseLectureModel;
import net.unikit.database.interfaces.entities.Course;
import net.unikit.database.interfaces.entities.CourseLecture;
import net.unikit.database.interfaces.entities.CourseLectureAppointment;

import java.util.List;

/**
 * Created by Andreas on 26.11.2015.
 */
final class CourseLectureImpl extends AbstractEntityImpl implements CourseLecture {
    static class IDImpl extends AbstractEntityImpl.IDImpl<Integer> implements CourseLecture.ID  {
        public IDImpl(Integer value) {
            super(value);
        }
    }

    CourseLectureModel model;

    private CourseLectureImpl(CourseLectureModel model) {
        this.model = model;
    }

    public static CourseLecture create(CourseLectureModel model) {
        return new CourseLectureImpl(model);
    }

    @Override
    public ID getId() {
        return new IDImpl(model.getId());
    }

    @Override
    public Course getCourse() {
        return CourseImpl.create(model.getCourse());
    }

    @Override
    public void setCourse(Course course) {
        model.setCourse(((CourseImpl)(course)).model);
    }

    @Override
    public List<CourseLectureAppointment> getAppointments() {
        List<CourseLectureAppointmentModel> appointments = model.getAppointments();
        ImmutableList.Builder<CourseLectureAppointment> builder = ImmutableList.builder();
        for (CourseLectureAppointmentModel appointment : appointments) {
            builder.add(CourseLectureAppointmentImpl.create(appointment));
        }
        return builder.build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CourseLectureImpl)) return false;

        CourseLectureImpl that = (CourseLectureImpl) o;

        return !(model != null ? !model.equals(that.model) : that.model != null);

    }

    @Override
    public int hashCode() {
        return model != null ? model.hashCode() : 0;
    }
}
