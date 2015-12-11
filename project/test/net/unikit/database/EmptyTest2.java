package net.unikit.database;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Andreas on 28.11.2015.
 */
public class EmptyTest2 extends TestCase {
    @Before
    public void setUp() throws Exception {
        TestSuite.resetDatabase();
    }

    @Test
    public void test1() {
        System.out.println("Joined EmptyTest2.test1()");
    }

    @Test
    public void test2() {
        System.out.println("Joined EmptyTest2.test2()");
    }
}
