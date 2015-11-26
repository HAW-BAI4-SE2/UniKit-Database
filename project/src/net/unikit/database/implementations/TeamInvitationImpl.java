package net.unikit.database.implementations;

import net.unikit.database.interfaces.entities.Student;
import net.unikit.database.interfaces.entities.Team;
import net.unikit.database.interfaces.entities.TeamInvitation;
import net.unikit.database.internal.interfaces.entities.TeamInvitationModel;

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

    private TeamInvitationModel model;

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
        return null;
    }

    @Override
    public void setInvitee(Student invitee) {

    }

    @Override
    public Team getTeam() {
        return null;
    }

    @Override
    public void setTeam(Team team) {

    }

    @Override
    public Student getCreatedBy() {
        return null;
    }

    @Override
    public void setCreatedBy(Student createdBy) {

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
