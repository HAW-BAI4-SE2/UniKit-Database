package net.unikit.database.implementations;

import net.unikit.database.interfaces.entities.Student;
import net.unikit.database.interfaces.entities.Team;
import net.unikit.database.interfaces.entities.TeamInvitation;
import net.unikit.database.internal.interfaces.entities.TeamInvitationModel;
import net.unikit.database.internal.interfaces.entities.TeamModel;

import java.util.Date;

/**
 * Created by Andreas on 26.11.2015.
 */
final class TeamInvitationImpl implements TeamInvitation {
    static class IDImpl implements TeamInvitation.ID {
        private Integer value;

        IDImpl(Integer value) {
            this.value = value;
        }

        @Override
        public Integer getValue() {
            return value;
        }
    }

    TeamInvitationModel model;

    private TeamInvitationImpl(TeamInvitationModel model) {
        this.model = model;
    }

    public static TeamInvitation create(TeamInvitationModel model) {
        return new TeamInvitationImpl(model);
    }

    @Override
    public ID getId() {
        return new IDImpl(model.getId());
    }

    @Override
    public Student getInvitee() {
        // TODO
        throw new UnsupportedOperationException();
    }

    @Override
    public void setInvitee(Student invitee) {
        // TODO
        throw new UnsupportedOperationException();
    }

    @Override
    public Team getTeam() {
        return TeamImpl.create(model.getTeam());
    }

    @Override
    public void setTeam(Team team) {
        model.setTeam(((TeamImpl)(team)).model);
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
    public Date getCreatedAt() {
        return model.getCreatedAt();
    }

    @Override
    public Date getUpdatedAt() {
        return model.getUpdatedAt();
    }
}
