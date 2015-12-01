package net.unikit.database;

import junit.framework.TestCase;
import net.unikit.database.exceptions.ConstraintViolationException;
import net.unikit.database.exceptions.EntityNotFoundException;
import net.unikit.database.interfaces.entities.Course;
import net.unikit.database.interfaces.managers.CourseManager;

import java.util.List;

/**
 * Created by Andreas on 28.11.2015.
 */
public class CourseManagerTest extends TestCase {
    public void testGetAllEntities() {
        CourseManager courseManager = TestSuite.databaseManager.getCourseManager();
        List<Course> courses = courseManager.getAllEntities();

        Course entity = null;
        try {
            entity = courseManager.getEntity(courseManager.createID(2000));
            assertTrue(false);
        } catch (EntityNotFoundException e) {
            // Excepted exception
        }

        try {
            entity = courseManager.getEntity(courseManager.createID(3));
        } catch (EntityNotFoundException e) {
            assertTrue(false);
        }

        String abbreviation = "TESSSTer";
        entity.setAbbreviation(abbreviation);
        assertEquals(entity.getAbbreviation(), abbreviation);

        try {
            courseManager.updateEntity(entity);
        } catch (EntityNotFoundException e) {
            assertTrue(false);
        } catch (ConstraintViolationException e) {
            assertTrue(false);
        }

        entity.setAbbreviation(abbreviation);
        assertEquals(entity.getAbbreviation(), abbreviation);

        System.out.println(entity.getSingleRegistrations().size());
    }
}