package net.unikit.database;

import net.unikit.database.exceptions.ConstraintViolationException;
import net.unikit.database.exceptions.EntityNotAddedException;
import net.unikit.database.exceptions.EntityNotFoundException;
import net.unikit.database.interfaces.entities.CourseGroupAppointment;
import net.unikit.database.interfaces.managers.CourseGroupAppointmentManager;
import net.unikit.database.test_utils.DatabaseTestUtils;
import net.unikit.database.test_utils.EntityValueMap;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;


/**
 * Unit tests for CourseGroupAppointment and CourseGroupAppointmentManager.
 */
// TODO: REPLACE 'CourseGroupAppointment' WITH TARGET CLASS NAME
// TODO: IF TARGET CLASS IS STUDENT, MAYBE REPLACE 'Integer' WITH 'String'
public class CourseGroupAppointmentTest extends AbstractTest<CourseGroupAppointment, Integer, CourseGroupAppointment.ID, CourseGroupAppointmentManager> {
    private static final int DEFAULT_ENTITY_COUNT = 16; // TODO: SET DEFAULT ENTITY COUNT

    private CourseGroupAppointmentManager manager;
    private EntityValueMap evm_1;
    private EntityValueMap evm_2;

    /**
     * Getter for the class object of the entity interface.
     * Used for internal implementations of the abstract class AbstractTest.
     * @return The class object of the entity interface
     */
    @Override
    protected Class<CourseGroupAppointment> getInterfaceClass() {
        return CourseGroupAppointment.class;
    }

    /**
     * Initialize all CourseGroupAppointment specific attributes
     * @throws Exception if any error occurs
     */
    @Override
    protected void init() throws Exception {
        manager = getEntityManager();

        // Create entity value map for the first entity
        evm_1 = createEntityValueMap();
        evm_1.put("id", manager.createID(1));
        // TODO: SET OTHER ATTRIBUTES
        // TODO: IN-COMMENT FOLLOWING ONLY FOR INTERNAL DATABASE
//        evm_1.put("createdAt", getCreatedAtRange());
//        evm_1.put("updatedAt", getCreatedAtRange());
        evm_1.makeImmutable();

        // Create entity value map for the second entity
        evm_2 = createEntityValueMap();
        evm_2.put("id", manager.createID(2));
        // TODO: SET OTHER ATTRIBUTES
        // TODO: IN-COMMENT FOLLOWING ONLY FOR INTERNAL DATABASE
//        evm_2.put("createdAt", getCreatedAtRange());
//        evm_2.put("updatedAt", getCreatedAtRange());
        evm_2.makeImmutable();
    }

    /**
     * Tests the method getAllEntities of the CourseGroupAppointmentManager.
     * Following aspects are tested:
     * - Check if count of the entities is right (must be equal to DEFAULT_ENTITY_COUNT)
     * - Check if the entities got right values (only the first two entities are tested)
     * - Check if all entities are equal to the result of the appropriate method call of manager.getEntity(id)
     */
    @Test
    public void test_getAllEntities() throws EntityNotFoundException {
        // Check if count of the entities is right
        List<CourseGroupAppointment> allEntities = manager.getAllEntities();
        assertEquals(DEFAULT_ENTITY_COUNT, allEntities.size());

        // Check if the first entity got right values
        CourseGroupAppointment entity_1 = allEntities.get(0);
        checkValuesEquals(evm_1, getEntityValueMap(entity_1));

        // Check if the second entity got right values
        CourseGroupAppointment entity_2 = allEntities.get(1);
        checkValuesEquals(evm_2, getEntityValueMap(entity_2));

        // Check if the entities are equal to the result of the appropriate method call of manager.getEntity(id)
        for (CourseGroupAppointment entity1 : allEntities) {
            CourseGroupAppointment entity2 = manager.getEntity(entity1.getId());
            assertEquals(entity2, entity1);
            checkValuesEquals(getEntityValueMap(entity2), getEntityValueMap(entity1));
        }
    }

    @Test
    public void test_getEntity() throws EntityNotFoundException {
        // Check values of the first entity
        CourseGroupAppointment entity_1 = manager.getEntity(manager.createID(1));
        checkValuesEquals(evm_1, getEntityValueMap(entity_1));

        // Check values of the second entity
        CourseGroupAppointment entity_2 = manager.getEntity(manager.createID(2));
        checkValuesEquals(evm_2, getEntityValueMap(entity_2));
    }

    @Test
    public void test_getEntity_EntityNotFoundException() {
        // Try to get an object with unknown id
        try {
            manager.getEntity(manager.createID(100));
            fail();
        } catch (EntityNotFoundException e) {
            // expected
        }
    }

    /**
     * TODO: Improve description
     * Checks the updateEntity method if nothing changed.
     * @throws EntityNotFoundException
     * @throws ConstraintViolationException
     */
    @Test
    public void test_updateEntity() throws EntityNotFoundException, ConstraintViolationException {
        // Get entity from database
        CourseGroupAppointment localEntity = manager.getEntity(manager.createID(1));
        EntityValueMap evmBeforeSet = getEntityValueMap(localEntity);

        // Perform update
        manager.updateEntity(localEntity);

        // Check if local entity has not changed
        checkValuesEquals(evmBeforeSet, getEntityValueMap(localEntity));

        // Check if database entity has not changed
        CourseGroupAppointment databaseEntity = manager.getEntity(manager.createID(1));
        checkValuesEquals(evmBeforeSet, getEntityValueMap(databaseEntity));
    }

    // TODO: DO IT FOR ALL ATTRIBUTES
    @Test
    public void test_updateEntity_setEndDate() throws EntityNotFoundException, ConstraintViolationException {
        // Get entity from database
        CourseGroupAppointment localEntity = manager.getEntity(manager.createID(1));
        EntityValueMap evmBeforeSet = getEntityValueMap(localEntity);

        // TODO: 1. Change variable name and set right value
        // TODO: 2. Search for usage of variable
        // TODO: 3. Maybe change 'attribute' in comment to 'attributeS'
        // Set new value of the attribute
        //***Date newEndDate = toDate("2015-10-27 12:30:00");
        //***localEntity.setEndDate(newEndDate);

        // Check if local entity has changed
        EntityValueMap evmBeforeUpdate = copyEntityValueMap(evmBeforeSet);
        //***evmBeforeUpdate.put("endDate", newEndDate);
        evmBeforeUpdate.makeImmutable();
        checkValuesEquals(evmBeforeUpdate, getEntityValueMap(localEntity));

        // TODO: Maybe check foreign objects
        // Check if foreign objects of local entity have not changed

        // Check if database entity has not changed
        CourseGroupAppointment databaseEntity = manager.getEntity(manager.createID(1));
        checkValuesEquals(evmBeforeSet, getEntityValueMap(databaseEntity));

        // TODO: Maybe check foreign objects
        // Check if foreign objects of database entity have not changed

        // Perform update
        Date updateStartDate = new Date(System.currentTimeMillis()); // TODO: ONLY IN INTERNAL DATABASE
        manager.updateEntity(localEntity);

        // Check if local entity has changed
        EntityValueMap evmAfterUpdate = copyEntityValueMap(evmBeforeSet);
        //***evmAfterUpdate.put("endDate", newEndDate);
        evmAfterUpdate.put("updatedAt", DatabaseTestUtils.createRange(updateStartDate, updateStartDate)); // TODO: ONLY IN INTERNAL DATABASE
        evmAfterUpdate.makeImmutable();
        checkValuesEquals(evmAfterUpdate, getEntityValueMap(localEntity));

        // TODO: Maybe check foreign objects
        // Check if foreign objects of local entity have changed

        // Check if database entity has changed
        databaseEntity = manager.getEntity(manager.createID(1));
        checkValuesEquals(evmAfterUpdate, getEntityValueMap(databaseEntity));

        // TODO: Maybe check foreign objects
        // Check if foreign objects of database entity have changed
    }

    @Test
    public void test_updateEntity_ModelNotAddedExceptionCommon() throws ConstraintViolationException, EntityNotFoundException {
        // Create object with existing values
        CourseGroupAppointment localEntity = manager.createEntity();
        CourseGroupAppointment databaseEntity = manager.getEntity(manager.createID(1));
        EntityValueMap evmBeforeSet = getEntityValueMap(databaseEntity);

        // TODO: SET VALUES
        //***localEntity.setCourseGroup(databaseEntity.getCourseGroup());
        //***localEntity.setStartDate(databaseEntity.getStartDate());
        //***localEntity.setEndDate(databaseEntity.getEndDate());

        // Perform update
        try {
            manager.updateEntity(localEntity);
            fail();
        } catch (EntityNotAddedException e) {
            // expected
        }

        databaseEntity = manager.getEntity(manager.createID(1));
        checkValuesEquals(evmBeforeSet, getEntityValueMap(databaseEntity));
    }

    @Test
    public void test_updateEntity_EntityNotFoundException() throws ConstraintViolationException, EntityNotFoundException {
        // Get entity from database
        CourseGroupAppointment entity = manager.getEntity(manager.createID(1));

        // Delete entity
        manager.deleteEntity(entity);

        // Perform update
        try {
            manager.updateEntity(entity);
            fail();
        } catch (EntityNotFoundException e) {
            // expected
        }

        // Check if entity is still deleted
        try {
            manager.getEntity(manager.createID(1));
            fail();
        } catch (EntityNotFoundException e) {
            // expected
        }

        // Check if no other object has been added
        List<CourseGroupAppointment> allEntities = manager.getAllEntities();
        assertEquals(DEFAULT_ENTITY_COUNT - 1, allEntities.size());
    }

    // TODO: FOR ALL ATTRIBUTES: HANDLE ConstraintViolationException IN updateEntity


    @Test
    public void test_deleteEntity() throws EntityNotFoundException {
        // delete first entity
        CourseGroupAppointment entity = getEntity(1);
        manager.deleteEntity(entity);

        // check if entity was deleted
        try {
            entity = getEntity(1);
            fail();
        } catch (EntityNotFoundException e) {
            // expected
        }

        // check if entity was deleted from entity list
        List<CourseGroupAppointment> allEntities = manager.getAllEntities();
        assertEquals(DEFAULT_ENTITY_COUNT - 1, allEntities.size());

        // TODO: Maybe check foreign objects
        // Check if foreign objects of entity noticed deletion
    }

    @Test
    public void test_deleteEntity_EntityNotAddedException() throws EntityNotFoundException {
        // Create object with existing values
        CourseGroupAppointment localEntity = manager.createEntity();
        CourseGroupAppointment databaseEntity = manager.getEntity(manager.createID(1));
        EntityValueMap evmBeforeSet = getEntityValueMap(databaseEntity);

        // TODO: SET VALUES
        //***localEntity.setCourseGroup(databaseEntity.getCourseGroup());
        //***localEntity.setStartDate(databaseEntity.getStartDate());
        //***localEntity.setEndDate(databaseEntity.getEndDate());

        // Perform update
        try {
            manager.deleteEntity(localEntity);
            fail();
        } catch (EntityNotAddedException e) {
            // expected
        }
    }

    @Test
    public void test_deleteEntity_EntityNotFoundException() throws EntityNotFoundException {
        // Get entity from database
        CourseGroupAppointment entity = manager.getEntity(manager.createID(1));

        // Delete entity
        manager.deleteEntity(entity);

        // Check size of entity list
        List<CourseGroupAppointment> allEntities = manager.getAllEntities();
        assertEquals(DEFAULT_ENTITY_COUNT - 1, allEntities.size());

        // Perform update
        try {
            manager.deleteEntity(entity);
            fail();
        } catch (EntityNotFoundException e) {
            // expected
        }

        // Check size of entity list
        allEntities = manager.getAllEntities();
        assertEquals(DEFAULT_ENTITY_COUNT - 1, allEntities.size());
    }

    // TODO: IMPLETED MISSING TESTS



    @Test
    public void test_createEntity() {
        CourseGroupAppointment entity = manager.createEntity();
        // TODO: SET ALL ATTRIBUTES

        // Check values
    }

    @Test
    public void test_createID() {
        // testing getValue
        CourseGroupAppointment.ID id = manager.createID(100);
        assertTrue(id.getValue().equals(100));

        // testing equals
        CourseGroupAppointment.ID id1 = manager.createID(100);
        assertEquals(id, id1);
        assertEquals(id, id);

        // testing hashCode
        assertEquals(id.hashCode(), id1.hashCode());
        assertEquals(id.hashCode(), id.hashCode());

        HashSet<CourseGroupAppointment.ID> set = new HashSet<>();
        assertFalse(set.contains(id));
        set.add(id);
        assertTrue(set.contains(id));

        // testing toString()
        assertEquals(id.toString(), "CourseGroupAppointment.ID{value=100}");
    }


    // TODO: IMPLEMENT OR DELETE FOLLOWING HELPER METHODS
    /**
     * Generates a Date object form a string in format "dd.MM.yyyy HH:mm:ss".
     * Example: toDate("2015-10-06 08:15:00")
     * @param date The String in format "dd.MM.yyyy HH:mm:ss"
     * @return The generated date
     */
    public static Date toDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        try {
            Date result = format.parse(date);
            return result;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
