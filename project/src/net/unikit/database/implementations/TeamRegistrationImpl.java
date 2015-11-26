package net.unikit.database.implementations;

import net.unikit.database.interfaces.entities.Student;
import net.unikit.database.interfaces.entities.Team;
import net.unikit.database.interfaces.entities.TeamRegistration;
import net.unikit.database.internal.interfaces.entities.TeamRegistrationModel;

import java.util.Date;

/**
 * Created by Andreas on 26.11.2015.
 */
final class TeamRegistrationImpl implements TeamRegistration {
    static class IDImpl implements TeamRegistration.ID {
        private Integer value;

        IDImpl(Integer value) {
            this.value = value;
        }

        @Override
        public Integer getValue() {
            return value;
        }
    }

    private TeamRegistrationModel model;

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
    public Student getStudent() {
        return null;
    }

    @Override
    public void setStudent(Student student) {

    }

    @Override
    public Team getTeam() {
        return null;
    }

    @Override
    public void setTeam(Team team) {

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
