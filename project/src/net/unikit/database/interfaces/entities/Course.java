package net.unikit.database.interfaces.entities;

import net.unikit.database.interfaces.ids.CourseId;

import java.util.List;

public interface Course {
	CourseId getId();

	String getName();
	void setName(String name);

	String getAbbreviation();
	void setAbbreviation(String abbreviation);

	Integer getSemester();
	void setSemester(Integer semester);

	int getMinTeamSize();
	void setMinTeamSize(int minTeamSize);

	int getMaxTeamSize();
	void setMaxTeamSize(int maxTeamSize);

	CourseLecture getCourseLecture();
	void setCourseLecture(CourseLecture courseLecture);

	List<CourseGroup> getCourseGroups();

	List<FieldOfStudy> getFieldOfStudies();
}
