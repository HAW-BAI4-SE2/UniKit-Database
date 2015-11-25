package net.unikit.database.interfaces.entities;

import net.unikit.database.interfaces.ids.MembershipRequestID;

import java.util.Date;

/**
 * A membership request which is associated to a team.
 * Membership requests will be done by students without team.
 * If a student creates a membership request for a team he is called applicant.
 * @author Andreas Berks
 * @since 1.2.1
 */
public interface MembershipRequest extends AbstractEntity {
	MembershipRequestID getId();

	Student getApplicant();
	void setApplicant(Student applicant);

	Team getTeam();
	void setTeam(Team team);

	Date getCreatedAt();

	Date getUpdatedAt();
}
