package net.unikit.database.interfaces.entities;

import net.unikit.database.interfaces.ids.MembershipRequestId;

import java.util.Date;

public interface MembershipRequest {
//	private MembershipRequestId id;
//	private Student applicant;
//	private Team team;
//	private Date createdAt;
//	private Date updatedAt;

	MembershipRequestId getId();

	Student getApplicant();
	void setApplicant(Student applicant);

	Team getTeam();
	void setTeam(Team team);

	Date getCreatedAt();

	Date getUpdatedAt();
}
