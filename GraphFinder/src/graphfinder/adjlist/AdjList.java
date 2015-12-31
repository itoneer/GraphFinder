/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphfinder.adjlist;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class AdjList {
    private final List vlist;
    private final List edges;
    
    public AdjList () {
        vlist = new ArrayList();
        edges = new ArrayList();
    }
    
    public void addVertex(ALVertex v) {
        for (Object o: vlist) {
            ALVertex e = (ALVertex) o;
            if (e.equals(v)) return;
        }
        vlist.add(v);
    } 
    
    public void addVertex (String name, int time) {
        ALVertex v = new ALVertex (name, time);
        addVertex(v);
    }
    
    public ALVertex getVertex (String name) {
        for (Object o: vlist) {
            if (((ALVertex) o).getName().equals(name)) return (ALVertex) o;
        }
        return null;
    }
    
   public ALVertex getVertex (int i) {
       return (ALVertex) vlist.get(i);
   }
    
    public void delVertex (ALVertex v) {
        vlist.stream().filter((o) -> (v.isNeighbor((ALVertex) o))).forEach((o) -> {
            v.deleteNeighbor((ALVertex) o);
        });
        vlist.remove(v);
    }
    
    public void delVertex(String name) {
        ALVertex v = new ALVertex (name, 0);
        delVertex(v);
    }
               
    /**
     * Adds a directed edge between vertices a and b.
     * @param a Source of the edge.
     * @param b Destination of the edge.
     * @param tw Boolean, indicates whether the edge is two-way or not.
     * @param ln Integer, shows the "length" of the edge.
     * @param s1 Integer, shows the "speed" of traversing the edge from a to b.
     * @param s2 Integer, shows the "speed" of ttraversing the edge from b to a.
     * @throws IllegalArgumentException
     */
    public void addEdge (ALVertex a, ALVertex b, boolean tw, int ln, int s1, int s2) 
    throws IllegalArgumentException {
        if (!(vlist.contains(a)) || !(vlist.contains(b))) {
            throw new IllegalArgumentException("Jeden z podanych wierzchołków nie istnieje.");
        }
        ALEdge e = new ALEdge(a, b, tw, ln,  s1, s2);
        if (edges.contains(e)) return;
        a.addNeighbor(e);
        b.addNeighbor(e);
    }
    
    public ALEdge getEdge (ALVertex a, ALVertex b) {
        List e = a.getEdges();
        for (Object o: e) {
            if (((ALEdge) o).end(b)) return (ALEdge) o;
        }
        return null;
    }
    
    public void delEdge(ALVertex a, ALVertex b) throws IllegalArgumentException {
        if (!(vlist.contains(a)) || !(vlist.contains(b))) {
            throw new IllegalArgumentException("Jeden z podanych wierzczołków nie istnieje.");
        }
        a.deleteNeighbor(b);
    }
   
    public boolean areNeighbors (ALVertex a, ALVertex b) {
        return a.isNeighbor(b);
    }
    
    public String listNeighbors (ALVertex v) {
        String out = null;
        if (!vlist.contains(v)) out = "Podany wierzchołek nie istnieje.";
        else {
            for (Object o: vlist) {
                if (v.isNeighbor((ALVertex) o) && !v.equals((ALVertex) o)) {
                    if (out == null) out = "Wierzchołki sąsiadujące z " + v.getName() + " to:\n";
                    out = out + ((ALVertex) o).getName() + "\n";
                }   
            }
        }
        if (out == null) out = "Podany wierzchołek nie posiada sąsiadów.";
        return out;
    }
    
    public boolean isTraversable (ALVertex a, ALVertex b) {
        if (!areNeighbors(a,b)) return false;
        else {
            ALEdge e = a.getNeighbor(b);
            return e.getSource().equals(a) || (e.getSource().equals(b) && e.isTwoWay());
        }
    }
    
    public int getAmountOfNodes() {
        return vlist.size();
    }
    
    public List getVertices() {
        return vlist;
    }
}
