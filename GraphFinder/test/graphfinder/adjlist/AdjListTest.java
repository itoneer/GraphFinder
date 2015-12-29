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
public class AdjListTest {
    
    public AdjListTest() {
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
     * Test of addVertex method, of class AdjList.
     */
    @Test
    public void testAddVertex_ALVertex() {
        System.out.println("addVertex");
        ALVertex v = new ALVertex("A", 10);
        AdjList instance = new AdjList();
        instance.addVertex(v);
        if (instance.getVertex("A") == null) fail ("Vertex not found");
    }

    /**
     * Test of addVertex method, of class AdjList.
     */
    @Test
    public void testAddVertex_String_int() {
        System.out.println("addVertex");
        String name = "A";
        int time = 0;
        AdjList instance = new AdjList();
        instance.addVertex(name, time);
        if (instance.getVertex("A") == null) fail ("Vertex not found");
    }

    /**
     * Test of getVertex method, of class AdjList.
     */
    @Test
    public void testGetVertex() {
        System.out.println("getVertex");
        ALVertex v = new ALVertex("A", 10); 
        AdjList instance = new AdjList();
        instance.addVertex(v);
        ALVertex expResult = v;
        ALVertex result = instance.getVertex("A");
        assertEquals(expResult, result);
    }

    /**
     * Test of delVertex method, of class AdjList.
     */
    @Test
    public void testDelVertex_ALVertex() {
        System.out.println("delVertex");
        ALVertex v = null;
        AdjList instance = new AdjList();
        instance.delVertex(v);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delVertex method, of class AdjList.
     */
    @Test
    public void testDelVertex_String() {
        System.out.println("delVertex");
        String name = "";
        AdjList instance = new AdjList();
        instance.delVertex(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addEdge method, of class AdjList.
     */
    @Test
    public void testAddEdge() {
        System.out.println("addEdge");
        ALVertex a = null;
        ALVertex b = null;
        boolean tw = false;
        int ln = 0;
        int s1 = 0;
        int s2 = 0;
        AdjList instance = new AdjList();
        instance.addEdge(a, b, tw, ln, s1, s2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEdge method, of class AdjList.
     */
    @Test
    public void testGetEdge() {
        System.out.println("getEdge");
        ALVertex a = null;
        ALVertex b = null;
        AdjList instance = new AdjList();
        ALEdge expResult = null;
        ALEdge result = instance.getEdge(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delEdge method, of class AdjList.
     */
    @Test
    public void testDelEdge() {
        System.out.println("delEdge");
        ALVertex a = null;
        ALVertex b = null;
        AdjList instance = new AdjList();
        instance.delEdge(a, b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of areNeighbors method, of class AdjList.
     */
    @Test
    public void testAreNeighbors() {
        System.out.println("areNeighbors");
        ALVertex a = null;
        ALVertex b = null;
        AdjList instance = new AdjList();
        boolean expResult = false;
        boolean result = instance.areNeighbors(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listNeighbors method, of class AdjList.
     */
    @Test
    public void testListNeighbors() {
        System.out.println("listNeighbors");
        ALVertex v = null;
        AdjList instance = new AdjList();
        String expResult = "";
        String result = instance.listNeighbors(v);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
