package net.unikit.database.implementations;

import net.unikit.database.external.interfaces.entities.CourseModel;
import net.unikit.database.external.interfaces.entities.FieldOfStudyModel;
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

    StudentModel model;

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
        return model.getFirstName();
    }

    @Override
    public void setFirstName(String s) {
        model.setFirstName(s);
    }

    @Override
    public String getLastName() {
        return model.getLastName();
    }

    @Override
    public void setLastName(String s) {
        model.setLastName(s);
    }

    @Override
    public String getEmail() {
        return model.getEmail();
    }

    @Override
    public void setEmail(String s) {
        model.setEmail(s);
    }

    @Override
    public FieldOfStudy getFieldOfStudy() {
        return FieldOfStudyImpl.create(model.getFieldOfStudy());
    }

    @Override
    public void setFieldOfStudy(FieldOfStudy fieldOfStudy) {
        model.setFieldOfStudy(((FieldOfStudyImpl)(fieldOfStudy)).model);
    }

    @Override
    public int getSemester() {
        return model.getSemester();
    }

    @Override
    public void setSemester(int i) {
        model.setSemester(i);
    }

    @Override
    public List<Course> getCompletedCourses() {
        List<CourseModel> completedCourses = model.getCompletedCourses();
        // TODO
        throw new UnsupportedOperationException();
    }

    @Override
    public List<CourseRegistration> getCourseRegistrations() {
        // TODO
        throw new UnsupportedOperationException();
    }

    @Override
    public List<MembershipRequest> getMembershipRequests() {
        // TODO
        throw new UnsupportedOperationException();
    }

    @Override
    public List<TeamInvitation> getTeamInvitations() {
        // TODO
        throw new UnsupportedOperationException();
    }

    @Override
    public List<TeamRegistration> getTeamRegistrations() {
        // TODO
        throw new UnsupportedOperationException();
    }
}
