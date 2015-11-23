package net.unikit.database.interfaces.entities;

import net.unikit.database.interfaces.ids.TeamInvitationID;

import java.util.Date;

public interface TeamInvitation extends AbstractEntity {
	TeamInvitationID getId();

	Student getInvitee();
	void setInvitee(Student invitee);

	Team getTeam();
	void setTeam(Team team);

	Student getCreatedBy();
	void setCreatedBy(Student createdBy);

	Date getCreatedAt();

	Date getUpdatedAt();
}
