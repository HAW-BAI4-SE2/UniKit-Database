package net.unikit.database.implementations;

import net.unikit.database.external.implementations.ExternalDatabaseManagerFactory;
import net.unikit.database.external.interfaces.ExternalDatabaseManager;
import net.unikit.database.interfaces.DatabaseConfiguration;
import net.unikit.database.interfaces.DatabaseManager;
import net.unikit.database.interfaces.managers.*;
import net.unikit.database.internal.implementations.InternalDatabaseManagerFactory;
import net.unikit.database.internal.interfaces.InternalDatabaseManager;

import java.io.File;
import java.io.IOException;

import static net.unikit.database.implementations.DatabaseConfigurationUtils.createDatabaseConfigurationFromProperties;

final class DatabaseManagerImpl implements DatabaseManager {
    private ExternalDatabaseManager externalDatabaseManager;
    private InternalDatabaseManager internalDatabaseManager;

    private DatabaseManagerImpl(DatabaseConfiguration internalConfiguration, DatabaseConfiguration externalConfiguration) {
        externalDatabaseManager = ExternalDatabaseManagerFactory.createExternalDatabaseManager(externalConfiguration);
        internalDatabaseManager = InternalDatabaseManagerFactory.createInternalDatabaseManager(internalConfiguration);
    }

    public static DatabaseManager create(DatabaseConfiguration internalConfiguration, DatabaseConfiguration externalConfiguration) {
        return new DatabaseManagerImpl(internalConfiguration, externalConfiguration);
    }

    ExternalDatabaseManager getExternalDatabaseManager() {
        return externalDatabaseManager;
    }

    InternalDatabaseManager getInternalDatabaseManager() {
        return internalDatabaseManager;
    }

    @Override
    public CourseGroupAppointmentManager getCourseGroupAppointmentManager() {
        return CourseGroupAppointmentManagerImpl.create(this);
    }

    @Override
    public CourseGroupManager getCourseGroupManager() {
        return CourseGroupManagerImpl.create(this);
    }

    @Override
    public CourseLectureAppointmentManager getCourseLectureAppointmentManager() {
        return CourseLectureAppointmentManagerImpl.create(this);
    }

    @Override
    public CourseLectureManager getCourseLectureManager() {
        return CourseLectureManagerImpl.create(this);
    }

    @Override
    public CourseManager getCourseManager() {
        return CourseManagerImpl.create(this);
    }

    @Override
    public CourseRegistrationManager getCourseRegistrationManager() {
        return CourseRegistrationManagerImpl.create(this);
    }

    @Override
    public FieldOfStudyManager getFieldOfStudyManager() {
        return FieldOfStudyManagerImpl.create(this);
    }

    @Override
    public MembershipRequestManager getMembershipRequestManager() {
        return MembershipRequestManagerImpl.create(this);
    }

    @Override
    public StudentManager getStudentManager() {
        return StudentManagerImpl.create(this);
    }

    @Override
    public TeamInvitationManager getTeamInvitationManager() {
        return TeamInvitationManagerImpl.create(this);
    }

    @Override
    public TeamManager getTeamManager() {
        return TeamManagerImpl.create(this);
    }

    @Override
    public TeamRegistrationManager getTeamRegistrationManager() {
        return TeamRegistrationManagerImpl.create(this);
    }
}
