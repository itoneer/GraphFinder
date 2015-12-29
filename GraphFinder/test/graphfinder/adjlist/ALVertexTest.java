/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphfinder.adjlist;

import java.util.List;
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
public class ALVertexTest {
    
    public ALVertexTest() {
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
     * Test of addNeighbor method, of class ALVertex.
     */
    @Test
    public void testAddNeighbor_6args() {
        System.out.println("addNeighbor");
        ALVertex v = null;
        boolean s = false;
        boolean tw = false;
        int ln = 0;
        int s1 = 0;
        int s2 = 0;
        ALVertex instance = null;
        instance.addNeighbor(v, s, tw, ln, s1, s2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addNeighbor method, of class ALVertex.
     */
    @Test
    public void testAddNeighbor_ALEdge() {
        System.out.println("addNeighbor");
        ALEdge e = null;
        ALVertex instance = null;
        instance.addNeighbor(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isNeighbor method, of class ALVertex.
     */
    @Test
    public void testIsNeighbor() {
        System.out.println("isNeighbor");
        ALVertex v = null;
        ALVertex instance = null;
        boolean expResult = false;
        boolean result = instance.isNeighbor(v);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteNeighbor method, of class ALVertex.
     */
    @Test
    public void testDeleteNeighbor() {
        System.out.println("deleteNeighbor");
        ALVertex v = null;
        ALVertex instance = null;
        instance.deleteNeighbor(v);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class ALVertex.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        ALVertex instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTime method, of class ALVertex.
     */
    @Test
    public void testGetTime() {
        System.out.println("getTime");
        ALVertex instance = null;
        int expResult = 0;
        int result = instance.getTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEdges method, of class ALVertex.
     */
    @Test
    public void testGetEdges() {
        System.out.println("getEdges");
        ALVertex instance = null;
        List expResult = null;
        List result = instance.getEdges();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class ALVertex.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        ALVertex instance = null;
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
