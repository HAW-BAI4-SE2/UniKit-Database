package net.unikit.database;

import net.unikit.database.exceptions.EntityNotFoundException;
import net.unikit.database.interfaces.entities.FieldOfStudy;
import net.unikit.database.interfaces.managers.FieldOfStudyManager;
import net.unikit.database.test_utils.EntityValueMap;
import org.junit.Test;

import java.util.List;

/**
 * Unit tests for FieldOfStudy and FieldOfStudyManager.
 */
public class FieldOfStudyTest extends AbstractTest<FieldOfStudy, Integer, FieldOfStudy.ID, FieldOfStudyManager> {
    private static final int DEFAULT_ENTITY_COUNT = 1;

    private FieldOfStudyManager manager;
    private EntityValueMap evm_1;

    /**
     * Getter for the class object of the entity interface.
     * Used for internal implementations of the abstract class AbstractTest.
     * @return The class object of the entity interface
     */
    @Override
    protected Class<FieldOfStudy> getInterfaceClass() {
        return FieldOfStudy.class;
    }

    /**
     * Initialize all FieldOfStudy specific attributes
     * @throws Exception if any error occurs
     */
    @Override
    protected void init() throws Exception {
        manager = getEntityManager();

        // Create entity value map for the first entity
        evm_1 = createEntityValueMap();
        evm_1.put("id", manager.createID(1));
        evm_1.put("name", "Bachelor Angewandte Infomatik");
        evm_1.put("abbreviation", "B-AI");
        evm_1.makeImmutable();
    }

    /**
     * Tests the method getAllEntities of the FieldOfStudyManager.
     * Following aspects are tested:
     * - Check if count of the entities is right (must be equal to DEFAULT_ENTITY_COUNT)
     * - Check if entity got right values
     * - Check if all entities are equal to the result of the appropriate method call of manager.getEntity(id)
     */
    @Test
    public void test_getAllEntities() throws EntityNotFoundException {
        // Check if count of the entities is right
        List<FieldOfStudy> allEntities = manager.getAllEntities();
        assertEquals(DEFAULT_ENTITY_COUNT, allEntities.size());

        // Check if the first entity got right values
        FieldOfStudy entity_1 = allEntities.get(0);
        checkValuesEquals(evm_1, getEntityValueMap(entity_1));

        // Check if the entities are equal to the result of the appropriate method call of manager.getEntity(id)
        for (FieldOfStudy entity1 : allEntities) {
            FieldOfStudy entity2 = manager.getEntity(entity1.getId());
            assertEquals(entity2, entity1);
            checkValuesEquals(getEntityValueMap(entity2), getEntityValueMap(entity1));
        }
    }

    /**
     * Tests the method getEntity of the FieldOfStudyManager.
     * Following aspects are tested:
     * - Check if the entity got right values
     */
    @Test
    public void test_getEntity() throws EntityNotFoundException {
        // Check values of the first entity
        FieldOfStudy entity_1 = manager.getEntity(manager.createID(1));
        checkValuesEquals(evm_1, getEntityValueMap(entity_1));
    }

    /**
     * Tests the EntityNotFoundException of the method getEntity of the FieldOfStudyManager.
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
