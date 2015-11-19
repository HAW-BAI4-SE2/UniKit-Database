package net.unikit.database.interfaces.entities;

import net.unikit.database.interfaces.ids.TeamId;

import java.util.Date;

public interface Team {
//	private TeamId id;
//	private Course course;
//	private Student createdBy;
//	private Date createdAt;
//	private Date updatedAt;

	TeamId getId();

	Course getCourse();
	void setCourse(Course course);

	Student getCreatedBy();
	void setCreatedBy(Student createdBy);

	Date getCreatedAt();

	Date getUpdatedAt();
}
