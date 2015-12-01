package net.unikit.database.implementations;

import com.google.common.collect.ImmutableList;
import net.unikit.database.exceptions.EntityNotFoundException;
import net.unikit.database.interfaces.entities.*;
import net.unikit.database.internal.interfaces.entities.MembershipRequestModel;
import net.unikit.database.internal.interfaces.entities.TeamInvitationModel;
import net.unikit.database.internal.interfaces.entities.TeamModel;
import net.unikit.database.internal.interfaces.entities.TeamRegistrationModel;

import java.util.Date;
import java.util.List;

/**
 * Created by Andreas on 26.11.2015.
 */
final class TeamImpl implements Team {
    static class IDImpl implements Team.ID {
        private Integer value;

        IDImpl(Integer value) {
            this.value = value;
        }

        @Override
        public Integer getValue() {
            return value;
        }
    }

    TeamModel model;

    private TeamImpl(TeamModel model) {
        this.model = model;
    }

    public static Team create(TeamModel model) {
        return new TeamImpl(model);
    }

    @Override
    public ID getId() {
        return new IDImpl(model.getId());
    }

    @Override
    public Course getCourse() throws EntityNotFoundException {
        Course.ID id = new CourseImpl.IDImpl(model.getCourseId());
        return DatabaseManagerFactory.getDatabaseManager().getCourseManager().getEntity(id);
    }

    @Override
    public void setCourse(Course course) {
        model.setCourseId(course.getId().getValue());
    }

    @Override
    public Student getCreatedBy() throws EntityNotFoundException {
        Student.StudentNumber id = new StudentImpl.StudentNumberImpl(model.getCreatedByStudentNumber());
        return DatabaseManagerFactory.getDatabaseManager().getStudentManager().getEntity(id);
    }

    @Override
    public void setCreatedBy(Student createdBy) {
        model.setCreatedByStudentNumber(createdBy.getStudentNumber().getValue());
    }

    @Override
    public List<MembershipRequest> getMembershipRequests() {
        List<MembershipRequestModel> membershipRequests = model.getMembershipRequests();
        ImmutableList.Builder<MembershipRequest> builder = ImmutableList.builder();
        for (MembershipRequestModel membershipRequest : membershipRequests) {
            builder.add(MembershipRequestImpl.create(membershipRequest));
        }
        return builder.build();
    }

    @Override
    public List<TeamInvitation> getTeamInvitations() {
        List<TeamInvitationModel> teamInvitations = model.getTeamInvitations();
        ImmutableList.Builder<TeamInvitation> builder = ImmutableList.builder();
        for (TeamInvitationModel teamInvitation : teamInvitations) {
            builder.add(TeamInvitationImpl.create(teamInvitation));
        }
        return builder.build();
    }

    @Override
    public List<TeamRegistration> getTeamRegistrations() {
        List<TeamRegistrationModel> teamRegistrations = model.getTeamRegistrations();
        ImmutableList.Builder<TeamRegistration> builder = ImmutableList.builder();
        for (TeamRegistrationModel teamRegistration : teamRegistrations) {
            builder.add(TeamRegistrationImpl.create(teamRegistration));
        }
        return builder.build();
    }

    @Override
    public Date getCreatedAt() {
        return model.getCreatedAt();
    }

    @Override
    public Date getUpdatedAt() {
        return model.getUpdatedAt();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TeamImpl)) return false;

        TeamImpl team = (TeamImpl) o;

        return !(model != null ? !model.equals(team.model) : team.model != null);

    }

    @Override
    public int hashCode() {
        return model != null ? model.hashCode() : 0;
    }
}
