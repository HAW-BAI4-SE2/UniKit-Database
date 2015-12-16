package net.unikit.database;

import net.unikit.database.exceptions.ConstraintViolationException;
import net.unikit.database.exceptions.EntityNotAddedException;
import net.unikit.database.exceptions.EntityNotFoundException;
import net.unikit.database.exceptions.MissingPropertyException;
import net.unikit.database.interfaces.entities.MembershipRequest;
import net.unikit.database.interfaces.entities.Student;
import net.unikit.database.interfaces.entities.Team;
import net.unikit.database.interfaces.managers.MembershipRequestManager;
import net.unikit.database.test_utils.DatabaseTestUtils;
import net.unikit.database.test_utils.EntityValueMap;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Andreas on 28.11.2015.
 */
public class OLD_Finished extends AbstractTest<MembershipRequest, Integer, MembershipRequest.ID, MembershipRequestManager> {
    private MembershipRequestManager manager;

    @Override
    public void init() throws Exception {
    }

    @Override
    protected Class<MembershipRequest> getInterfaceClass() {
        return MembershipRequest.class;
    }

















    @Test
    public void test_updateEntity_setApplicant() {
        MembershipRequestManager membershipRequestManager = TestSuite.getDatabaseManager().getMembershipRequestManager();

        // ========================================================================================================== //
        // get first entity
        MembershipRequest entity = DatabaseTestUtils.getMembershipRequest(1);

        // store old values
        MembershipRequest.ID idOld = entity.getId();
        Student applicantOld = null;
        try {
            applicantOld = entity.getApplicant();
        } catch (EntityNotFoundException e) {
            fail();
        }
        Team teamOld = entity.getTeam();
        Date createdAtOld = entity.getCreatedAt();
        Date updatedAtOld = entity.getUpdatedAt();

        // change attribute values
        Student newValue = DatabaseTestUtils.getStudent("2055178");
        entity.setApplicant(newValue);
        // ========================================================================================================== //



        // ========================================================================================================== //
        // === CHECK STATE OF CHANGED OBJECT ======================================================================== //
        // store new values
        MembershipRequest.ID id = entity.getId();
        Student applicant = null;
        try {
            applicant = entity.getApplicant();
        } catch (EntityNotFoundException e) {
            fail();
        }
        Team team = entity.getTeam();
        Date createdAt = entity.getCreatedAt();
        Date updatedAt = entity.getUpdatedAt();

        // check values
        assertEquals(id, idOld);
        assertEquals(applicant, newValue);
        assertEquals(team, teamOld);
        assertEquals(createdAt, createdAtOld);
        assertEquals(updatedAt, updatedAtOld);
        // ========================================================================================================== //



        // ========================================================================================================== //
        // === CHECK STATE OF OBJECT IN DATABASE ==================================================================== //
        // load entity from database
        MembershipRequest entity1 = DatabaseTestUtils.getMembershipRequest(1);

        // store new values
        id = entity1.getId();
        applicant = null;
        try {
            applicant = entity1.getApplicant();
        } catch (EntityNotFoundException e) {
            fail();
        }
        team = entity1.getTeam();
        createdAt = entity1.getCreatedAt();
        updatedAt = entity1.getUpdatedAt();

        // check values
        assertEquals(id, idOld);
        assertEquals(applicant, applicantOld);
        assertEquals(team, teamOld);
        assertEquals(createdAt, createdAtOld);
        assertEquals(updatedAt, updatedAtOld);
        // ========================================================================================================== //



        // ========================================================================================================== //
        // check if team doesn't got the membership request
        newValue = DatabaseTestUtils.getStudent("2055178");
        boolean result = true;
        try {
            result = newValue.getMembershipRequests().contains(entity);
        } catch (EntityNotFoundException e) {
            fail();
        }
        assertFalse(result);

        result = true;
        try {
            result = newValue.getMembershipRequests().contains(entity1);
        } catch (EntityNotFoundException e) {
            fail();
        }
        assertFalse(result);
        // ========================================================================================================== //



        // ========================================================================================================== //
        // update entity
        Date updateDate = new Date(System.currentTimeMillis() - 10000);
        try {
            membershipRequestManager.updateEntity(entity);
        } catch (EntityNotFoundException e) {
            fail();
        } catch (ConstraintViolationException e) {
            fail();
        }
        // ========================================================================================================== //



        // ========================================================================================================== //
        // === CHECK STATE OF CHANGED OBJECT ======================================================================== //
        // store new values
        id = entity.getId();
        applicant = null;
        try {
            applicant = entity.getApplicant();
        } catch (EntityNotFoundException e) {
            fail();
        }
        team = entity.getTeam();
        createdAt = entity.getCreatedAt();
        updatedAt = entity.getUpdatedAt();

        // check values
        assertEquals(id, idOld);
        assertEquals(applicant, newValue);
        assertEquals(team, teamOld);
        assertEquals(createdAt, createdAtOld);
        assertTrue(updatedAt.compareTo(updateDate) >= 0);
        // ========================================================================================================== //



        // ========================================================================================================== //
        // === CHECK STATE OF OBJECT IN DATABASE ==================================================================== //
        // load entity from database
        entity1 = DatabaseTestUtils.getMembershipRequest(1);

        // store new values
        id = entity1.getId();
        applicant = null;
        try {
            applicant = entity1.getApplicant();
        } catch (EntityNotFoundException e) {
            fail();
        }
        team = entity1.getTeam();
        createdAt = entity1.getCreatedAt();
        updatedAt = entity1.getUpdatedAt();

        // check values
        assertEquals(id, idOld);
        assertEquals(applicant, newValue);
        assertEquals(team, teamOld);
        assertEquals(createdAt, createdAtOld);
        assertTrue(updatedAt.compareTo(updateDate) >= 0);
        // ========================================================================================================== //



        // ========================================================================================================== //
        // check if team does got the membership request
        newValue = DatabaseTestUtils.getStudent("2055178");
        result = false;
        try {
            result = newValue.getMembershipRequests().contains(entity);
        } catch (EntityNotFoundException e) {
            fail();
        }
        assertTrue(result);

        result = false;
        try {
            result = newValue.getMembershipRequests().contains(entity1);
        } catch (EntityNotFoundException e) {
            fail();
        }
        assertTrue(result);
        // ========================================================================================================== //
    }

    @Test
    public void test_updateEntity_setTeam() {
        MembershipRequestManager membershipRequestManager = TestSuite.getDatabaseManager().getMembershipRequestManager();

        // ========================================================================================================== //
        // get first entity
        MembershipRequest entity = DatabaseTestUtils.getMembershipRequest(1);

        // store old values
        MembershipRequest.ID idOld = entity.getId();
        Student applicantOld = null;
        try {
            applicantOld = entity.getApplicant();
        } catch (EntityNotFoundException e) {
            fail();
        }
        Team teamOld = entity.getTeam();
        Date createdAtOld = entity.getCreatedAt();
        Date updatedAtOld = entity.getUpdatedAt();

        // change attribute values
        Team newValue = DatabaseTestUtils.getTeam(4);
        entity.setTeam(newValue);
        // ========================================================================================================== //



        // ========================================================================================================== //
        // === CHECK STATE OF CHANGED OBJECT ======================================================================== //
        // store new values
        MembershipRequest.ID id = entity.getId();
        Student applicant = null;
        try {
            applicant = entity.getApplicant();
        } catch (EntityNotFoundException e) {
            fail();
        }
        Team team = entity.getTeam();
        Date createdAt = entity.getCreatedAt();
        Date updatedAt = entity.getUpdatedAt();

        // check values
        assertEquals(id, idOld);
        assertEquals(applicant, applicantOld);
        assertEquals(team, newValue);
        assertEquals(createdAt, createdAtOld);
        assertEquals(updatedAt, updatedAtOld);
        // ========================================================================================================== //



        // ========================================================================================================== //
        // === CHECK STATE OF OBJECT IN DATABASE ==================================================================== //
        // load entity from database
        MembershipRequest entity1 = DatabaseTestUtils.getMembershipRequest(1);

        // store new values
        id = entity1.getId();
        applicant = null;
        try {
            applicant = entity1.getApplicant();
        } catch (EntityNotFoundException e) {
            fail();
        }
        team = entity1.getTeam();
        createdAt = entity1.getCreatedAt();
        updatedAt = entity1.getUpdatedAt();

        // check values
        assertEquals(id, idOld);
        assertEquals(applicant, applicantOld);
        assertEquals(team, teamOld);
        assertEquals(createdAt, createdAtOld);
        assertEquals(updatedAt, updatedAtOld);
        // ========================================================================================================== //



        // ========================================================================================================== //
        // check if team doesn't got the membership request
        newValue = DatabaseTestUtils.getTeam(4);
        assertFalse(newValue.getMembershipRequests().contains(entity));
        assertFalse(newValue.getMembershipRequests().contains(entity1));
        // ========================================================================================================== //



        // ========================================================================================================== //
        // update entity
        Date updateDate = new Date(System.currentTimeMillis() - 10000);
        try {
            membershipRequestManager.updateEntity(entity);
        } catch (EntityNotFoundException e) {
            fail();
        } catch (ConstraintViolationException e) {
            fail();
        }
        // ========================================================================================================== //



        // ========================================================================================================== //
        // === CHECK STATE OF CHANGED OBJECT ======================================================================== //
        // store new values
        id = entity.getId();
        applicant = null;
        try {
            applicant = entity.getApplicant();
        } catch (EntityNotFoundException e) {
            fail();
        }
        team = entity.getTeam();
        createdAt = entity.getCreatedAt();
        updatedAt = entity.getUpdatedAt();

        // check values
        assertEquals(id, idOld);
        assertEquals(applicant, applicantOld);
        assertEquals(team, newValue);
        assertEquals(createdAt, createdAtOld);
        assertTrue(updatedAt.compareTo(updateDate) >= 0);
        // ========================================================================================================== //



        // ========================================================================================================== //
        // === CHECK STATE OF OBJECT IN DATABASE ==================================================================== //
        // load entity from database
        entity1 = DatabaseTestUtils.getMembershipRequest(1);

        // store new values
        id = entity1.getId();
        applicant = null;
        try {
            applicant = entity1.getApplicant();
        } catch (EntityNotFoundException e) {
            fail();
        }
        team = entity1.getTeam();
        createdAt = entity1.getCreatedAt();
        updatedAt = entity1.getUpdatedAt();

        // check values
        assertEquals(id, idOld);
        assertEquals(applicant, applicantOld);
        assertEquals(team, newValue);
        assertEquals(createdAt, createdAtOld);
        assertTrue(updatedAt.compareTo(updateDate) >= 0);
        // ========================================================================================================== //



        // ========================================================================================================== //
        // check if team does got the membership request
        newValue = DatabaseTestUtils.getTeam(4);
        assertTrue(newValue.getMembershipRequests().contains(entity));
        assertTrue(newValue.getMembershipRequests().contains(entity1));
        // ========================================================================================================== //
    }

    @Test
    public void test_updateEntity_EntityNotAddedException() {
        MembershipRequestManager membershipRequestManager = TestSuite.getDatabaseManager().getMembershipRequestManager();

        // create entity with values from the database, which is not added yet
        Student applicantOld = DatabaseTestUtils.getStudent("2055120");
        Team teamOld = DatabaseTestUtils.getTeam(3);

        MembershipRequest entity = membershipRequestManager.createEntity();
        entity.setApplicant(applicantOld);
        entity.setTeam(teamOld);

        // store old values
        MembershipRequest.ID idOld = entity.getId();
        applicantOld = null;
        try {
            applicantOld = entity.getApplicant();
        } catch (EntityNotFoundException e) {
            fail();
        }
        teamOld = entity.getTeam();
        Date createdAtOld = entity.getCreatedAt();
        Date updatedAtOld = entity.getUpdatedAt();

        // change attribute values
        Team newValue = DatabaseTestUtils.getTeam(4);
        entity.setTeam(newValue);

        // add entity
        Date updateDate = new Date(System.currentTimeMillis() - 10000);
        try {
            membershipRequestManager.updateEntity(entity);
            fail();
        } catch (EntityNotAddedException e) {
            // expected
        } catch (EntityNotFoundException e) {
            // unexpected
            fail();
        } catch (ConstraintViolationException e) {
            // unexpected
            fail();
        }

        // store new values
        MembershipRequest.ID id = entity.getId();
        Student applicant = null;
        try {
            applicant = entity.getApplicant();
        } catch (EntityNotFoundException e) {
            fail();
        }
        Team team = entity.getTeam();
        Date createdAt = entity.getCreatedAt();
        Date updatedAt = entity.getUpdatedAt();

        // check values
        assertEquals(id, idOld);
        assertEquals(applicant, applicantOld);
        assertEquals(team, newValue);
        assertEquals(createdAt, createdAtOld);
        assertEquals(updatedAt, updatedAtOld);
    }

    @Test
    public void test_updateEntity_EntityNotFoundException() {
        MembershipRequestManager membershipRequestManager = TestSuite.getDatabaseManager().getMembershipRequestManager();

        // get first entity
        MembershipRequest entity = DatabaseTestUtils.getMembershipRequest(1);

        // delete entity
        try {
            membershipRequestManager.deleteEntity(entity);
        } catch (EntityNotFoundException e) {
            fail();
        }

        // change attribute values
        entity.setTeam(DatabaseTestUtils.getTeam(4));

        // check size of entity list to prove that no object will be added
        assertEquals(membershipRequestManager.getAllEntities().size(), 3);

        // add entity
        Date updateDate = new Date(System.currentTimeMillis() - 10000);
        try {
            membershipRequestManager.updateEntity(entity);
            fail();
        } catch (EntityNotAddedException e) {
            // unexpected
            fail();
        } catch (EntityNotFoundException e) {
            // expected
        } catch (ConstraintViolationException e) {
            // unexpected
            fail();
        }

        // check size of entity list to prove that no object was added
        assertEquals(membershipRequestManager.getAllEntities().size(), 3);
    }

    @Test
    public void test_updateEntity_ConstraintViolationException() {
        MembershipRequestManager membershipRequestManager = TestSuite.getDatabaseManager().getMembershipRequestManager();

        // ========================================================================================================== //
        // get first entity
        MembershipRequest entity = DatabaseTestUtils.getMembershipRequest(2);

        // store old values
        MembershipRequest.ID idOld = entity.getId();
        Student applicantOld = null;
        try {
            applicantOld = entity.getApplicant();
        } catch (EntityNotFoundException e) {
            fail();
        }
        Team teamOld = entity.getTeam();
        Date createdAtOld = entity.getCreatedAt();
        Date updatedAtOld = entity.getUpdatedAt();

        // change attribute values
        Student newApplicant = DatabaseTestUtils.getStudent("2055120");
        Team newTeam = DatabaseTestUtils.getTeam(3);
        entity.setApplicant(newApplicant);
        entity.setTeam(newTeam);
        // ========================================================================================================== //



        // ========================================================================================================== //
        // === CHECK STATE OF CHANGED OBJECT ======================================================================== //
        // store new values
        MembershipRequest.ID id = entity.getId();
        Student applicant = null;
        try {
            applicant = entity.getApplicant();
        } catch (EntityNotFoundException e) {
            fail();
        }
        Team team = entity.getTeam();
        Date createdAt = entity.getCreatedAt();
        Date updatedAt = entity.getUpdatedAt();

        // check values
        assertEquals(id, idOld);
        assertEquals(applicant, newApplicant);
        assertEquals(team, newTeam);
        assertEquals(createdAt, createdAtOld);
        assertEquals(updatedAt, updatedAtOld);
        // ========================================================================================================== //



        // ========================================================================================================== //
        // === CHECK STATE OF OBJECT IN DATABASE ==================================================================== //
        // load entity from database
        MembershipRequest entity1 = DatabaseTestUtils.getMembershipRequest(2);

        // store new values
        id = entity1.getId();
        applicant = null;
        try {
            applicant = entity1.getApplicant();
        } catch (EntityNotFoundException e) {
            fail();
        }
        team = entity1.getTeam();
        createdAt = entity1.getCreatedAt();
        updatedAt = entity1.getUpdatedAt();

        // check values
        assertEquals(id, idOld);
        assertEquals(applicant, applicantOld);
        assertEquals(team, teamOld);
        assertEquals(createdAt, createdAtOld);
        assertEquals(updatedAt, updatedAtOld);
        // ========================================================================================================== //



        // ========================================================================================================== //
        // check if student doesn't got the membership request
        newApplicant = DatabaseTestUtils.getStudent("2055120");
        try {
            assertFalse(newApplicant.getMembershipRequests().contains(entity));
            assertFalse(newApplicant.getMembershipRequests().contains(entity1));
        } catch (EntityNotFoundException e) {
            fail();
        }

        // check if team doesn't got the membership request
        newTeam = DatabaseTestUtils.getTeam(3);
        assertFalse(newTeam.getMembershipRequests().contains(entity));
        assertFalse(newTeam.getMembershipRequests().contains(entity1));
        // ========================================================================================================== //

        // add entity
        Date updateDate = new Date(System.currentTimeMillis() - 10000);
        try {
            membershipRequestManager.updateEntity(entity);
            fail();
        } catch (EntityNotFoundException e) {
            // unexpected
            fail();
        } catch (ConstraintViolationException e) {
            // expected
        }

        // ========================================================================================================== //
        // === CHECK STATE OF CHANGED OBJECT ======================================================================== //
        // store new values
        id = entity.getId();
        applicant = null;
        try {
            applicant = entity.getApplicant();
        } catch (EntityNotFoundException e) {
            fail();
        }
        team = entity.getTeam();
        createdAt = entity.getCreatedAt();
        updatedAt = entity.getUpdatedAt();

        // check values
        assertEquals(id, idOld);
        assertEquals(applicant, newApplicant);
        assertEquals(team, newTeam);
        assertEquals(createdAt, createdAtOld);
        assertEquals(updatedAt, updatedAtOld);
        // ========================================================================================================== //



        // ========================================================================================================== //
        // === CHECK STATE OF OBJECT IN DATABASE ==================================================================== //
        // load entity from database
        entity1 = DatabaseTestUtils.getMembershipRequest(2);

        // store new values
        id = entity1.getId();
        applicant = null;
        try {
            applicant = entity1.getApplicant();
        } catch (EntityNotFoundException e) {
            fail();
        }
        team = entity1.getTeam();
        createdAt = entity1.getCreatedAt();
        updatedAt = entity1.getUpdatedAt();

        // check values
        assertEquals(id, idOld);
        assertEquals(applicant, applicantOld);
        assertEquals(team, teamOld);
        assertEquals(createdAt, createdAtOld);
        assertEquals(updatedAt, updatedAtOld);
        // ========================================================================================================== //



        // ========================================================================================================== //
        // check if student doesn't got the membership request
        newApplicant = DatabaseTestUtils.getStudent("2055120");
        try {
            assertFalse(newApplicant.getMembershipRequests().contains(entity));
            assertFalse(newApplicant.getMembershipRequests().contains(entity1));
        } catch (EntityNotFoundException e) {
            fail();
        }

        // check if team doesn't got the membership request
        newTeam = DatabaseTestUtils.getTeam(3);
        assertFalse(newTeam.getMembershipRequests().contains(entity));
        assertFalse(newTeam.getMembershipRequests().contains(entity1));
        // ========================================================================================================== //
    }

    @Test
     public void test_deleteEntity() {
        MembershipRequestManager membershipRequestManager = TestSuite.getDatabaseManager().getMembershipRequestManager();

        // delete first entity
        MembershipRequest entity1 = DatabaseTestUtils.getMembershipRequest(1);
        try {
            membershipRequestManager.deleteEntity(entity1);
        } catch (EntityNotFoundException e) {
            fail();
        }

        // check if entity was deleted
        assertEquals(membershipRequestManager.getAllEntities().size(), 3);
        try {
            entity1 = DatabaseTestUtils.getMembershipRequest(1);
            fail();
        } catch (IllegalStateException e) {
            // expected
        }

        // get second entity
        MembershipRequest entity2 = DatabaseTestUtils.getMembershipRequest(2);
        try {
            membershipRequestManager.deleteEntity(entity2);
        } catch (EntityNotFoundException e) {
            fail();
        }

        // check if entity was deleted
        assertEquals(membershipRequestManager.getAllEntities().size(), 2);
        try {
            entity2 = DatabaseTestUtils.getMembershipRequest(2);
            fail();
        } catch (IllegalStateException e) {
            // expected
        }
    }

    @Test
    public void test_deleteEntity_EntityNotFoundException() {
        MembershipRequestManager membershipRequestManager = TestSuite.getDatabaseManager().getMembershipRequestManager();

        // create entity with values from the database, which is not added yet
        Student applicant = DatabaseTestUtils.getStudent("2055120");
        Team team = DatabaseTestUtils.getTeam(3);

        MembershipRequest entity = membershipRequestManager.createEntity();
        entity.setApplicant(applicant);
        entity.setTeam(team);

        // delete entity
        try {
            membershipRequestManager.deleteEntity(entity);
            fail();
        } catch (EntityNotAddedException e) {
            // expected
        } catch (EntityNotFoundException e) {
            // unexpected
            fail();
        }
    }

    @Test
    public void test_addEntity() {
        MembershipRequestManager membershipRequestManager = TestSuite.getDatabaseManager().getMembershipRequestManager();

        // ========================================================================================================== //
        // create entity
        Student applicant = DatabaseTestUtils.getStudent("2055223");
        Team team = DatabaseTestUtils.getTeam(8);

        MembershipRequest entity = membershipRequestManager.createEntity();
        entity.setApplicant(applicant);
        entity.setTeam(team);
        // ========================================================================================================== //



        // ========================================================================================================== //
        // add entity
        Date creationDate = new Date(System.currentTimeMillis() - 10000);
        try {
            membershipRequestManager.addEntity(entity);
        } catch (ConstraintViolationException e) {
            fail();
        }

        // get the database entity
        MembershipRequest.ID id = membershipRequestManager.createID(5);
        MembershipRequest entity1 = null;
        try {
            entity1 = DatabaseTestUtils.getMembershipRequest(5);
        } catch (IllegalStateException e) {
            // error: entity was not found
            fail();
        }
        // ========================================================================================================== //



        // ========================================================================================================== //
        // check if in database now
        assertEquals(entity.getId(), id);
        assertEquals(membershipRequestManager.getAllEntities().size(), 5);
        try {
            entity1 = membershipRequestManager.getEntity(id);
        } catch (EntityNotFoundException e) {
            fail();
        }

        // check if student does got the membership request
        applicant = DatabaseTestUtils.getStudent("2055223");
        try {
            assertTrue(applicant.getMembershipRequests().contains(entity));
            assertTrue(applicant.getMembershipRequests().contains(entity1));
        } catch (EntityNotFoundException e) {
            fail();
        }

        // check if team does got the membership request
        team = DatabaseTestUtils.getTeam(8);
        assertTrue(team.getMembershipRequests().contains(entity));
        assertTrue(team.getMembershipRequests().contains(entity1));
        // ========================================================================================================== //



        // ========================================================================================================== //
        // check values of created entity
        assertEquals(entity.getId(), id);
        try {
            assertEquals(entity.getApplicant(), applicant);
        } catch (EntityNotFoundException e) {
            fail();
        }
        assertEquals(entity.getTeam(), team);
        assertTrue(entity.getCreatedAt().compareTo(creationDate) >= 0);
        assertTrue(entity.getUpdatedAt().compareTo(creationDate) >= 0);

        // check values of database entity
        assertEquals(entity1.getId(), id);
        try {
            assertEquals(entity1.getApplicant(), applicant);
        } catch (EntityNotFoundException e) {
            fail();
        }
        assertEquals(entity1.getTeam(), team);
        assertTrue(entity1.getCreatedAt().compareTo(creationDate) >= 0);
        assertTrue(entity1.getUpdatedAt().compareTo(creationDate) >= 0);
        // ========================================================================================================== //
    }

    @Test
    public void test_addEntity_ConstraintViolationException() {
        MembershipRequestManager membershipRequestManager = TestSuite.getDatabaseManager().getMembershipRequestManager();

        // create entity which violates the 'applicant_student_number__team_id_UNIQUE' constraint
        Student applicant = DatabaseTestUtils.getStudent("2055120");
        Team team = DatabaseTestUtils.getTeam(3);

        MembershipRequest entity = membershipRequestManager.createEntity();
        entity.setApplicant(applicant);
        entity.setTeam(team);

        // add the entity
        try {
            membershipRequestManager.addEntity(entity);
            fail();
        } catch (ConstraintViolationException e) {
            // expected
        }
    }

    @Test
    public void test_addEntity_MissingPropertyException() {
        MembershipRequestManager membershipRequestManager = TestSuite.getDatabaseManager().getMembershipRequestManager();
        MembershipRequest entity = null;

        // potential attribute values
        Student applicant = DatabaseTestUtils.getStudent("2055223");
        Team team = DatabaseTestUtils.getTeam(8);

        // without: [applicant, team]
        entity = membershipRequestManager.createEntity();
        try {
            membershipRequestManager.addEntity(entity);
            fail();
        } catch (MissingPropertyException e) {
            // expected exception
        } catch (ConstraintViolationException e) {
            // unexpected exception
            e.printStackTrace();
            fail();
        }

        // without: [team]
        entity = membershipRequestManager.createEntity();
        entity.setApplicant(applicant);
        try {
            membershipRequestManager.addEntity(entity);
            fail();
        } catch (MissingPropertyException e) {
            // expected exception
        } catch (ConstraintViolationException e) {
            // unexpected exception
            fail();
        }

        // without: [applicant]
        entity = membershipRequestManager.createEntity();
        entity.setTeam(team);
        try {
            membershipRequestManager.addEntity(entity);
            fail();
        } catch (MissingPropertyException e) {
            // expected exception
        } catch (ConstraintViolationException e) {
            // unexpected exception
            fail();
        }

        // check if nothing was added to database
        assertEquals(membershipRequestManager.getAllEntities().size(), 4);
    }

    @Test
    public void test_createEntity() {
        MembershipRequestManager membershipRequestManager = TestSuite.getDatabaseManager().getMembershipRequestManager();

        // ========================================================================================================== //
        // create entity
        Student applicant = DatabaseTestUtils.getStudent("2055223");
        Team team = DatabaseTestUtils.getTeam(8);

        MembershipRequest entity = membershipRequestManager.createEntity();
        entity.setApplicant(applicant);
        entity.setTeam(team);
        // ========================================================================================================== //



        // ========================================================================================================== //
        MembershipRequest.ID id = membershipRequestManager.createID(5);
        MembershipRequest entity1 = null;

        // check if not in database yet
        assertFalse(entity.getId().equals(id));
        assertEquals(membershipRequestManager.getAllEntities().size(), 4);
        try {
            entity1 = membershipRequestManager.getEntity(id);
            fail();
        } catch (EntityNotFoundException e) {
            // expected
        }

        // check if student doesn't got the membership request
        try {
            assertFalse(applicant.getMembershipRequests().contains(entity));
        } catch (EntityNotFoundException e) {
            fail();
        }

        // check if team doesn't got the membership request
        assertFalse(team.getMembershipRequests().contains(entity));
        // ========================================================================================================== //
    }

    @Test
    public void test_createID() {
        MembershipRequestManager membershipRequestManager = TestSuite.getDatabaseManager().getMembershipRequestManager();

        // testing getValue
        MembershipRequest.ID id = membershipRequestManager.createID(100);
        assertTrue(id.getValue().equals(100));

        // testing equals
        MembershipRequest.ID id1 = membershipRequestManager.createID(100);
        assertEquals(id, id1);
        assertEquals(id, id);

        // testing hashCode
        assertEquals(id.hashCode(), id1.hashCode());
        assertEquals(id.hashCode(), id.hashCode());

        HashSet<MembershipRequest.ID> set = new HashSet<>();
        assertFalse(set.contains(id));
        set.add(id);
        assertTrue(set.contains(id));

        // testing toString()
        assertEquals(id.toString(), "MembershipRequest.ID{value=100}");
    }
}
