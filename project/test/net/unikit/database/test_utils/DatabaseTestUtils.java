package net.unikit.database.test_utils;

import net.unikit.database.TestSuite;
import net.unikit.database.exceptions.EntityNotFoundException;
import net.unikit.database.interfaces.DatabaseManager;
import net.unikit.database.interfaces.entities.*;
import net.unikit.database.interfaces.managers.AbstractManager;
import net.unikit.database.interfaces.managers.MembershipRequestManager;
import net.unikit.database.interfaces.managers.StudentManager;
import net.unikit.database.interfaces.managers.TeamManager;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

public final class DatabaseTestUtils {
    private DatabaseTestUtils() {}

    /**
     * Resets the test database using the <i>all_in_one_test.sql</i> script.
     */
    public static void resetDatabase() {
        DatabaseManager databaseManager = TestSuite.getDatabaseManager();
        String filename = "assets" + File.separator + "all_in_one_test.sql";
        DatabaseResetUtils.resetDatabase(databaseManager, filename);
    }

    /**
     * Getter for the date where the database was reset the last time using resetDatabase().
     * @return The date where the database was reset the last time using resetDatabase()
     */
    public static Date getLastResetDate() {
        return DatabaseResetUtils.getLastResetDate();
    }

    /**
     * Create a range from 'from' (included) to 'to' (included).
     * @param from start value
     * @param to end value
     * @param <T> type of the values
     * @return The range
     */
    public static <T extends Comparable<T>> Range<T> createRange(T from, T to) {
        return RangeImpl.create(from, to);
    }

    public static <E extends AbstractEntity> AbstractManager getEntityManager(Class<E> interfaceClass) {
        Class<CourseGroupAppointment> courseGroupAppointmentClass = CourseGroupAppointment.class;
        if (interfaceClass.equals(courseGroupAppointmentClass))
            return TestSuite.getDatabaseManager().getCourseGroupAppointmentManager();

        Class<CourseGroup> courseGroupClass = CourseGroup.class;
        if (interfaceClass.equals(courseGroupClass))
            return TestSuite.getDatabaseManager().getCourseGroupManager();

        Class<CourseLectureAppointment> courseLectureAppointmentClass = CourseLectureAppointment.class;
        if (interfaceClass.equals(courseLectureAppointmentClass))
            return TestSuite.getDatabaseManager().getCourseLectureAppointmentManager();

        Class<CourseLecture> courseLectureClass = CourseLecture.class;
        if (interfaceClass.equals(courseLectureClass))
            return TestSuite.getDatabaseManager().getCourseLectureManager();

        Class<Course> courseClass = Course.class;
        if (interfaceClass.equals(courseClass))
            return TestSuite.getDatabaseManager().getCourseManager();

        Class<CourseRegistration> courseRegistrationClass = CourseRegistration.class;
        if (interfaceClass.equals(courseRegistrationClass))
            return TestSuite.getDatabaseManager().getCourseRegistrationManager();

        Class<FieldOfStudy> fieldOfStudyClass = FieldOfStudy.class;
        if (interfaceClass.equals(fieldOfStudyClass))
            return TestSuite.getDatabaseManager().getFieldOfStudyManager();

        Class<MembershipRequest> membershipRequestClass = MembershipRequest.class;
        if (interfaceClass.equals(membershipRequestClass))
            return TestSuite.getDatabaseManager().getMembershipRequestManager();

        Class<Student> studentClass = Student.class;
        if (interfaceClass.equals(studentClass))
            return TestSuite.getDatabaseManager().getStudentManager();

        Class<TeamInvitation> teamInvitationClass = TeamInvitation.class;
        if (interfaceClass.equals(teamInvitationClass))
            return TestSuite.getDatabaseManager().getTeamInvitationManager();

        Class<Team> teamClass = Team.class;
        if (interfaceClass.equals(teamClass))
            return TestSuite.getDatabaseManager().getTeamManager();

        Class<TeamRegistration> teamRegistrationClass = TeamRegistration.class;
        if (interfaceClass.equals(teamRegistrationClass))
            return TestSuite.getDatabaseManager().getTeamRegistrationManager();

        throw new IllegalArgumentException("Unknown entity type '" + interfaceClass + "'");
    }

    public static <E extends AbstractEntity, B extends Serializable, I extends AbstractEntity.ID<B>> E getEntity(Class<E> interfaceClass, B baseId) throws EntityNotFoundException {
        AbstractManager entityManager = getEntityManager(interfaceClass);
        I id = (I) entityManager.createID(baseId);
        return (E) entityManager.getEntity(id);
    }

    public static <E extends AbstractEntity> EntityValueMap getEntityValueMap(Class<E> interfaceClass, E entity) {
        EntityValueMap result = EntityValueMapImpl.create();

        PropertyDescriptor[] propertyDescriptors;
        try {
            propertyDescriptors = Introspector.getBeanInfo(interfaceClass).getPropertyDescriptors();
        } catch (IntrospectionException e) {
            throw new RuntimeException(e);
        }

        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            String key = propertyDescriptor.getName();
            Object value;
            try {
                value = propertyDescriptor.getReadMethod().invoke(entity);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }

            result.put(key, value);
        }

        result.makeComplete();
        return result;
    }

    public static <E extends AbstractEntity> EntityValueMap createEntityValueMap(Class<E> interfaceClass) {
        EntityValueMap result = EntityValueMapImpl.create();

        PropertyDescriptor[] propertyDescriptors;
        try {
            propertyDescriptors = Introspector.getBeanInfo(interfaceClass).getPropertyDescriptors();
        } catch (IntrospectionException e) {
            throw new RuntimeException(e);
        }

        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            String key = propertyDescriptor.getName();
            Object value = null;

            result.put(key, value);
        }

        result.makeComplete();
        return result;
    }




    public static Student getStudent(String studentNumber) {
        StudentManager studentManager = TestSuite.getDatabaseManager().getStudentManager();
        try {
            Student student = studentManager.getEntity(studentManager.createID(studentNumber));
            return student;
        } catch (EntityNotFoundException e) {
            throw new IllegalStateException();
        }
    }

    public static Team getTeam(int id) {
        TeamManager teamManager = TestSuite.getDatabaseManager().getTeamManager();
        try {
            Team team = teamManager.getEntity(teamManager.createID(id));
            return team;
        } catch (EntityNotFoundException e) {
            throw new IllegalStateException();
        }
    }

    public static MembershipRequest getMembershipRequest(int id) {
        MembershipRequestManager membershipRequestManager = TestSuite.getDatabaseManager().getMembershipRequestManager();
        try {
            MembershipRequest team = membershipRequestManager.getEntity(membershipRequestManager.createID(id));
            return team;
        } catch (EntityNotFoundException e) {
            throw new IllegalStateException();
        }
    }
}
