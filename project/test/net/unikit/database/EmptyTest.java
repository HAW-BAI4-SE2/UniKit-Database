package net.unikit.database;

import junit.framework.TestCase;
import net.unikit.database.exceptions.EntityNotFoundException;
import net.unikit.database.interfaces.entities.Student;
import net.unikit.database.interfaces.managers.AbstractManager;
import net.unikit.database.interfaces.managers.CourseManager;
import net.unikit.database.interfaces.managers.StudentManager;
import org.junit.After;
import org.junit.Test;

/**
 * Created by Andreas on 28.11.2015.
 */
public class EmptyTest extends TestCase {
    @After
    public void tearDown() throws Exception {
        assert true;
    }

    @Test
    public void test() {
        AbstractManager manager = TestSuite.getDatabaseManager().getFieldOfStudyManager();
        try {
            manager.getEntity(manager.createID(1));
        } catch (EntityNotFoundException e) {
            fail();
        }
    }
}
