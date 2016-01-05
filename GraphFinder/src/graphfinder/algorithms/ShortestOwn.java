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
public class ShortestOwn implements ShortestRoad {

    @Override
    public List road(ALVertex a, ALVertex b, AdjList l) {
        List road = null;
        List foundRoads = new ArrayList();
        double k = 0;
        getRoads(null, a, b, foundRoads);

        for (Object o : foundRoads) {
            Road r = (Road) o;
            if (k == 0 || r.getTime() < k) {
                k = r.getTime();
            }
        }

        for (Object o : foundRoads) {
            if (((Road) o).getTime() == k) {
                road = ((Road)o).getRoad();
                break;
            }
        }
        return road;
    }

    @Override
    public List road(String a, String b, AdjList l) {
        ALVertex va = l.getVertex(a);
        ALVertex vb = l.getVertex(b);
        return road(va, vb, l);
    }

    public void getRoads(Road p, ALVertex a, ALVertex b, List l) {
        if (a.equals(b)) {
            p.nextStep(a, 0.0);
            l.add(p);
            return;
        }
        double t;
        for (Object o : a.getEdges()) {
            if (!((ALEdge) o).isTraversable(a)) {
                continue;
            }
            ALVertex v = ((ALEdge) o).getOtherEnd(a);
            if (p != null && p.visited(v)) continue;
            t = a.getTime() + ((ALEdge) o).getTime(a);
            if (p != null) p.nextStep(a, t);
            else {
                List ls = new ArrayList();
                ls.add(a);
                p = new Road(ls, 0);
            }
            getRoads(p, v, b, l);
        }
    }

}
