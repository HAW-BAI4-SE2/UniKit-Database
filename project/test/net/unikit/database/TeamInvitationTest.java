package net.unikit.database;

import net.unikit.database.exceptions.EntityNotFoundException;
import net.unikit.database.interfaces.entities.TeamInvitation;
import net.unikit.database.interfaces.managers.TeamInvitationManager;
import net.unikit.database.test_utils.EntityValueMap;
import org.junit.Test;

import java.util.List;

/**
 * Unit tests for TeamInvitation and TeamInvitationManager.
 */
public class TeamInvitationTest extends AbstractTest<TeamInvitation, Integer, TeamInvitation.ID, TeamInvitationManager> {
    private static final int DEFAULT_ENTITY_COUNT = 5;

    private TeamInvitationManager manager;
    private EntityValueMap evm_1;
    private EntityValueMap evm_2;

    /**
     * Getter for the class object of the entity interface.
     * Used for internal implementations of the abstract class AbstractTest.
     * @return The class object of the entity interface
     */
    @Override
    protected Class<TeamInvitation> getInterfaceClass() {
        return TeamInvitation.class;
    }

    /**
     * Initialize all TeamInvitation specific attributes
     * @throws Exception if any error occurs
     */
    @Override
    protected void init() throws Exception {
        manager = getEntityManager();

        // Create entity value map for the first entity
        evm_1 = createEntityValueMap();
        evm_1.put("id", manager.createID(1));
        evm_1.put("invitee", null);
        evm_1.put("team", null);
        evm_1.put("createdBy", null);
        evm_1.put("createdAt", getCreatedAtRange());
        evm_1.put("updatedAt", getCreatedAtRange());
        evm_1.makeImmutable();

        // Create entity value map for the second entity
        evm_2 = createEntityValueMap();
        evm_2.put("id", manager.createID(1));
        evm_2.put("invitee", null);
        evm_2.put("team", null);
        evm_2.put("createdBy", null);
        evm_2.put("createdAt", getCreatedAtRange());
        evm_2.put("updatedAt", getCreatedAtRange());
        evm_2.makeImmutable();
    }

    // TODO: REMOVE (ONLY NEEDED FOR DEVELOPMENT)
    @Test
    public void test_printAttributes() {
        EntityValueMap entityValueMap = createEntityValueMap();
        System.out.println("ATTRIBUTES OF " + getInterfaceClass().getSimpleName() + ": " + entityValueMap.keySet());
    }

    /**
     * Tests the method getAllEntities of the TeamInvitationManager.
     * Following aspects are tested:
     * - Check if count of the entities is right (must be equal to DEFAULT_ENTITY_COUNT)
     * - Check if the entities got right values (only the first two entities are tested)
     * - Check if all entities are equal to the result of the appropriate method call of manager.getEntity(id)
     */
    @Test
    public void test_getAllEntities() throws EntityNotFoundException {
        // Check if count of the entities is right
        List<TeamInvitation> allEntities = manager.getAllEntities();
        assertEquals(DEFAULT_ENTITY_COUNT, allEntities.size());

        // Check if the first entity got right values
        TeamInvitation entity_1 = allEntities.get(0);
        checkValuesEquals(evm_1, getEntityValueMap(entity_1));

        // Check if the second entity got right values
        TeamInvitation entity_2 = allEntities.get(1);
        checkValuesEquals(evm_2, getEntityValueMap(entity_2));

        // Check if the entities are equal to the result of the appropriate method call of manager.getEntity(id)
        for (TeamInvitation entity1 : allEntities) {
            TeamInvitation entity2 = manager.getEntity(entity1.getId());
            assertEquals(entity2, entity1);
            checkValuesEquals(getEntityValueMap(entity2), getEntityValueMap(entity1));
        }
    }

    @Test
    public void test_getEntity() throws EntityNotFoundException {
        // Check values of the first entity
        TeamInvitation entity_1 = manager.getEntity(manager.createID(1));
        checkValuesEquals(evm_1, getEntityValueMap(entity_1));

        // Check values of the second entity
        TeamInvitation entity_2 = manager.getEntity(manager.createID(2));
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
