package net.unikit.database.implementations;

import net.unikit.database.interfaces.DatabaseConfiguration;
import net.unikit.database.interfaces.DatabaseManager;
import net.unikit.database.interfaces.managers.CourseManager;
import net.unikit.database.interfaces.managers.StudentManager;
import net.unikit.database.interfaces.managers.TeamManager;

final class DatabaseManagerImpl implements DatabaseManager {
    private DatabaseManagerImpl(DatabaseConfiguration internalConfiguration, DatabaseConfiguration externalConfiguration) {
        throw new UnsupportedOperationException();
    }

    public static DatabaseManager create(DatabaseConfiguration internalConfiguration, DatabaseConfiguration externalConfiguration) {
        return new DatabaseManagerImpl(internalConfiguration, externalConfiguration);
    }

    @Override
    public StudentManager getStudentManager() {
        throw new UnsupportedOperationException();
    }

    @Override
    public CourseManager getCourseManager() {
        throw new UnsupportedOperationException();
    }

    @Override
    public TeamManager getTeamManager() {
        throw new UnsupportedOperationException();
    }
}
