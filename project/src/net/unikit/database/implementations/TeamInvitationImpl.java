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
        Student.StudentNumber id = new StudentImpl.StudentNumberImpl(model.getInviteeStudentNumber());
        return DatabaseManagerFactory.getDatabaseManager().getStudentManager().getEntity(id);
    }

    @Override
    public void setInvitee(Student invitee) {
        model.setInviteeStudentNumber(invitee.getStudentNumber().getValue());
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
        Student.StudentNumber id = new StudentImpl.StudentNumberImpl(model.getCreatedByStudentNumber());
        return DatabaseManagerFactory.getDatabaseManager().getStudentManager().getEntity(id);
    }

    @Override
    public void setCreatedBy(Student createdBy) {
        model.setCreatedByStudentNumber(createdBy.getStudentNumber().getValue());
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
