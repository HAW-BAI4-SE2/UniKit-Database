package net.unikit.database.implementations;

import net.unikit.database.external.interfaces.entities.CourseGroupModel;
import net.unikit.database.interfaces.entities.Course;
import net.unikit.database.interfaces.entities.CourseGroup;
import net.unikit.database.interfaces.entities.CourseGroupAppointment;

import java.util.List;

/**
 * Created by Andreas on 26.11.2015.
 */
final class CourseGroupImpl implements CourseGroup {
    static class IDImpl implements CourseGroup.ID {
        private Integer value;

        IDImpl(Integer value) {
            this.value = value;
        }

        @Override
        public Integer getValue() {
            return value;
        }
    }

    private CourseGroupModel model;

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
        return null;
    }

    @Override
    public void setCourse(Course course) {

    }

    @Override
    public int getGroupNumber() {
        return 0;
    }

    @Override
    public void setGroupNumber(int groupNumber) {

    }

    @Override
    public int getMaxGroupSize() {
        return 0;
    }

    @Override
    public void setMaxGroupSize(int maxGroupSize) {

    }

    @Override
    public List<CourseGroupAppointment> getAppointments() {
        return null;
    }
}
