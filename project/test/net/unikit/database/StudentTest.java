package net.unikit.database;

import net.unikit.database.exceptions.EntityNotFoundException;
import net.unikit.database.interfaces.entities.*;
import net.unikit.database.interfaces.managers.StudentManager;
import net.unikit.database.test_utils.DatabaseTestUtils;
import net.unikit.database.test_utils.EntityValueMap;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Unit tests for Student and StudentManager.
 */
public class StudentTest extends AbstractTest<Student, String, Student.StudentNumber, StudentManager> {
    private static final int DEFAULT_ENTITY_COUNT = 20;

    private StudentManager manager;
    private EntityValueMap evm_2055120;
    private EntityValueMap evm_2055121;

    /**
     * Getter for the class object of the entity interface.
     * Used for internal implementations of the abstract class AbstractTest.
     * @return The class object of the entity interface
     */
    @Override
    protected Class<Student> getInterfaceClass() {
        return Student.class;
    }

    /**
     * Initialize all Student specific attributes
     * @throws Exception if any error occurs
     */
    @Override
    protected void init() throws Exception {
        manager = getEntityManager();

        // Create entity value map for the first entity
        evm_2055120 = createEntityValueMap();
        evm_2055120.put("studentNumber", manager.createID("2055120"));
        evm_2055120.put("firstName", "Ralf");
        evm_2055120.put("lastName", "Stoeckmann");
        evm_2055120.put("email", "ralf.stoeckmann@haw-hamburg.de");
        evm_2055120.put("fieldOfStudy", DatabaseTestUtils.getEntity(FieldOfStudy.class, 1));
        evm_2055120.put("semester", 2);
        evm_2055120.put("completedCourses", Arrays.asList(
        ));
        evm_2055120.put("courseRegistrations", Arrays.asList(
                DatabaseTestUtils.getEntity(CourseRegistration.class, 1),
                DatabaseTestUtils.getEntity(CourseRegistration.class, 2)
        ));
        evm_2055120.put("membershipRequests", Arrays.asList(
                DatabaseTestUtils.getEntity(MembershipRequest.class, 1)
        ));
        evm_2055120.put("teamInvitations", Arrays.asList(
        ));
        evm_2055120.put("teamRegistrations", Arrays.asList(
                DatabaseTestUtils.getEntity(TeamRegistration.class, 1),
                DatabaseTestUtils.getEntity(TeamRegistration.class, 2)
        ));
        evm_2055120.makeImmutable();

        // Create entity value map for the second entity
        evm_2055121 = createEntityValueMap();
        evm_2055121.put("studentNumber", manager.createID("2055121"));
        evm_2055121.put("firstName", "Gordon");
        evm_2055121.put("lastName", "Dohrmann");
        evm_2055121.put("email", "gordon.dohrmann@haw-hamburg.de");
        evm_2055121.put("fieldOfStudy", DatabaseTestUtils.getEntity(FieldOfStudy.class, 1));
        evm_2055121.put("semester", 2);
        evm_2055121.put("completedCourses", Arrays.asList(
        ));
        evm_2055121.put("courseRegistrations", Arrays.asList(
                DatabaseTestUtils.getEntity(CourseRegistration.class, 3),
                DatabaseTestUtils.getEntity(CourseRegistration.class, 4)
        ));
        evm_2055121.put("membershipRequests", Arrays.asList(
        ));
        evm_2055121.put("teamInvitations", Arrays.asList(
                DatabaseTestUtils.getEntity(TeamInvitation.class, 1)
        ));
        evm_2055121.put("teamRegistrations", Arrays.asList(
                DatabaseTestUtils.getEntity(TeamRegistration.class, 3),
                DatabaseTestUtils.getEntity(TeamRegistration.class, 4)
        ));
        evm_2055121.makeImmutable();
    }

    /**
     * Tests the method getAllEntities of the StudentManager.
     * Following aspects are tested:
     * - Check if count of the entities is right (must be equal to DEFAULT_ENTITY_COUNT)
     * - Check if the entities got right values (only the first two entities are tested)
     * - Check if all entities are equal to the result of the appropriate method call of manager.getEntity(id)
     */
    @Test
    public void test_getAllEntities() throws EntityNotFoundException {
        // Check if count of the entities is right
        List<Student> allEntities = manager.getAllEntities();
        assertEquals(DEFAULT_ENTITY_COUNT, allEntities.size());

        // Check if the first entity got right values
        Student entity_2055120 = allEntities.get(0);
        checkValuesEquals(evm_2055120, getEntityValueMap(entity_2055120));

        // Check if the second entity got right values
        Student entity_2055121 = allEntities.get(1);
        checkValuesEquals(evm_2055121, getEntityValueMap(entity_2055121));

        // Check if the entities are equal to the result of the appropriate method call of manager.getEntity(id)
        for (Student entity1 : allEntities) {
            Student entity2 = manager.getEntity(entity1.getStudentNumber());
            assertEquals(entity2, entity1);
            checkValuesEquals(getEntityValueMap(entity2), getEntityValueMap(entity1));
        }
    }

    /**
     * Tests the method getEntity of the StudentManager.
     * Following aspects are tested:
     * - Check if the entities got right values (only the first two entities are tested)
     */
    @Test
    public void test_getEntity() throws EntityNotFoundException {
        // Check values of the first entity
        Student entity_2055120 = manager.getEntity(manager.createID("2055120"));
        checkValuesEquals(evm_2055120, getEntityValueMap(entity_2055120));

        // Check values of the second entity
        Student entity_2055121 = manager.getEntity(manager.createID("2055121"));
        checkValuesEquals(evm_2055121, getEntityValueMap(entity_2055121));
    }

    /**
     * Tests the EntityNotFoundException of the method getEntity of the StudentManager.
     * Following aspects are tested:
     * - getEntity with an unknown id throws an EntityNotFoundException
     * - following ids are tested: '0000000', '2055119' and '2055224'
     */
    @Test
    public void test_getEntity_EntityNotFoundException() {
        // Try to get an object with unknown id '0000000'
        try {
            manager.getEntity(manager.createID("0000000"));
            fail();
        } catch (EntityNotFoundException e) {
            // expected
        }

        // Try to get an object with unknown id '2055119'
        try {
            manager.getEntity(manager.createID("2055119"));
            fail();
        } catch (EntityNotFoundException e) {
            // expected
        }

        // Try to get an object with unknown id '2055224'
        try {
            manager.getEntity(manager.createID("2055224"));
            fail();
        } catch (EntityNotFoundException e) {
            // expected
        }
    }
}
