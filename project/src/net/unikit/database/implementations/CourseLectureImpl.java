package net.unikit.database.implementations;

import net.unikit.database.external.interfaces.entities.CourseLectureModel;
import net.unikit.database.interfaces.entities.Course;
import net.unikit.database.interfaces.entities.CourseLecture;
import net.unikit.database.interfaces.entities.CourseLectureAppointment;

import java.util.List;

/**
 * Created by Andreas on 26.11.2015.
 */
final class CourseLectureImpl implements CourseLecture {
    static class IDImpl implements CourseLecture.ID {
        private Integer value;

        IDImpl(Integer value) {
            this.value = value;
        }

        @Override
        public Integer getValue() {
            return value;
        }
    }

    private CourseLectureModel model;

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
        return null;
    }

    @Override
    public void setCourse(Course course) {

    }

    @Override
    public List<CourseLectureAppointment> getAppointments() {
        return null;
    }
}
