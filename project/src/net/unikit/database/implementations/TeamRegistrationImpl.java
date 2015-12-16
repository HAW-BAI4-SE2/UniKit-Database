package net.unikit.database.implementations;

import net.unikit.database.exceptions.EntityNotFoundException;
import net.unikit.database.interfaces.entities.Student;
import net.unikit.database.interfaces.entities.Team;
import net.unikit.database.interfaces.entities.TeamRegistration;
import net.unikit.database.internal.interfaces.entities.TeamRegistrationModel;

import java.util.Date;

/**
 * Created by Andreas on 26.11.2015.
 */
final class TeamRegistrationImpl extends AbstractEntityImpl implements TeamRegistration {
    static class IDImpl extends AbstractEntityImpl.IDImpl<Integer> implements TeamRegistration.ID  {
        public IDImpl(Integer value) {
            super(value);
        }
    }

    TeamRegistrationModel model;

    private TeamRegistrationImpl(TeamRegistrationModel model) {
        this.model = model;
    }

    public static TeamRegistration create(TeamRegistrationModel model) {
        return new TeamRegistrationImpl(model);
    }

    @Override
    public ID getId() {
        return new IDImpl(model.getId());
    }

    @Override
    public Student getStudent() throws EntityNotFoundException {
        Student.StudentNumber id = new StudentImpl.StudentNumberImpl(model.getStudentNumber());
        return DatabaseManagerFactory.getDatabaseManager().getStudentManager().getEntity(id);
    }

    @Override
    public void setStudent(Student student) {
        model.setStudentNumber(student.getStudentNumber().getValue());
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
        if (!(o instanceof TeamRegistrationImpl)) return false;

        TeamRegistrationImpl that = (TeamRegistrationImpl) o;

        return !(model != null ? !model.equals(that.model) : that.model != null);

    }

    @Override
    public int hashCode() {
        return model != null ? model.hashCode() : 0;
    }
}
