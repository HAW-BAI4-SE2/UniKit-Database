package net.unikit.database.implementations;

import net.unikit.database.interfaces.entities.MembershipRequest;
import net.unikit.database.interfaces.entities.Student;
import net.unikit.database.interfaces.entities.Team;

import java.util.Date;

/**
 * Created by Andreas on 26.11.2015.
 */
final class MembershipRequestImpl implements MembershipRequest {
    @Override
    public ID getId() {
        return null;
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
