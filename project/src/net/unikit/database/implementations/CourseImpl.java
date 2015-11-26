package net.unikit.database.implementations;

import net.unikit.database.external.interfaces.entities.CourseGroupModel;
import net.unikit.database.external.interfaces.entities.CourseModel;
import net.unikit.database.external.interfaces.entities.FieldOfStudyModel;
import net.unikit.database.interfaces.entities.*;

import java.util.List;

/**
 * Created by Andreas on 26.11.2015.
 */
final class CourseImpl implements Course {
    static class IDImpl implements Course.ID {
        private Integer value;

        IDImpl(Integer value) {
            this.value = value;
        }

        @Override
        public Integer getValue() {
            return value;
        }
    }

    CourseModel model;

    private CourseImpl(CourseModel model) {
        this.model = model;
    }

    public static Course create(CourseModel model) {
        return new CourseImpl(model);
    }

    @Override
    public ID getId() {
        return new IDImpl(model.getId());
    }

    @Override
    public String getName() {
        return model.getName();
    }

    @Override
    public void setName(String s) {
        model.setName(s);
    }

    @Override
    public String getAbbreviation() {
        return model.getAbbreviation();
    }

    @Override
    public void setAbbreviation(String s) {
        model.setAbbreviation(s);
    }

    @Override
    public Integer getSemester() {
        return model.getSemester();
    }

    @Override
    public void setSemester(Integer integer) {
        model.setSemester(integer);
    }

    @Override
    public int getMinTeamSize() {
        return model.getMinTeamSize();
    }

    @Override
    public void setMinTeamSize(int i) {
        model.setMinTeamSize(i);
    }

    @Override
    public int getMaxTeamSize() {
        return model.getMaxTeamSize();
    }

    @Override
    public void setMaxTeamSize(int i) {
        model.setMaxTeamSize(i);
    }

    @Override
    public CourseLecture getCourseLecture() {
        return CourseLectureImpl.create(model.getCourseLecture());
    }

    @Override
    public void setCourseLecture(CourseLecture courseLecture) {
        //model.setCourseLecture(((CourseLectureImpl)(courseLecture)).model);
        // TODO
        throw new UnsupportedOperationException();
    }

    @Override
    public List<CourseGroup> getCourseGroups() {
        List<CourseGroupModel> courseGroups = model.getCourseGroups();
        // TODO
        throw new UnsupportedOperationException();
    }

    @Override
    public List<FieldOfStudy> getFieldOfStudies() {
        List<FieldOfStudyModel> fieldOfStudies = model.getFieldOfStudies();
        // TODO
        throw new UnsupportedOperationException();
    }

    @Override
    public List<CourseRegistration> getSingleRegistrations() {
        // TODO
        throw new UnsupportedOperationException();
    }

    @Override
    public List<CourseRegistration> getAllCourseRegistrations() {
        // TODO
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Team> getTeams() {
        // TODO
        throw new UnsupportedOperationException();
    }
}
