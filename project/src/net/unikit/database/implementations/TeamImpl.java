package net.unikit.database.implementations;

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
    public Course getCourse() {
        // TODO
        throw new UnsupportedOperationException();
    }

    @Override
    public void setCourse(Course course) {
        // TODO
        throw new UnsupportedOperationException();
    }

    @Override
    public Student getCreatedBy() {
        // TODO
        throw new UnsupportedOperationException();
    }

    @Override
    public void setCreatedBy(Student createdBy) {
        // TODO
        throw new UnsupportedOperationException();
    }

    @Override
    public List<MembershipRequest> getMembershipRequests() {
        List<MembershipRequestModel> membershipRequests = model.getMembershipRequests();
        // TODO
        throw new UnsupportedOperationException();
    }

    @Override
    public List<TeamInvitation> getTeamInvitations() {
        List<TeamInvitationModel> teamInvitations = model.getTeamInvitations();
        // TODO
        throw new UnsupportedOperationException();
    }

    @Override
    public List<TeamRegistration> getTeamRegistrations() {
        List<TeamRegistrationModel> teamRegistrations = model.getTeamRegistrations();
        // TODO
        throw new UnsupportedOperationException();
    }

    @Override
    public Date getCreatedAt() {
        return model.getCreatedAt();
    }

    @Override
    public Date getUpdatedAt() {
        return model.getUpdatedAt();
    }
}
