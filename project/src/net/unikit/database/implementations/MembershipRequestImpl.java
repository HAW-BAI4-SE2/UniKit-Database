package net.unikit.database.implementations;

import net.unikit.database.exceptions.EntityNotFoundException;
import net.unikit.database.interfaces.entities.MembershipRequest;
import net.unikit.database.interfaces.entities.Student;
import net.unikit.database.interfaces.entities.Team;
import net.unikit.database.internal.interfaces.entities.MembershipRequestModel;

import java.util.Date;

/**
 * Created by Andreas on 26.11.2015.
 */
final class MembershipRequestImpl implements MembershipRequest {
    static class IDImpl extends AbstractEntityImpl.IDImpl<Integer> implements MembershipRequest.ID  {
        public IDImpl(Integer value) {
            super(value);
        }
    }

    MembershipRequestModel model;

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
    public Student getApplicant() throws EntityNotFoundException {
        Student.StudentNumber id = new StudentImpl.StudentNumberImpl(model.getApplicantStudentNumber());
        return DatabaseManagerFactory.getDatabaseManager().getStudentManager().getEntity(id);
    }

    @Override
    public void setApplicant(Student applicant) {
        model.setApplicantStudentNumber(applicant.getStudentNumber().getValue());
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
        if (!(o instanceof MembershipRequestImpl)) return false;

        MembershipRequestImpl that = (MembershipRequestImpl) o;

        return !(model != null ? !model.equals(that.model) : that.model != null);

    }

    @Override
    public int hashCode() {
        return model != null ? model.hashCode() : 0;
    }
}
