package net.unikit.database.implementations;

import net.unikit.database.external.interfaces.entities.CourseModel;
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

    private CourseModel model;

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
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public String getAbbreviation() {
        return null;
    }

    @Override
    public void setAbbreviation(String abbreviation) {

    }

    @Override
    public Integer getSemester() {
        return null;
    }

    @Override
    public void setSemester(Integer semester) {

    }

    @Override
    public int getMinTeamSize() {
        return 0;
    }

    @Override
    public void setMinTeamSize(int minTeamSize) {

    }

    @Override
    public int getMaxTeamSize() {
        return 0;
    }

    @Override
    public void setMaxTeamSize(int maxTeamSize) {

    }

    @Override
    public CourseLecture getCourseLecture() {
        return null;
    }

    @Override
    public void setCourseLecture(CourseLecture courseLecture) {

    }

    @Override
    public List<CourseGroup> getCourseGroups() {
        return null;
    }

    @Override
    public List<FieldOfStudy> getFieldOfStudies() {
        return null;
    }

    @Override
    public List<CourseRegistration> getSingleRegistrations() {
        return null;
    }

    @Override
    public List<CourseRegistration> getAllCourseRegistrations() {
        return null;
    }

    @Override
    public List<Team> getTeams() {
        return null;
    }
}
