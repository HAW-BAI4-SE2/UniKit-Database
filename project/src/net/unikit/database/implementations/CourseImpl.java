package net.unikit.database.implementations;

import net.unikit.database.interfaces.entities.*;

import java.util.List;

/**
 * Created by Andreas on 26.11.2015.
 */
final class CourseImpl implements Course {
    @Override
    public ID getId() {
        return null;
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
