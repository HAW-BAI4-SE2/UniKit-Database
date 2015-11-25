package net.unikit.database.interfaces.entities;

import net.unikit.database.interfaces.ids.CourseID;

import java.util.List;

/**
 * A course.
 * A course can have one course lecture and multiple course group.
 * A course can be associated to any number of field of studies.
 * @author Andreas Berks
 * @since 1.2.1
 */
public interface Course extends AbstractEntity {
	/**
	 * Getter for the identifier of the entity.
	 * @return The identifier of the entity
	 */
	CourseID getId();

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

	List<CourseRegistration> getSingleRegistrations();

	List<CourseRegistration> getAllCourseRegistrations();

	List<Team> getTeams();
}
