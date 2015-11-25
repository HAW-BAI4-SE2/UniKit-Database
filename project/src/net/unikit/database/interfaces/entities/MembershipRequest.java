package net.unikit.database.interfaces.entities;

import net.unikit.database.interfaces.ids.MembershipRequestID;

import java.util.Date;

public interface MembershipRequest extends AbstractEntity {
	MembershipRequestID getId();

	Student getApplicant();
	void setApplicant(Student applicant);

	Team getTeam();
	void setTeam(Team team);

	Date getCreatedAt();

	Date getUpdatedAt();
}
