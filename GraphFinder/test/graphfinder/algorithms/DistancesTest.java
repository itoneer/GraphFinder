/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphfinder.algorithms;

import graphfinder.adjlist.ALVertex;
import graphfinder.adjlist.AdjList;
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
public class DistancesTest {
    
    public DistancesTest() {
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
     * Test of addDistance method, of class Distances.
     */
    @Test
    public void testAddDistance() {
        System.out.println("addDistance");
        ALVertex a = new ALVertex("A", 5);
        ALVertex b = new ALVertex("B", 2);
        boolean tw = false;
        int ln = 5;
        int s1 = 5;
        int s2 = 0;
        AdjList l = new AdjList();
        l.addVertex(a);
        l.addVertex(b);
        l.addEdge(a, b, tw, ln, s1, s2);
        Distances instance = new Distances();
        instance.addDistance(a, b, a.getNeighbor(b).getTime(a));
        System.out.println(instance.getDist(a, b));
    }

    /**
     * Test of getDist method, of class Distances.
     */
    @Test
    public void testGetDist_ALVertex_ALVertex() {
        System.out.println("getDist");
        ALVertex a = new ALVertex("A", 5);
        ALVertex b = new ALVertex("B", 2);
        AdjList l = new AdjList();
        l.addVertex(a);
        l.addVertex(b);
        l.addEdge(a, b, false, 5, 10, 0);
        Distances instance = new Distances();
        instance.addDistance(a, b, a.getNeighbor(b).getTime(a));
        double expResult = 0.5;
        double result = instance.getDist(a, b);
        assertEquals(expResult, result, 0);
    }

    /**
     * Test of getDist method, of class Distances.
     */
    @Test
    public void testGetDist_int() {
        System.out.println("getDist");
        int x = 2;
        ALVertex a = new ALVertex("A", 5);
        ALVertex b = new ALVertex("B", 2);
        ALVertex c = new ALVertex("C", 4);
        AdjList l = new AdjList();
        l.addVertex(a);
        l.addVertex(b);
        l.addVertex(c);
        l.addEdge(a, b, false, 5, 10, 0);
        l.addEdge(a, c, true, 25, 10, 5);
        Distances instance = new Distances();
        instance.addDistance(a, b, a.getNeighbor(b).getTime(a));
        instance.addDistance(a, c, a.getNeighbor(c).getTime(a));
        instance.addDistance(a, c, a.getNeighbor(c).getTime(c));
        double expResult = 5;
        double result = instance.getDist(x);
        assertEquals(expResult, result, 0);
    }

    /**
     * Test of isCalculated method, of class Distances.
     */
    @Test
    public void testIsCalculated() {
        System.out.println("isCalculated");
        ALVertex a = new ALVertex("A", 5);
        ALVertex b = new ALVertex("B", 2);
        ALVertex c = new ALVertex("C", 4);
        AdjList l = new AdjList();
        l.addVertex(a);
        l.addVertex(b);
        l.addVertex(c);
        l.addEdge(a, b, false, 5, 10, 0);
        Distances instance = new Distances();
        instance.addDistance(a, b, a.getNeighbor(b).getTime(a));
        boolean expResult = true;
        boolean result = instance.isCalculated(a, b);
        assertEquals(expResult, result);
        expResult = false;
        result = instance.isCalculated(a, c);
        assertEquals(expResult, result);
    }

    /**
     * Test of getShortestDistance method, of class Distances.
     */
    @Test
    public void testGetShortestDistance() {
        System.out.println("getShortestDistance");
        ALVertex a = new ALVertex("A", 5);
        ALVertex b = new ALVertex("B", 2);
        ALVertex c = new ALVertex("C", 4);
        AdjList l = new AdjList();
        l.addVertex(a);
        l.addVertex(b);
        l.addVertex(c);
        l.addEdge(a, b, false, 5, 10, 0);
        l.addEdge(a, c, true, 25, 10, 5);
        l.addEdge(b, c, true, 5, 20, 20);
        Distances instance = new Distances();
        instance.addDistance(a, b, a.getNeighbor(b).getTime(a));
        instance.addDistance(a, c, a.getNeighbor(c).getTime(a));
        instance.addDistance(a, c, a.getNeighbor(c).getTime(c));
        instance.addDistance(b, c, b.getNeighbor(c).getTime(b));
        double expResult = 0.25;
        double result = instance.getShortestDistance(c);
        assertEquals(expResult, result, 0);
    }

    /**
     * Test of getClosestStart method, of class Distances.
     */
    @Test
    public void testGetClosestStart() {
        System.out.println("getClosestStart");
        ALVertex a = new ALVertex("A", 5);
        ALVertex b = new ALVertex("B", 2);
        ALVertex c = new ALVertex("C", 4);
        AdjList l = new AdjList();
        l.addVertex(a);
        l.addVertex(b);
        l.addVertex(c);
        l.addEdge(a, b, false, 5, 10, 0);
        l.addEdge(a, c, true, 25, 10, 5);
        l.addEdge(b, c, true, 5, 20, 20);
        Distances instance = new Distances();
        instance.addDistance(a, b, a.getNeighbor(b).getTime(a));
        instance.addDistance(a, c, a.getNeighbor(c).getTime(a));
        instance.addDistance(a, c, a.getNeighbor(c).getTime(c));
        instance.addDistance(b, c, b.getNeighbor(c).getTime(b));
        instance.addDistance(b, c, b.getNeighbor(c).getTime(c));
        ALVertex expResult = b;
        ALVertex result = instance.getClosestStart(c);
        assertEquals(expResult, result);
    }

    /**
     * Test of setPrevious method, of class Distances.
     */
    @Test
    public void testSetPrevious() {
        System.out.println("setPrevious");
        ALVertex a = new ALVertex("A", 5);
        ALVertex b = new ALVertex("B", 2);
        AdjList l = new AdjList();
        l.addVertex(a);
        l.addVertex(b);
        l.addEdge(a, b, false, 5, 10, 0);
        Distances instance = new Distances();
        instance.setPrevious(a, b);
    }

    /**
     * Test of getPrevious method, of class Distances.
     */
    @Test
    public void testGetPrevious() {
        System.out.println("getPrevious");
        ALVertex a = new ALVertex("A", 5);
        ALVertex b = new ALVertex("B", 2);
        AdjList l = new AdjList();
        l.addVertex(a);
        l.addVertex(b);
        l.addEdge(a, b, false, 5, 10, 0);
        Distances instance = new Distances();
        instance.setPrevious(a, b);
        ALVertex expResult = a;
        ALVertex result = instance.getPrevious(b);
        assertEquals(expResult, result);
    }

    /**
     * Test of getClosestEnd method, of class Distances.
     */
    @Test
    public void testGetClosestEnd() {
        System.out.println("getClosestEnd");ALVertex a = new ALVertex("A", 5);
        ALVertex b = new ALVertex("B", 2);
        ALVertex c = new ALVertex("C", 4);
        AdjList l = new AdjList();
        l.addVertex(a);
        l.addVertex(b);
        l.addVertex(c);
        l.addEdge(a, b, false, 5, 10, 0);
        l.addEdge(a, c, true, 25, 10, 5);
        l.addEdge(b, c, true, 5, 20, 20);
        Distances instance = new Distances();
        instance.addDistance(a, b, a.getNeighbor(b).getTime(a));
        instance.addDistance(a, c, a.getNeighbor(c).getTime(a));
        instance.addDistance(a, c, a.getNeighbor(c).getTime(c));
        instance.addDistance(b, c, b.getNeighbor(c).getTime(b));
        instance.addDistance(b, c, b.getNeighbor(c).getTime(c));
        ALVertex expResult = c;
        ALVertex result = instance.getClosestEnd();
        assertEquals(expResult, result);
    }

    /**
     * Test of clear method, of class Distances.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        ALVertex a = new ALVertex("A", 5);
        ALVertex b = new ALVertex("B", 2);
        ALVertex c = new ALVertex("C", 4);
        AdjList l = new AdjList();
        l.addVertex(a);
        l.addVertex(b);
        l.addVertex(c);
        l.addEdge(a, b, false, 5, 10, 0);
        l.addEdge(a, c, true, 25, 10, 5);
        l.addEdge(b, c, true, 5, 20, 20);
        Distances instance = new Distances();
        instance.addDistance(a, b, a.getNeighbor(b).getTime(a));
        instance.addDistance(a, c, a.getNeighbor(c).getTime(a));
        instance.addDistance(a, c, a.getNeighbor(c).getTime(c));
        instance.addDistance(b, c, b.getNeighbor(c).getTime(b));
        instance.addDistance(b, c, b.getNeighbor(c).getTime(c));
        instance.clear();
        if (instance.isCalculated(a, b)) fail("Distances not cleared");
    }
    
}
