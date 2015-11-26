package net.unikit.database.implementations;

import net.unikit.database.interfaces.entities.*;
import net.unikit.database.internal.interfaces.entities.TeamModel;

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

    private TeamModel model;

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
        return null;
    }

    @Override
    public void setCourse(Course course) {

    }

    @Override
    public Student getCreatedBy() {
        return null;
    }

    @Override
    public void setCreatedBy(Student createdBy) {

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

    @Override
    public Date getCreatedAt() {
        return null;
    }

    @Override
    public Date getUpdatedAt() {
        return null;
    }
}
