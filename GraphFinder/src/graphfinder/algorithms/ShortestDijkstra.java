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
        Distances dist = new Distances();
        Distances r = new Distances();
        dist.addDistance(a, a, 0);
        double ln;
        ALVertex curr = a;
        List visited = new ArrayList();
        visited.add(a);
        List prev = new ArrayList();
        for (int i = 0; i < nodes; i++) {
            prev.add(null);
        }
        while (!curr.equals(b)) {
            for (Object o : visited) {
                ln = r.getDist(a, (ALVertex) o);
                if (ln == -1) {
                    throw new IllegalArgumentException();
                }
                for (Object o2 : ((ALVertex) o).getEdges()) {
                    ALVertex v = ((ALEdge) o2).getOtherEnd((ALVertex) o);
                    if (visited.contains(v) || !l.isTraversable((ALVertex) o, v)) {
                        continue;
                    }
                    if (!((ALVertex) o).equals(a)) {
                        ln += ((ALVertex) o).getTime();
                    }
                    ln += ((ALEdge) o2).getTime((ALVertex) o);
                    dist.addDistance((ALVertex) o, v, ln);
                }
            }
            curr = dist.getClosestEnd();
            visited.add(curr);
            r.addDistance(a, curr, dist.getDist(dist.getPrevious(curr),
                            curr));
            dist.clear();
        }
        List road = new ArrayList();
        while (!curr.equals(a)) {       //TODO
            road.add(r.getPrevious(curr));
            curr = r.getPrevious(curr);
        }

        return road;
    }

}
