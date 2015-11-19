package net.unikit.database.interfaces;

import net.unikit.database.interfaces.managers.CourseManager;
import net.unikit.database.interfaces.managers.StudentManager;
import net.unikit.database.interfaces.managers.TeamManager;

public interface DatabaseManager {
    StudentManager getStudentManager();
    CourseManager getCourseManager();
    TeamManager getTeamManager();
}
