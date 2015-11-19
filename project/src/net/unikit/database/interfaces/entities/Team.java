package net.unikit.database.interfaces.entities;

import net.unikit.database.interfaces.ids.TeamId;

import java.util.Date;
import java.util.List;

public interface Team {
	TeamId getId();

	Course getCourse();
	void setCourse(Course course);

	Student getCreatedBy();
	void setCreatedBy(Student createdBy);

	List<MembershipRequest> getMembershipRequests();

	List<TeamInvitation> getTeamInvitations();

	List<TeamRegistration> getTeamRegistrations();

	Date getCreatedAt();

	Date getUpdatedAt();
}
