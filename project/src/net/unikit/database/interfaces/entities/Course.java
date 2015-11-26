package net.unikit.database.interfaces.entities;

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
	 * An id for an course.
	 */
	interface ID extends AbstractEntity.ID<Integer> {}

	/**
	 * Getter for the identifier of the entity.
	 * @return The identifier of the entity
	 */
	ID getId();

	/**
	 * Getter for the name of the course.
	 * @return The name of the course
	 */
	String getName();

	/**
	 * Setter for the name of the course.
	 * @param name The name of the course
	 */
	void setName(String name);

	/**
	 * Getter for the abbreviation of the course.
	 * @return The abbreviation of the course
	 */
	String getAbbreviation();

	/**
	 * Setter for the abbreviation of the course.
	 * @param abbreviation The abbreviation of the course
	 */
	void setAbbreviation(String abbreviation);

	/**
	 * Getter for the semester the course occurs.
	 * @return The semester the course occurs
	 */
	Integer getSemester();

	/**
	 * Setter for the semester the course occurs.
	 * @param semester The semester the course occurs
	 */
	void setSemester(Integer semester);

	/**
	 * Getter for the minimum size of a team.
	 * @return The minimum size of a team
	 */
	int getMinTeamSize();

	/**
	 * Setter for the minimum size of a team.
	 * @param minTeamSize The minimum size of a team
	 */
	void setMinTeamSize(int minTeamSize);

	/**
	 * Getter for the maximum size of a team.
	 * @return The maximum size of a team
	 */
	int getMaxTeamSize();

	/**
	 * Setter for the maximum size of a team.
	 * @param maxTeamSize The maximum size of a team
	 */
	void setMaxTeamSize(int maxTeamSize);

	/**
	 * Getter for the course lecture of the course.
	 * @return The course lecture of the course
	 */
	CourseLecture getCourseLecture();

	/**
	 * Setter for the course lecture of the course.
	 * @param courseLecture The course lecture of the course
	 */
	void setCourseLecture(CourseLecture courseLecture);

	/**
	 * Getter for the course group of the course.
	 * Returns a immutable list of {@link CourseGroup}.
	 * @return The course group of the course
	 */
	List<CourseGroup> getCourseGroups();

	/**
	 * Getter for the field of studies of the course.
	 * Returns a immutable list of {@link FieldOfStudy}.
	 * @return The field of studies of the course
	 */
	List<FieldOfStudy> getFieldOfStudies();

	/**
	 * Getter for the single registrations of the course.
	 * Returns a immutable list of {@link CourseRegistration}.
	 * @return The single registrations of the course
	 */
	List<CourseRegistration> getSingleRegistrations();

	/**
	 * Getter for all course registrations of the course.
	 * Returns a immutable list of {@link CourseRegistration}.
	 * @return All course registrations of the course
	 */
	List<CourseRegistration> getAllCourseRegistrations();

	/**
	 * Getter for the teams of the course.
	 * Returns a immutable list of {@link Team}.
	 * @return The teams of the course
	 */
	List<Team> getTeams();
}
