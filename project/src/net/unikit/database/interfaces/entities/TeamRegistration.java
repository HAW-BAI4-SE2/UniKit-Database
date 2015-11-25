package net.unikit.database.interfaces.entities;

import net.unikit.database.interfaces.ids.TeamRegistrationID;

import java.util.Date;

/**
 * A registration which is associated to a team.
 * Team registrations will be done by students and means that the student is member of the team.
 * @author Andreas Berks
 * @since 1.2.1
 */
public interface TeamRegistration extends AbstractEntity {
	TeamRegistrationID getId();

	Student getStudent();
	void setStudent(Student student);

	Team getTeam();
	void setTeam(Team team);

	Date getCreatedAt();

	Date getUpdatedAt();
}
