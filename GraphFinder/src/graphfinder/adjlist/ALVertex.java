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
public class ALVertex {
    private final String name;
    private final List edges;
    private final int transTime;
    
    public ALVertex (String name, int transit) {
        this.name = name;
        transTime = transit;
        edges = new ArrayList();
    }
    
    public void addNeighbor (ALVertex v, boolean s, boolean tw, int ln, int s1, int s2) 
    throws IllegalArgumentException {
        ALEdge e;
        if (tw && s2 == 0){
            throw new IllegalArgumentException("Zerowa prędkość powrotna przy"
                    + "drodze dwukierunkowej.");
        }
        if (s || tw) e = new ALEdge (this, v, tw, ln, s1, s2);
        else e = new ALEdge(v, this, tw, ln, s1, s2);
        if(edges.contains(e)) {
            System.out.println("Ta krawędź jest już zdefiniowana.");
            return;
        }
        edges.add(e);
        v.addNeighbor(e);
    }
    
    public void addNeighbor (ALEdge e) {
        if(edges.contains(e)) {
            System.out.println("Ta krawędź jest już zdefiniowana.");
            return;
        }
        edges.add(e);
    }
    
    boolean isNeighbor (ALVertex v) {
        return edges.stream().anyMatch((o) ->(((ALEdge) o).end(v)));
    }
    
    public void deleteNeighbor(ALVertex v) {
        if(!isNeighbor(v)) return;
        for (Object o: edges) {
            ALEdge e = (ALEdge) o;
            if (e.end(v)) {
                edges.remove(o);
                v.deleteNeighbor(this);
            }
            break;
        }
    }
    
    public String getName () {
        return name;
    }
    
    public int getTime() {
        return transTime;
    }
    
    public List getEdges() {
        return edges;
    }
    
    @Override
    public boolean equals (Object o) {
        if (!(o instanceof ALVertex)) return false;
        else return name.equals(((ALVertex) o).getName());
    }
    
    
}
