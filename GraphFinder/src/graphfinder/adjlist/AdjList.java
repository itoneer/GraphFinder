/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphfinder.adjlist;

import graphfinder.adjlist.ALVertex;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class AdjList {
    private List vlist;
    
    public AdjList () {
        vlist = new ArrayList();      
    }
    
    public void addVertex(ALVertex v) {
        for (Object o: vlist) {
            ALVertex e = (ALVertex) o;
            if (e.equals(v)) return;
            else vlist.add(v);
        }
    } 
    
    public void addEdge (ALVertex a, ALVertex b, boolean tw, int ln, int s1, int s2) 
    throws IllegalArgumentException {
        if (!(vlist.contains(a)) || !(vlist.contains(b))) {
            throw new IllegalArgumentException("Jeden z podanych wierzczołków nie istnieje.");
        }
        
    }
   
    public boolean areNeighbors (ALVertex a, ALVertex b) {
        return a.isNeighbor(b);
    }
    
    public String listNeighbors (ALVertex v) {
        String out;
        if (!vlist.contains(v)) out = "Podany wirezchołek nie istnieje.";
        else {
            out = "Wierzchołki sąsiadujące z " + v.getName() + " to:\n";
            for (Object o: vlist) {
                if (v.isNeighbor((ALVertex) o)) out = out + ((ALVertex) o).getName() + "\n";   
            }
        }
        return out;
    }

}
