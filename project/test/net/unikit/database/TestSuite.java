package net.unikit.database;

import net.unikit.database.implementations.DatabaseManagerFactory;
import net.unikit.database.interfaces.DatabaseConfiguration;
import net.unikit.database.interfaces.DatabaseManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
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
        EmptyTest1.class,
        EmptyTest2.class
})
public class TestSuite {
    static DatabaseManager databaseManager;

    /**
     * Creates the internal and external database configurations.
     * Creates a DatabaseManager with these configurations and resets the database using the @link{resetDatabase()} method.
     * @throws Exception
     */
    @BeforeClass
    public static void setUp() throws Exception {
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
        resetDatabase();
    }

    /**
     * Cleans up the attributes.
     * @throws Exception
     */
    @AfterClass
    public static void tearDown() throws Exception {
        databaseManager = null;
    }

    /**
     * Resets the test database using the <i>all_in_one_test.sql</i> script.
     */
    public static void resetDatabase() {
        DatabaseManager databaseManager = TestSuite.databaseManager;
        String filename = "assets" + File.separator + "all_in_one_test.sql";
        DatabaseResetUtils.resetDatabase(databaseManager, filename);
    }
}
