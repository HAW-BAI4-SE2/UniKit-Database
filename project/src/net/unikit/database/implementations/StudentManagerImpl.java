package net.unikit.database.implementations;

import net.unikit.database.interfaces.entities.Student;
import net.unikit.database.interfaces.managers.StudentManager;

/**
 * Created by Andreas on 26.11.2015.
 */
final class StudentManagerImpl
        extends AbstractManagerImpl<Student, Student.StudentNumber>
        implements StudentManager {
}
