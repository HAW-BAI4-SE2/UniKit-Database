package net.unikit.database;

import net.unikit.database.exceptions.EntityNotFoundException;
import net.unikit.database.interfaces.entities.Course;
import net.unikit.database.interfaces.managers.CourseManager;
import net.unikit.database.test_utils.EntityValueMap;
import org.junit.Test;

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
        evm_1.put("name", null);
        evm_1.put("abbreviation", null);
        evm_1.put("semester", null);
        evm_1.put("minTeamSize", null);
        evm_1.put("maxTeamSize", null);
        evm_1.put("courseLecture", null);
        evm_1.put("courseGroups", null);
        evm_1.put("fieldOfStudies", null);
        evm_1.put("singleRegistrations", null);
        evm_1.put("allCourseRegistrations", null);
        evm_1.put("teams", null);
        evm_1.makeImmutable();

        // Create entity value map for the second entity
        evm_2 = createEntityValueMap();
        evm_2.put("id", manager.createID(2));
        evm_2.put("name", null);
        evm_2.put("abbreviation", null);
        evm_2.put("semester", null);
        evm_2.put("minTeamSize", null);
        evm_2.put("maxTeamSize", null);
        evm_2.put("courseLecture", null);
        evm_2.put("courseGroups", null);
        evm_2.put("fieldOfStudies", null);
        evm_2.put("singleRegistrations", null);
        evm_2.put("allCourseRegistrations", null);
        evm_2.put("teams", null);
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

    @Test
    public void test_getEntity() throws EntityNotFoundException {
        // Check values of the first entity
        Course entity_1 = manager.getEntity(manager.createID(1));
        checkValuesEquals(evm_1, getEntityValueMap(entity_1));

        // Check values of the second entity
        Course entity_2 = manager.getEntity(manager.createID(2));
        checkValuesEquals(evm_2, getEntityValueMap(entity_2));
    }

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
