package net.unikit.database;

import net.unikit.database.exceptions.EntityNotFoundException;
import net.unikit.database.interfaces.entities.Course;
import net.unikit.database.interfaces.entities.CourseGroup;
import net.unikit.database.interfaces.entities.CourseGroupAppointment;
import net.unikit.database.interfaces.managers.CourseGroupManager;
import net.unikit.database.test_utils.DatabaseTestUtils;
import net.unikit.database.test_utils.EntityValueMap;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Unit tests for CourseGroup and CourseGroupManager.
 */
public class CourseGroupTest extends AbstractTest<CourseGroup, Integer, CourseGroup.ID, CourseGroupManager> {
    private static final int DEFAULT_ENTITY_COUNT = 8;

    private CourseGroupManager manager;
    private EntityValueMap evm_1;
    private EntityValueMap evm_2;

    /**
     * Getter for the class object of the entity interface.
     * Used for internal implementations of the abstract class AbstractTest.
     * @return The class object of the entity interface
     */
    @Override
    protected Class<CourseGroup> getInterfaceClass() {
        return CourseGroup.class;
    }

    /**
     * Initialize all CourseGroup specific attributes
     * @throws Exception if any error occurs
     */
    @Override
    protected void init() throws Exception {
        manager = getEntityManager();

        // Create entity value map for the first entity
        evm_1 = createEntityValueMap();
        evm_1.put("id", manager.createID(1));
        evm_1.put("course", DatabaseTestUtils.getEntity(Course.class, 1));
        evm_1.put("groupNumber", 1);
        evm_1.put("maxGroupSize", 30);
        evm_1.put("appointments", Arrays.asList(
                DatabaseTestUtils.getEntity(CourseGroupAppointment.class, 1),
                DatabaseTestUtils.getEntity(CourseGroupAppointment.class, 2)
        ));
        evm_1.makeImmutable();

        // Create entity value map for the second entity
        evm_2 = createEntityValueMap();
        evm_2.put("id", manager.createID(2));
        evm_2.put("course", DatabaseTestUtils.getEntity(Course.class, 1));
        evm_2.put("groupNumber", 2);
        evm_2.put("maxGroupSize", 30);
        evm_2.put("appointments", Arrays.asList(
                DatabaseTestUtils.getEntity(CourseGroupAppointment.class, 3),
                DatabaseTestUtils.getEntity(CourseGroupAppointment.class, 4)
        ));
        evm_2.makeImmutable();
    }

    /**
     * Tests the method getAllEntities of the CourseGroupManager.
     * Following aspects are tested:
     * - Check if count of the entities is right (must be equal to DEFAULT_ENTITY_COUNT)
     * - Check if the entities got right values (only the first two entities are tested)
     * - Check if all entities are equal to the result of the appropriate method call of manager.getEntity(id)
     */
    @Test
    public void test_getAllEntities() throws EntityNotFoundException {
        // Check if count of the entities is right
        List<CourseGroup> allEntities = manager.getAllEntities();
        assertEquals(DEFAULT_ENTITY_COUNT, allEntities.size());

        // Check if the first entity got right values
        CourseGroup entity_1 = allEntities.get(0);
        checkValuesEquals(evm_1, getEntityValueMap(entity_1));

        // Check if the second entity got right values
        CourseGroup entity_2 = allEntities.get(1);
        checkValuesEquals(evm_2, getEntityValueMap(entity_2));

        // Check if the entities are equal to the result of the appropriate method call of manager.getEntity(id)
        for (CourseGroup entity1 : allEntities) {
            CourseGroup entity2 = manager.getEntity(entity1.getId());
            assertEquals(entity2, entity1);
            checkValuesEquals(getEntityValueMap(entity2), getEntityValueMap(entity1));
        }
    }

    /**
     * Tests the method getEntity of the CourseGroupManager.
     * Following aspects are tested:
     * - Check if the entities got right values (only the first two entities are tested)
     */
    @Test
    public void test_getEntity() throws EntityNotFoundException {
        // Check values of the first entity
        CourseGroup entity_1 = manager.getEntity(manager.createID(1));
        checkValuesEquals(evm_1, getEntityValueMap(entity_1));

        // Check values of the second entity
        CourseGroup entity_2 = manager.getEntity(manager.createID(2));
        checkValuesEquals(evm_2, getEntityValueMap(entity_2));
    }

    /**
     * Tests the EntityNotFoundException of the method getEntity of the CourseGroupManager.
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
