package net.unikit.database.implementations;

import com.google.common.collect.ImmutableList;
import net.unikit.database.external.interfaces.entities.CourseGroupAppointmentModel;
import net.unikit.database.external.interfaces.entities.CourseGroupModel;
import net.unikit.database.interfaces.entities.Course;
import net.unikit.database.interfaces.entities.CourseGroup;
import net.unikit.database.interfaces.entities.CourseGroupAppointment;

import java.util.List;

/**
 * Created by Andreas on 26.11.2015.
 */
final class CourseGroupImpl extends AbstractEntityImpl implements CourseGroup {
    static class IDImpl extends AbstractEntityImpl.IDImpl<Integer> implements CourseGroup.ID  {
        public IDImpl(Integer value) {
            super(value);
        }
    }

    CourseGroupModel model;

    private CourseGroupImpl(CourseGroupModel model) {
        this.model = model;
    }

    public static CourseGroup create(CourseGroupModel model) {
        return new CourseGroupImpl(model);
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
    public int getGroupNumber() {
        return model.getGroupNumber();
    }

    @Override
    public void setGroupNumber(int groupNumber) {
        model.setGroupNumber(groupNumber);
    }

    @Override
    public int getMaxGroupSize() {
        return model.getMaxGroupSize();
    }

    @Override
    public void setMaxGroupSize(int maxGroupSize) {
        model.setMaxGroupSize(maxGroupSize);
    }

    @Override
    public List<CourseGroupAppointment> getAppointments() {
        List<CourseGroupAppointmentModel> appointments = model.getAppointments();
        ImmutableList.Builder<CourseGroupAppointment> builder = ImmutableList.builder();
        for (CourseGroupAppointmentModel appointment : appointments) {
            builder.add(CourseGroupAppointmentImpl.create(appointment));
        }
        return builder.build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CourseGroupImpl)) return false;

        CourseGroupImpl that = (CourseGroupImpl) o;

        return !(model != null ? !model.equals(that.model) : that.model != null);

    }

    @Override
    public int hashCode() {
        return model != null ? model.hashCode() : 0;
    }
}
