package net.unikit.database;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Test;

/**
 * Created by Andreas on 28.11.2015.
 */
public class EmptyTest1 extends TestCase {
    @After
    public void tearDown() throws Exception {
        System.err.println("Resetting database...");
        TestSuite.resetDatabase();
    }

    @Test
    public void test1() {
        assertEquals(1 + 2, 3);
    }

    @Test
    public void test2() {
        assertEquals(1 + 2, 3);
    }
}
