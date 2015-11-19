package net.unikit.database.interfaces.entities;

import net.unikit.database.interfaces.ids.TeamRegistrationId;

import java.util.Date;

public interface TeamRegistration extends AbstractEntity {
	TeamRegistrationId getId();

	Student getStudent();
	void setStudent(Student student);

	Team getTeam();
	void setTeam(Team team);

	Date getCreatedAt();

	Date getUpdatedAt();
}
