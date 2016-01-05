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
        List road = null, r2 = new ArrayList(), foundRoads = new ArrayList();
        Road p = new Road(a);
        double k = 0;
        getRoads(p, a, b, foundRoads);

        for (Object o : foundRoads) {
            Road r = (Road) o;
            if (k == 0 || r.getTime() < k) {
                k = r.getTime();
            }
        }

        for (Object o : foundRoads) {
            if (((Road) o).getTime() == k) {
                road = ((Road) o).getRoad();
                break;
            }
        }
        if (road == null) {
            return null;
        }
        for (int i = road.size()-1; i >=0; i--) {
            r2.add(road.get(i));
        }
        return r2;
    }

    @Override
    public List road(String a, String b, AdjList l) {
        ALVertex va = l.getVertex(a);
        ALVertex vb = l.getVertex(b);
        return road(va, vb, l);
    }

    public void getRoads(Road p, ALVertex a, ALVertex b, List l) {
        Road p2;
        double t;
        for (Object o : a.getEdges()) {
            p2 = new Road(p);
            if (!((ALEdge) o).isTraversable(a)) {
                continue;
            }
            ALVertex v = ((ALEdge) o).getOtherEnd(a);
            if (p.visited(v)) {
                continue;
            }
            if (v.equals(b)) {
                p2.addTime(a.getTime() + ((ALEdge) o).getTime(a));
                l.add(p2);
                continue;
            }
            if (a.equals(p.getStart())) t = ((ALEdge) o).getTime(a);
            else t = a.getTime() + ((ALEdge) o).getTime(a);
            p2.nextStep(v, t);
            getRoads(p2, v, b, l);
        }
    }

}
