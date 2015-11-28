package net.unikit.database;

import junit.framework.TestCase;
import net.unikit.database.interfaces.entities.Course;
import net.unikit.database.interfaces.managers.CourseManager;
import org.hibernate.exception.ConstraintViolationException;

import java.util.List;

/**
 * Created by Andreas on 28.11.2015.
 */
public class CourseManagerTest extends TestCase {
    public void testGetAllEntities() throws Exception {
        CourseManager courseManager = TestSuite.databaseManager.getCourseManager();
        List<Course> courses = courseManager.getAllEntities();
        assertEquals(courses.size(), 4);

        Course entity = courseManager.getEntity(new CourseImpl.IDImpl(3));
        assertEquals(entity.getName(), "Betriebssysteme");
        /*
        courseManager.deleteEntity(entity);
        assertEquals(courses.size(), 3);
        */
        try {
            //entity = courseManager.getEntity(new CourseImpl.IDImpl(3));
            courseManager.deleteEntity(entity);
        } catch (ConstraintViolationException e) {
            assertTrue(true);
        }

        entity = courseManager.getEntity(courseManager.createID(3));

        Course entity1 = courseManager.createEntity();
        assertEquals(courses.size(), 4);

        entity1.setName("blabla");
        entity1.setAbbreviation("BLA");
        entity1.setCourseLecture(entity.getCourseLecture());
        entity1.setMaxTeamSize(2);
        entity1.setMinTeamSize(2);
        entity1.setSemester(4);

        courseManager.addEntity(entity1);
        assertEquals(courses.size(), 5);
    }
}