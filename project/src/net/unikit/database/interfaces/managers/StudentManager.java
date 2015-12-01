package net.unikit.database.interfaces.managers;

import net.unikit.database.interfaces.entities.Student;

/**
 * A manager for the students.
 * @author Andreas Berks
 * @since 1.2.1
 */
public interface StudentManager extends AbstractManager<Student, String, Student.StudentNumber> {
    Student getStudent(String studentNumber);
}
