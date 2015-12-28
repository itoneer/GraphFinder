/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphfinder;

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
    
    public void addNeighbor (ALVertex v, boolean s, boolean tw, int ln, int s1, int s2) {
        ALEdge e;
        if (s || tw) e = new ALEdge (this, v, tw, ln, s1, s2);
        else e = new ALEdge(v, this, tw, ln, s1, s2);
        edges.add(e);
    }
    
    public boolean isNeighbor (ALVertex v) {
        for (Object o : edges) {
            ALEdge e = (ALEdge) o;
            if (e.getSource().getName().equals(v.getName()) ||
                    e.getDest().getName().equals(v.getName()))
                return true;
        }
        return false;
    }
    
    public String getName () {
        return name;
    }
    
}
