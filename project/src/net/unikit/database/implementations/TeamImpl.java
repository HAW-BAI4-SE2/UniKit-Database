package net.unikit.database.implementations;

import net.unikit.database.interfaces.entities.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Andreas on 26.11.2015.
 */
final class TeamImpl implements Team {
    @Override
    public ID getId() {
        return null;
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
