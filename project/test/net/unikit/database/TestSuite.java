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
        CourseManagerTest.class,
        CourseManagerTest2.class
})
public class TestSuite {
    static DatabaseManager databaseManager;

    @BeforeClass
    public static void setUp() throws Exception {
        String externalConfigurationFile = "conf" + File.separator + "database_external.properties";
        DatabaseConfiguration configurationExternal = null;
        try {
            configurationExternal = createDatabaseConfigurationFromProperties(externalConfigurationFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String internalConfigurationFile = "conf" + File.separator + "database_internal.properties";
        DatabaseConfiguration configurationInternal = null;
        try {
            configurationInternal = createDatabaseConfigurationFromProperties(internalConfigurationFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        databaseManager = DatabaseManagerFactory.createDatabaseManager(configurationInternal, configurationExternal);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        databaseManager = null;
    }
}
