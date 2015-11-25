package net.unikit.database.interfaces.entities;

import net.unikit.database.interfaces.ids.FieldOfStudyID;

/**
 * A field of study.
 * @author Andreas Berks
 * @since 1.2.1
 */
public interface FieldOfStudy extends AbstractEntity {
	FieldOfStudyID getId();

	String getName();
	void setName(String name);

	String getAbbreviation();
	void setAbbreviation(String abbreviation);
}
