package net.unikit.database.interfaces.entities;

import net.unikit.database.interfaces.ids.CourseId;

import java.util.List;

public interface Course {
//	private CourseId id;
//	private String name;
//	private String abbreviation;
//	private Integer semester;
//	private int minTeamSize;
//	private int maxTeamSize;
//	private List<CourseGroup> courseGroups;
//	private List<FieldOfStudy> fieldOfStudies;
//	private List<CourseRegistration> courseRegistrations;

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

	List<CourseGroup> getCourseGroups();
	void setCourseGroups(List<CourseGroup> courseGroups);

	List<FieldOfStudy> getFieldOfStudies();
	void setFieldOfStudies(List<FieldOfStudy> fieldOfStudies);

	List<CourseRegistration> getSingleRegistrations();
	void setCourseRegistrations(List<CourseRegistration> courseRegistrations);

	List<Team> getTeams();
	void setTeams(List<Team> teams);
}
