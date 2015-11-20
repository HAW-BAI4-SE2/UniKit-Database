package net.unikit.database.implementations;

import net.unikit.database.interfaces.DatabaseConfiguration;
import net.unikit.database.interfaces.DatabaseManager;
import net.unikit.database.interfaces.managers.*;

final class DatabaseManagerImpl implements DatabaseManager {
    private DatabaseManagerImpl(DatabaseConfiguration internalConfiguration, DatabaseConfiguration externalConfiguration) {
        throw new UnsupportedOperationException();
    }

    public static DatabaseManager create(DatabaseConfiguration internalConfiguration, DatabaseConfiguration externalConfiguration) {
        return new DatabaseManagerImpl(internalConfiguration, externalConfiguration);
    }

    @Override
    public CourseGroupAppointmentManager getCourseGroupAppointmentManager() {
        throw new UnsupportedOperationException();
    }

    @Override
    public CourseGroupManager getCourseGroupManager() {
        throw new UnsupportedOperationException();
    }

    @Override
    public CourseLectureAppointmentManager getCourseLectureAppointmentManager() {
        throw new UnsupportedOperationException();
    }

    @Override
    public CourseLectureManager getCourseLectureManager() {
        throw new UnsupportedOperationException();
    }

    @Override
    public CourseManager getCourseManager() {
        throw new UnsupportedOperationException();
    }

    @Override
    public CourseRegistrationManager getCourseRegistrationManager() {
        throw new UnsupportedOperationException();
    }

    @Override
    public FieldOfStudyManager getFieldOfStudyManager() {
        throw new UnsupportedOperationException();
    }

    @Override
    public MembershipRequestManager getMembershipRequestManager() {
        throw new UnsupportedOperationException();
    }

    @Override
    public StudentManager getStudentManager() {
        throw new UnsupportedOperationException();
    }

    @Override
    public TeamInvitationManager getTeamInvitationManager() {
        throw new UnsupportedOperationException();
    }

    @Override
    public TeamManager getTeamManager() {
        throw new UnsupportedOperationException();
    }

    @Override
    public TeamRegistrationManager getTeamRegistrationManager() {
        throw new UnsupportedOperationException();
    }
}
