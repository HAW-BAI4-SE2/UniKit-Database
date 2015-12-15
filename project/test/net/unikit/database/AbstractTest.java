package net.unikit.database;

import junit.framework.TestCase;
import net.unikit.database.exceptions.EntityNotFoundException;
import net.unikit.database.interfaces.entities.AbstractEntity;
import net.unikit.database.interfaces.managers.AbstractManager;
import net.unikit.database.test_utils.DatabaseTestUtils;
import net.unikit.database.test_utils.EntityValueMap;
import net.unikit.database.test_utils.Range;
import org.junit.After;
import org.junit.Before;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * Created by Andreas on 28.11.2015.
 */
public abstract class AbstractTest<EntityType extends AbstractEntity, BaseIdType extends Serializable, IdType extends AbstractEntity.ID<BaseIdType>, ManagerType extends AbstractManager<EntityType, BaseIdType, IdType>> extends TestCase {
    protected abstract Class<EntityType> getInterfaceClass();
    protected abstract void init() throws Exception;

    private Range<Date> createdAtRange;

    @Before
    public void setUp() throws Exception {
        // Make sure the database manager is already loaded
        TestSuite.getDatabaseManager();

        // Generate range for createdAt property
        Date from = DatabaseTestUtils.getLastResetDate();
        Date to = new Date(System.currentTimeMillis());
        createdAtRange = DatabaseTestUtils.createRange(from, to);

        // Run initialize method of inheriting class
        init();
    }

    @After
    public void tearDown() throws Exception {
        System.err.println("Resetting test database...");
        DatabaseTestUtils.resetDatabase();
    }

    public Range<Date> getCreatedAtRange() {
        return createdAtRange;
    }

// TODO: REMOVE IF NOT NEEDED!
//    protected List<String> getKeysWithDifferentValues(EntityValueMap expected, EntityValueMap actual) {
//        List<String> result = new ArrayList<>();
//
//        for (Map.Entry<String, Object> entry : expected.entrySet()) {
//            String key = entry.getKey();
//            Object valueExpected = entry.getValue();
//            Object valueActual = actual.get(key);
//
//            boolean equals;
//            if (valueExpected instanceof Range) {
//                Range range = (Range) valueExpected;
//                equals = range.includes((Comparable) valueActual);
//            } else {
//                equals = Objects.equals(valueExpected, valueActual);
//            }
//
//            if (!equals)
//                result.add(key);
//        }
//
//        return result;
//    }

    protected void checkValuesEquals(EntityValueMap expected, EntityValueMap actual) {
        for (Map.Entry<String, Object> entry : expected.entrySet()) {
            String key = entry.getKey();
            Object valueExpected = entry.getValue();
            Object valueActual = actual.get(key);

            if (valueExpected instanceof Range) {
                Range range = (Range) valueExpected;
                boolean equals = range.includes((Comparable) valueActual);
                if (!equals)
                    assertEquals(valueExpected, valueActual);
            } else {
                assertEquals(valueExpected, valueActual);
            }
        }
    }

    protected ManagerType getEntityManager() {
        return (ManagerType) DatabaseTestUtils.getEntityManager(getInterfaceClass());
    }

    protected EntityType getEntity(BaseIdType id) throws EntityNotFoundException {
        return DatabaseTestUtils.getEntity(getInterfaceClass(), id);
    }

    protected EntityValueMap getEntityValueMap(BaseIdType id) throws EntityNotFoundException {
        EntityType entity = getEntity(id);
        return getEntityValueMap(entity);
    }

    protected EntityValueMap getEntityValueMap(EntityType entity) {
        return DatabaseTestUtils.getEntityValueMap(getInterfaceClass(), entity);
    }

    protected EntityValueMap createEntityValueMap() {
        return DatabaseTestUtils.createEntityValueMap(getInterfaceClass());
    }
}
