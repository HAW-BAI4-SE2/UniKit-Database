package net.unikit.database.implementations;

import net.unikit.database.interfaces.entities.MembershipRequest;
import net.unikit.database.interfaces.entities.Student;
import net.unikit.database.interfaces.entities.Team;
import net.unikit.database.internal.interfaces.entities.MembershipRequestModel;

import java.util.Date;

/**
 * Created by Andreas on 26.11.2015.
 */
final class MembershipRequestImpl implements MembershipRequest {
    static class IDImpl implements MembershipRequest.ID {
        private Integer value;

        IDImpl(Integer value) {
            this.value = value;
        }

        @Override
        public Integer getValue() {
            return value;
        }
    }

    private MembershipRequestModel model;

    private MembershipRequestImpl(MembershipRequestModel model) {
        this.model = model;
    }

    public static MembershipRequest create(MembershipRequestModel model) {
        return new MembershipRequestImpl(model);
    }

    @Override
    public ID getId() {
        return new IDImpl(model.getId());
    }

    @Override
    public Student getApplicant() {
        return null;
    }

    @Override
    public void setApplicant(Student applicant) {

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
