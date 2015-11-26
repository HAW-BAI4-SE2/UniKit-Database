package net.unikit.database.implementations;

import net.unikit.database.external.interfaces.entities.StudentModel;
import net.unikit.database.interfaces.entities.*;

import java.util.List;

/**
 * Created by Andreas on 26.11.2015.
 */
final class StudentImpl implements Student {
    static class StudentNumberImpl implements Student.StudentNumber {
        private String value;

        StudentNumberImpl(String value) {
            this.value = value;
        }

        @Override
        public String getValue() {
            return value;
        }
    }

    private StudentModel model;

    private StudentImpl(StudentModel model) {
        this.model = model;
    }

    public static Student create(StudentModel model) {
        return new StudentImpl(model);
    }

    @Override
    public StudentNumber getStudentNumber() {
        return new StudentNumberImpl(model.getId());
    }

    @Override
    public void setStudentNumber(StudentNumber studentNumber) {
        model.setStudentNumber(studentNumber.getValue());
    }

    @Override
    public String getFirstName() {
        return null;
    }

    @Override
    public void setFirstName(String firstName) {

    }

    @Override
    public String getLastName() {
        return null;
    }

    @Override
    public void setLastName(String lastName) {

    }

    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public void setEmail(String email) {

    }

    @Override
    public FieldOfStudy getFieldOfStudy() {
        return null;
    }

    @Override
    public void setFieldOfStudy(FieldOfStudy fieldOfStudy) {

    }

    @Override
    public int getSemester() {
        return 0;
    }

    @Override
    public void setSemester(int semester) {

    }

    @Override
    public List<Course> getCompletedCourses() {
        return null;
    }

    @Override
    public List<CourseRegistration> getCourseRegistrations() {
        return null;
    }

    @Override
    public List<MembershipRequest> getMembershipRequests() {
        return null;
    }

    @Override
    public List<TeamInvitation> getTeamInvitations() {
        return null;
    }

    @Override
    public List<TeamRegistration> getTeamRegistrations() {
        return null;
    }
}
