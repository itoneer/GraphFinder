/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphfinder.algorithms;

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
        List queue = new ArrayList();
        
        

    }

    
}
