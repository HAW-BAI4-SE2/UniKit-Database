package net.unikit.database.interfaces.entities;

import net.unikit.database.interfaces.ids.TeamInvitationId;

import java.util.Date;

public interface TeamInvitation extends AbstractEntity {
	TeamInvitationId getId();

	Student getInvitee();
	void setInvitee(Student invitee);

	Team getTeam();
	void setTeam(Team team);

	Student getCreatedBy();
	void setCreatedBy(Student createdBy);

	Date getCreatedAt();

	Date getUpdatedAt();
}
