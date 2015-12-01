package net.unikit.database;

import junit.framework.TestCase;
import net.unikit.database.interfaces.entities.Course;
import net.unikit.database.interfaces.entities.Student;
import net.unikit.database.interfaces.managers.CourseManager;
import net.unikit.database.interfaces.managers.StudentManager;
import org.hibernate.exception.ConstraintViolationException;

import java.util.List;

/**
 * Created by Andreas on 28.11.2015.
 */
public class CourseManagerTest2 extends TestCase {
    public void testGetAllEntities() throws Exception {
        StudentManager studentManager = TestSuite.databaseManager.getStudentManager();
        Student student = studentManager.getEntity(studentManager.createID("2055120"));

        System.out.println(student.getCourseRegistrations());
    }
}