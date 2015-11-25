package net.unikit.database.interfaces.entities;

import net.unikit.database.interfaces.ids.TeamID;

import java.util.Date;
import java.util.List;

/**
 * A team which is associated to a course.
 * @author Andreas Berks
 * @since 1.2.1
 */
public interface Team extends AbstractEntity {
	TeamID getId();

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
