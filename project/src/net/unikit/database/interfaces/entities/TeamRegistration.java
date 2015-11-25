package net.unikit.database.interfaces.entities;

import net.unikit.database.interfaces.ids.TeamRegistrationID;

import java.util.Date;

public interface TeamRegistration extends AbstractEntity {
	TeamRegistrationID getId();

	Student getStudent();
	void setStudent(Student student);

	Team getTeam();
	void setTeam(Team team);

	Date getCreatedAt();

	Date getUpdatedAt();
}
