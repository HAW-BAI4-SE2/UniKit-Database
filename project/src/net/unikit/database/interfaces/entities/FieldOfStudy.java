package net.unikit.database.interfaces.entities;

import net.unikit.database.interfaces.ids.FieldOfStudyId;

import java.util.List;

public interface FieldOfStudy {
	FieldOfStudyId getId();

	String getName();
	void setName(String name);

	String getAbbreviation();
	void setAbbreviation(String abbreviation);
}
