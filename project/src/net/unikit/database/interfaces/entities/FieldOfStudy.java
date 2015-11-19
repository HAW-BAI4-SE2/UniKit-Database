package net.unikit.database.interfaces.entities;

import net.unikit.database.interfaces.ids.FieldOfStudyId;

public interface FieldOfStudy {
	FieldOfStudyId getId();

	String getName();
	void setName(String name);

	String getAbbreviation();
	void setAbbreviation(String abbreviation);
}
