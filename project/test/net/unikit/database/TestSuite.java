package net.unikit.database;

import net.unikit.database.implementations.DatabaseManagerFactory;
import net.unikit.database.interfaces.DatabaseConfiguration;
import net.unikit.database.interfaces.DatabaseManager;
import net.unikit.database.test_utils.DatabaseTestUtils;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import java.io.File;
import java.io.IOException;

import static net.unikit.database.implementations.DatabaseConfigurationUtils.createDatabaseConfigurationFromProperties;

/**
 * Created by Andreas on 28.11.2015.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        CourseGroupAppointmentTest.class,
        CourseGroupTest.class,
        CourseLectureAppointmentTest.class,
        CourseLectureTest.class,
        CourseRegistrationTest.class,
        CourseTest.class,
        FieldOfStudyTest.class,
        MembershipRequestTest.class,
        StudentTest.class,
        TeamInvitationTest.class,
        TeamRegistrationTest.class,
        TeamTest.class
})
public class TestSuite {
    private static DatabaseManager databaseManager;

    static {
        databaseManager = null;
    }

    /**
     * Getter for the manager of the test database.
     * @return The manager of the test database.
     */
    public static DatabaseManager getDatabaseManager() {
        if (databaseManager == null)
            init();
        return databaseManager;
    }

    /**
     * Creates the internal and external database configurations.
     * Creates a DatabaseManager with these configurations and resets the database using the @link{resetDatabase()} method.
     * @throws Exception
     */
    private static void init() {
        String externalConfigurationFile = "conf" + File.separator + "database_external.properties";
        DatabaseConfiguration configurationExternal = null;
        try {
            configurationExternal = createDatabaseConfigurationFromProperties(externalConfigurationFile);
            configurationExternal.setSchema("external_database_test");
        } catch (IOException e) {
            e.printStackTrace();
        }

        String internalConfigurationFile = "conf" + File.separator + "database_internal.properties";
        DatabaseConfiguration configurationInternal = null;
        try {
            configurationInternal = createDatabaseConfigurationFromProperties(internalConfigurationFile);
            configurationInternal.setSchema("internal_database_test");
        } catch (IOException e) {
            e.printStackTrace();
        }

        databaseManager = DatabaseManagerFactory.createDatabaseManager(configurationInternal, configurationExternal);

        System.err.println("Resetting test database...");
        DatabaseTestUtils.resetDatabase();
    }
}
