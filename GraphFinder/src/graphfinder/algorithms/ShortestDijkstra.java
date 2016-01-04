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
        Distances dist = new Distances();
        Distances r = new Distances();
        r.addDistance(a, a, 0);
        double ln, lno;
        ALVertex curr = a;
        List visited = new ArrayList();
        visited.add(a);
        while (!curr.equals(b)) {
            for (Object o : visited) {   //dla każdego już odwiedzonego wierzchołka
                lno = r.getDist(a, (ALVertex) o);
                if (lno == -1) {
                    throw new IllegalArgumentException();
                }
                for (Object o2 : ((ALVertex) o).getEdges()) { //dla wszystkich wierzch.
                    ln = lno;                                 //do których da się stąd dojść
                    ALVertex v = ((ALEdge) o2).getOtherEnd((ALVertex) o);
                    if (visited.contains(v) || !l.isTraversable((ALVertex) o, v)) {
                        continue;
                    }
                    if (!((ALVertex) o).equals(a)) {
                        ln += ((ALVertex) o).getTime(); //jeżeli badany wierzch. nie jest
                    }                                   //startowy, dodajemy czas przejazdu
                    ln += ((ALEdge) o2).getTime((ALVertex) o);
                    dist.addDistance(a, v, ln);
                    dist.addDistance((ALVertex) o, v, ((ALEdge) o2).getTime((ALVertex) o));
                }
            }
            curr = dist.getClosestEnd();
            r.setPrevious(dist.getClosestStart(curr), curr);
            visited.add(curr);
            r.addDistance(a, curr, dist.getDist(r.getPrevious(curr),
                    curr));
            dist.clear();
        }
        List road = new ArrayList();
        while (!curr.equals(a)) {       //TODO
            road.add(r.getPrevious(curr));
            curr = r.getPrevious(curr);
            if (curr == null) break;
        }

        return road;
    }

    @Override
    public List road(String a, String b, AdjList l) {
        ALVertex va = l.getVertex(a);
        ALVertex vb = l.getVertex(b);
        return road(va, vb, l);
    }
}
