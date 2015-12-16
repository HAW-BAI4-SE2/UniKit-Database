package net.unikit.database;

import net.unikit.database.exceptions.EntityNotFoundException;
import net.unikit.database.interfaces.entities.*;
import net.unikit.database.interfaces.managers.CourseManager;
import net.unikit.database.test_utils.DatabaseTestUtils;
import net.unikit.database.test_utils.EntityValueMap;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Unit tests for Course and CourseManager.
 */
public class CourseTest extends AbstractTest<Course, Integer, Course.ID, CourseManager> {
    private static final int DEFAULT_ENTITY_COUNT = 4;

    private CourseManager manager;
    private EntityValueMap evm_1;
    private EntityValueMap evm_2;

    /**
     * Getter for the class object of the entity interface.
     * Used for internal implementations of the abstract class AbstractTest.
     * @return The class object of the entity interface
     */
    @Override
    protected Class<Course> getInterfaceClass() {
        return Course.class;
    }

    /**
     * Initialize all Course specific attributes
     * @throws Exception if any error occurs
     */
    @Override
    protected void init() throws Exception {
        manager = getEntityManager();

        // Create entity value map for the first entity
        evm_1 = createEntityValueMap();
        evm_1.put("id", manager.createID(1));
        evm_1.put("name", "Datenbanken");
        evm_1.put("abbreviation", "DB");
        evm_1.put("semester", 2);
        evm_1.put("minTeamSize", 2);
        evm_1.put("maxTeamSize", 2);
        evm_1.put("courseLecture", DatabaseTestUtils.getEntity(CourseLecture.class, 1));
        evm_1.put("courseGroups", Arrays.asList(
                DatabaseTestUtils.getEntity(CourseGroup.class, 1),
                DatabaseTestUtils.getEntity(CourseGroup.class, 2)
        ));
        evm_1.put("fieldOfStudies", Arrays.asList(
                DatabaseTestUtils.getEntity(FieldOfStudy.class, 1)
        ));
        evm_1.put("singleRegistrations", Arrays.asList(
                DatabaseTestUtils.getEntity(CourseRegistration.class, 1),
                DatabaseTestUtils.getEntity(CourseRegistration.class, 3),
                DatabaseTestUtils.getEntity(CourseRegistration.class, 5),
                DatabaseTestUtils.getEntity(CourseRegistration.class, 6),
                DatabaseTestUtils.getEntity(CourseRegistration.class, 8),
                DatabaseTestUtils.getEntity(CourseRegistration.class, 10),
                DatabaseTestUtils.getEntity(CourseRegistration.class, 12),
                DatabaseTestUtils.getEntity(CourseRegistration.class, 15),
                DatabaseTestUtils.getEntity(CourseRegistration.class, 16),
                DatabaseTestUtils.getEntity(CourseRegistration.class, 18),
                DatabaseTestUtils.getEntity(CourseRegistration.class, 20)
        ));
        evm_1.put("allCourseRegistrations", Arrays.asList(
                DatabaseTestUtils.getEntity(CourseRegistration.class, 1),
                DatabaseTestUtils.getEntity(CourseRegistration.class, 3),
                DatabaseTestUtils.getEntity(CourseRegistration.class, 5),
                DatabaseTestUtils.getEntity(CourseRegistration.class, 6),
                DatabaseTestUtils.getEntity(CourseRegistration.class, 8),
                DatabaseTestUtils.getEntity(CourseRegistration.class, 10),
                DatabaseTestUtils.getEntity(CourseRegistration.class, 12),
                DatabaseTestUtils.getEntity(CourseRegistration.class, 15),
                DatabaseTestUtils.getEntity(CourseRegistration.class, 16),
                DatabaseTestUtils.getEntity(CourseRegistration.class, 18),
                DatabaseTestUtils.getEntity(CourseRegistration.class, 20)
        ));
        evm_1.put("teams", Arrays.asList(
                DatabaseTestUtils.getEntity(Team.class, 1),
                DatabaseTestUtils.getEntity(Team.class, 4),
                DatabaseTestUtils.getEntity(Team.class, 6),
                DatabaseTestUtils.getEntity(Team.class, 7),
                DatabaseTestUtils.getEntity(Team.class, 9)
        ));
        evm_1.makeImmutable();

        // Create entity value map for the second entity
        evm_2 = createEntityValueMap();
        evm_2.put("id", manager.createID(2));
        evm_2.put("name", "Logik und Berechenbarkeit");
        evm_2.put("abbreviation", "LB");
        evm_2.put("semester", 2);
        evm_2.put("minTeamSize", 2);
        evm_2.put("maxTeamSize", 2);
        evm_2.put("courseLecture", DatabaseTestUtils.getEntity(CourseLecture.class, 2));
        evm_2.put("courseGroups", Arrays.asList(
                DatabaseTestUtils.getEntity(CourseGroup.class, 3),
                DatabaseTestUtils.getEntity(CourseGroup.class, 4)
        ));
        evm_2.put("fieldOfStudies", Arrays.asList(
                DatabaseTestUtils.getEntity(FieldOfStudy.class, 1)
        ));
        evm_2.put("singleRegistrations", Arrays.asList(
                DatabaseTestUtils.getEntity(CourseRegistration.class, 2),
                DatabaseTestUtils.getEntity(CourseRegistration.class, 4),
                DatabaseTestUtils.getEntity(CourseRegistration.class, 7),
                DatabaseTestUtils.getEntity(CourseRegistration.class, 9),
                DatabaseTestUtils.getEntity(CourseRegistration.class, 11),
                DatabaseTestUtils.getEntity(CourseRegistration.class, 13),
                DatabaseTestUtils.getEntity(CourseRegistration.class, 17),
                DatabaseTestUtils.getEntity(CourseRegistration.class, 19),
                DatabaseTestUtils.getEntity(CourseRegistration.class, 21)
        ));
        evm_2.put("allCourseRegistrations", Arrays.asList(
                DatabaseTestUtils.getEntity(CourseRegistration.class, 2),
                DatabaseTestUtils.getEntity(CourseRegistration.class, 4),
                DatabaseTestUtils.getEntity(CourseRegistration.class, 7),
                DatabaseTestUtils.getEntity(CourseRegistration.class, 9),
                DatabaseTestUtils.getEntity(CourseRegistration.class, 11),
                DatabaseTestUtils.getEntity(CourseRegistration.class, 13),
                DatabaseTestUtils.getEntity(CourseRegistration.class, 17),
                DatabaseTestUtils.getEntity(CourseRegistration.class, 19),
                DatabaseTestUtils.getEntity(CourseRegistration.class, 21)
        ));
        evm_2.put("teams", Arrays.asList(
                DatabaseTestUtils.getEntity(Team.class, 2),
                DatabaseTestUtils.getEntity(Team.class, 3),
                DatabaseTestUtils.getEntity(Team.class, 5),
                DatabaseTestUtils.getEntity(Team.class, 8),
                DatabaseTestUtils.getEntity(Team.class, 10)
        ));
        evm_2.makeImmutable();
    }

    /**
     * Tests the method getAllEntities of the CourseManager.
     * Following aspects are tested:
     * - Check if count of the entities is right (must be equal to DEFAULT_ENTITY_COUNT)
     * - Check if the entities got right values (only the first two entities are tested)
     * - Check if all entities are equal to the result of the appropriate method call of manager.getEntity(id)
     */
    @Test
    public void test_getAllEntities() throws EntityNotFoundException {
        // Check if count of the entities is right
        List<Course> allEntities = manager.getAllEntities();
        assertEquals(DEFAULT_ENTITY_COUNT, allEntities.size());

        // Check if the first entity got right values
        Course entity_1 = allEntities.get(0);
        checkValuesEquals(evm_1, getEntityValueMap(entity_1));

        // Check if the second entity got right values
        Course entity_2 = allEntities.get(1);
        checkValuesEquals(evm_2, getEntityValueMap(entity_2));

        // Check if the entities are equal to the result of the appropriate method call of manager.getEntity(id)
        for (Course entity1 : allEntities) {
            Course entity2 = manager.getEntity(entity1.getId());
            assertEquals(entity2, entity1);
            checkValuesEquals(getEntityValueMap(entity2), getEntityValueMap(entity1));
        }
    }

    /**
     * Tests the method getEntity of the CourseManager.
     * Following aspects are tested:
     * - Check if the entities got right values (only the first two entities are tested)
     */
    @Test
    public void test_getEntity() throws EntityNotFoundException {
        // Check values of the first entity
        Course entity_1 = manager.getEntity(manager.createID(1));
        checkValuesEquals(evm_1, getEntityValueMap(entity_1));

        // Check values of the second entity
        Course entity_2 = manager.getEntity(manager.createID(2));
        checkValuesEquals(evm_2, getEntityValueMap(entity_2));
    }

    /**
     * Tests the EntityNotFoundException of the method getEntity of the CourseManager.
     * Following aspects are tested:
     * - getEntity with an unknown id throws an EntityNotFoundException
     * - following ids are tested: '-1', '0' and 'DEFAULT_ENTITY_COUNT + 1'
     */
    @Test
    public void test_getEntity_EntityNotFoundException() {
        // Try to get an object with unknown id '-1'
        try {
            manager.getEntity(manager.createID(-1));
            fail();
        } catch (EntityNotFoundException e) {
            // expected
        }

        // Try to get an object with unknown id '0'
        try {
            manager.getEntity(manager.createID(0));
            fail();
        } catch (EntityNotFoundException e) {
            // expected
        }

        // Try to get an object with unknown id 'DEFAULT_ENTITY_COUNT + 1'
        try {
            manager.getEntity(manager.createID(DEFAULT_ENTITY_COUNT + 1));
            fail();
        } catch (EntityNotFoundException e) {
            // expected
        }
    }
}
