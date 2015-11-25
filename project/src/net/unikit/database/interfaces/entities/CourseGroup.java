package net.unikit.database.interfaces.entities;

import net.unikit.database.interfaces.ids.CourseGroupID;

import java.util.List;

/**
 * A course group which is associated to a course.
 * @author Andreas Berks
 * @since 1.2.1
 */
public interface CourseGroup extends DidacticUnit, AbstractEntity {
	CourseGroupID getId();

	Course getCourse();
	void setCourse(Course course);

	int getGroupNumber();
	void setGroupNumber(int groupNumber);

	int getMaxGroupSize();
	void setMaxGroupSize(int maxGroupSize);

	List<Appointment> getAppointments();
}
