package net.unikit.database;

import junit.framework.TestCase;
import net.unikit.database.interfaces.managers.CourseGroupAppointmentManager;
import org.junit.After;
import org.junit.Test;

/**
 * Created by Andreas on 28.11.2015.
 */
public class AbstractTest extends TestCase {
    @After
    public void tearDown() throws Exception {
        System.err.println("Resetting test database...");
        TestSuite.resetDatabase();
    }

    @Test
    public void test_getAllEntities() {
        CourseGroupAppointmentManager courseGroupAppointmentManager = TestSuite.getDatabaseManager().getCourseGroupAppointmentManager();
    }

    @Test
    public void test_getEntity() {

    }

    @Test
    public void test_updateEntity() {

    }

    @Test
    public void test_deleteEntity() {

    }

    @Test
    public void test_addEntity() {

    }

    @Test
    public void test_createEntity() {

    }

    @Test
    public void test_createID() {

    }
}
