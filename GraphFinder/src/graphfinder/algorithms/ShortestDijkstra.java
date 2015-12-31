/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphfinder.algorithms;

import graphfinder.adjlist.ALEdge;
import graphfinder.adjlist.ALVertex;
import graphfinder.adjlist.AdjList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class ShortestDijkstra implements ShortestRoad {
    @Override
    public List road(ALVertex a, ALVertex b, AdjList l) {
        int nodes = l.getAmountOfNodes();
        int [] length = new int [nodes];
        for (int i = 0; i < nodes; i++) {
            ALVertex v = l.getVertex(i);
            if (v.equals(a)) length[i] = 0;
            else length[i] = -1;
        }
        int ln;
        ALVertex curr = a;
        List visited = new ArrayList();
        visited.add(a);
        List prev = new ArrayList();
        for (int i = 0; i < nodes; i++) {
            prev.add(null);
        }
        while (!curr.equals(b)) {
            for (Object o: visited) {
                ln = length[l.getVertices().indexOf(o)];
                for (Object o2: ((ALVertex) o).getEdges()) {
                    ALVertex v = ((ALEdge) o2).getOtherEnd((ALVertex) o);
                    if (!((ALVertex) o).equals(a)) ln += ((ALVertex) o).getTime();
                    ln += ((ALEdge) o2).getTime((ALVertex) o);
                    if (ln < length[l.getVertices().indexOf(v)] || 
                            (ln > 0 && length[l.getVertices().indexOf(v)] < 0)) 
                            length[l.getVertices().indexOf(v)] = ln;
                }
            }
            ln = length[0];
            for (int i = 0; i < nodes; i++) if (length[i] < ln) ln = length[i];
            for (int i = 0; i < nodes; i++) if (ln == length[i]) {
                ln = i;
                break;  
            }
            visited.add(l.getVertex(ln));
        }
        
        List road = new ArrayList();
        
        return road;
    }

    
}
