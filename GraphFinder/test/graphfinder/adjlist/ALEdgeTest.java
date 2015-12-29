/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphfinder.adjlist;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author HP
 */
public class ALEdgeTest {
    
    public ALEdgeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getSource method, of class ALEdge.
     */
    @Test
    public void testGetSource() {
        System.out.println("getSource");
        ALEdge instance = null;
        ALVertex expResult = null;
        ALVertex result = instance.getSource();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDest method, of class ALEdge.
     */
    @Test
    public void testGetDest() {
        System.out.println("getDest");
        ALEdge instance = null;
        ALVertex expResult = null;
        ALVertex result = instance.getDest();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isTwoWay method, of class ALEdge.
     */
    @Test
    public void testIsTwoWay() {
        System.out.println("isTwoWay");
        ALEdge instance = null;
        boolean expResult = false;
        boolean result = instance.isTwoWay();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLength method, of class ALEdge.
     */
    @Test
    public void testGetLength() {
        System.out.println("getLength");
        ALEdge instance = null;
        int expResult = 0;
        int result = instance.getLength();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSpeed method, of class ALEdge.
     */
    @Test
    public void testGetSpeed() {
        System.out.println("getSpeed");
        ALEdge instance = null;
        int expResult = 0;
        int result = instance.getSpeed();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRTSpeed method, of class ALEdge.
     */
    @Test
    public void testGetRTSpeed() {
        System.out.println("getRTSpeed");
        ALEdge instance = null;
        int expResult = 0;
        int result = instance.getRTSpeed();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of end method, of class ALEdge.
     */
    @Test
    public void testEnd() {
        System.out.println("end");
        ALVertex v = null;
        ALEdge instance = null;
        boolean expResult = false;
        boolean result = instance.end(v);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class ALEdge.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        ALEdge instance = null;
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
