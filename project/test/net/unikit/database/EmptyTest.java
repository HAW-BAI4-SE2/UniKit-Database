package net.unikit.database;

import net.unikit.database.interfaces.entities.MembershipRequest;
import net.unikit.database.interfaces.managers.MembershipRequestManager;
import net.unikit.database.test_utils.EntityValueMap;
import org.junit.Test;

/**
 * Created by Andreas on 28.11.2015.
 */
public class EmptyTest extends AbstractTest<MembershipRequest, Integer, MembershipRequest.ID, MembershipRequestManager> {
    @Override
    public void init() throws Exception {

    }

    @Test
    public void test() {
        EntityValueMap entityValueMap_1 = createEntityValueMap();
        assertEquals(1, 1);
    }

    @Override
    protected Class<MembershipRequest> getInterfaceClass() {
        return MembershipRequest.class;
    }

    @Override
    protected MembershipRequestManager getEntityManager() {
        return TestSuite.getDatabaseManager().getMembershipRequestManager();
    }
}
