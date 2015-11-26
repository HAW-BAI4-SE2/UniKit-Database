package net.unikit.database.interfaces.entities;

/**
 * A field of study.
 * @author Andreas Berks
 * @since 1.2.1
 */
public interface FieldOfStudy extends AbstractEntity {
	/**
	 * An id for a field of study.
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
}
