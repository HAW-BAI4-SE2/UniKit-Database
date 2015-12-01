package net.unikit.database.implementations;

import com.google.common.collect.ImmutableList;
import net.unikit.database.exceptions.EntityNotFoundException;
import net.unikit.database.external.interfaces.entities.CourseModel;
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
        ImmutableList.Builder<Course> builder = ImmutableList.builder();
        for (CourseModel completedCourse : completedCourses) {
            builder.add(CourseImpl.create(completedCourse));
        }
        return builder.build();
    }

    @Override
    public List<CourseRegistration> getCourseRegistrations() throws EntityNotFoundException {
        List<CourseRegistration> allEntities = DatabaseManagerFactory.getDatabaseManager().getCourseRegistrationManager().getAllEntities();
        ImmutableList.Builder<CourseRegistration> builder = ImmutableList.builder();
        for (CourseRegistration courseRegistration : allEntities) {
            if (courseRegistration.getStudent().equals(this))
                builder.add(courseRegistration);
        }
        return builder.build();
    }

    @Override
    public List<MembershipRequest> getMembershipRequests() throws EntityNotFoundException {
        List<MembershipRequest> allEntities = DatabaseManagerFactory.getDatabaseManager().getMembershipRequestManager().getAllEntities();
        ImmutableList.Builder<MembershipRequest> builder = ImmutableList.builder();
        for (MembershipRequest membershipRequest : allEntities) {
            if (membershipRequest.getApplicant().equals(this))
                builder.add(membershipRequest);
        }
        return builder.build();
    }

    @Override
    public List<TeamInvitation> getTeamInvitations() throws EntityNotFoundException {
        List<TeamInvitation> allEntities = DatabaseManagerFactory.getDatabaseManager().getTeamInvitationManager().getAllEntities();
        ImmutableList.Builder<TeamInvitation> builder = ImmutableList.builder();
        for (TeamInvitation teamInvitation : allEntities) {
            if (teamInvitation.getInvitee().equals(this))
                builder.add(teamInvitation);
        }
        return builder.build();
    }

    @Override
    public List<TeamRegistration> getTeamRegistrations() throws EntityNotFoundException {
        List<TeamRegistration> allEntities = DatabaseManagerFactory.getDatabaseManager().getTeamRegistrationManager().getAllEntities();
        ImmutableList.Builder<TeamRegistration> builder = ImmutableList.builder();
        for (TeamRegistration teamRegistration : allEntities) {
            if (teamRegistration.getStudent().equals(this))
                builder.add(teamRegistration);
        }
        return builder.build();
    }
}
