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
        ALVertex v = new ALVertex ("A", 10);
        AdjList instance = new AdjList();
        instance.addVertex(v);
        if(instance.getVertex("A") == null) fail();
        instance.delVertex(v);
        if (instance.getVertex("A") != null) fail("Element still exists");
    }

    /**
     * Test of delVertex method, of class AdjList.
     */
    @Test
    public void testDelVertex_String() {
        System.out.println("delVertex");
        ALVertex v = new ALVertex ("A", 10);
        AdjList instance = new AdjList();
        instance.addVertex(v);
        if(instance.getVertex("A") == null) fail();
        instance.delVertex("A");
        if (instance.getVertex("A") != null) fail("Element still exists");
    }

    /**
     * Test of addEdge method, of class AdjList.
     */
    @Test
    public void testAddEdge() {
        System.out.println("addEdge");
        ALVertex a = new ALVertex("A", 5);
        ALVertex b = new ALVertex("B", 2);
        boolean tw = false;
        int ln = 5;
        int s1 = 7;
        int s2 = 0;
        AdjList instance = new AdjList();
        instance.addVertex(a);
        instance.addVertex(b);
        instance.addEdge(a, b, tw, ln, s1, s2);
        if(!a.isNeighbor(b)) fail("Edge does not exist");
    }

    /**
     * Test of getEdge method, of class AdjList.
     */
    @Test
    public void testGetEdge() {
        System.out.println("getEdge");
        ALVertex a = new ALVertex("A", 5);
        ALVertex b = new ALVertex("B", 2);
        AdjList instance = new AdjList();
        instance.addVertex(a);
        instance.addVertex(b);
        instance.addEdge(a, b, false, 17, 5, 0);
        ALEdge expResult = (ALEdge) a.getEdges().get(0);
        ALEdge result = instance.getEdge(a,b);
        assertEquals(expResult, result);
    }

    /**
     * Test of delEdge method, of class AdjList.
     */
    @Test
    public void testDelEdge() {
        System.out.println("delEdge");
        ALVertex a = new ALVertex("A", 5);
        ALVertex b = new ALVertex("B", 2);
        AdjList instance = new AdjList();
        instance.addVertex(a);
        instance.addVertex(b);
        instance.addEdge(a, b, false, 17, 5, 0);
        instance.delEdge(a, b);
        if(a.isNeighbor(b)) fail("Edge not deleted");
    }

    /**
     * Test of areNeighbors method, of class AdjList.
     */
    @Test
    public void testAreNeighbors() {
        System.out.println("areNeighbors");
        ALVertex a = new ALVertex("A", 5);
        ALVertex b = new ALVertex("B", 2);
        AdjList instance = new AdjList();
        instance.addVertex(a);
        instance.addVertex(b);
        instance.addEdge(a, b, false, 17, 5, 0);
        boolean exp1 = true;
        boolean r1 = instance.areNeighbors(a, b);
        assertEquals(exp1, r1);
        ALVertex c = new ALVertex("C", 6);
        instance.addVertex(c);
        boolean exp2 = false;
        boolean r2 = instance.areNeighbors(a, c);
        assertEquals(exp2, r2);
    }

    /**
     * Test of listNeighbors method, of class AdjList.
     */
    @Test
    public void testListNeighbors() {
        System.out.println("listNeighbors");
        ALVertex a = new ALVertex("A", 5);
        ALVertex b = new ALVertex("B", 2);
        AdjList instance = new AdjList();
        instance.addVertex(a);
        instance.addVertex(b);
        instance.addEdge(a, b, false, 17, 5, 0);
        ALVertex c = new ALVertex("C", 6);
        ALVertex d = new ALVertex("D", 12);
        instance.addVertex(c);
        System.out.println(instance.listNeighbors(a));
        System.out.println(instance.listNeighbors(c));
        System.out.println(instance.listNeighbors(d));
    }
    
}
