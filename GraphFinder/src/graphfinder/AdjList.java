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
public class AdjList {
    List vlist;
    
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
