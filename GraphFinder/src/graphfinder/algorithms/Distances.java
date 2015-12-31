/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphfinder.algorithms;

import graphfinder.adjlist.ALVertex;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class Distances {

    private final List start;
    private final List end;
    private final List dist;

    public Distances() {
        start = new ArrayList();
        end = new ArrayList();
        dist = new ArrayList();
    }

    public void addDistance(ALVertex a, ALVertex b, int x) {
        start.add(a);
        end.add(b);
        dist.add(x);
    }

    /**
     * Returns distance from vertex a to b, if such has been already calculated.
     *
     * @param a starting vertex
     * @param b end vertex
     * @return distance from a to b if calculated, 0 otherwise.
     */
    public int getDist(ALVertex a, ALVertex b) {
        for (int i = 0; i < start.size(); i++) {
            if (!((ALVertex) start.get(i)).equals(a) || !((ALVertex) end.get(i)).equals(b)) {
                continue;
            } else {
                return (int) dist.get(i);
            }
        }
        return -1;
    }

    public int getDist(int x) {
        return (int) dist.get(x);
    }

    public boolean isCalculated(ALVertex a, ALVertex b) {
        for (int i = 0; i < start.size(); i++) {
            if (!((ALVertex) start.get(i)).equals(a) || !((ALVertex) end.get(i)).equals(b)) {
                continue;
            } else {
                return true;
            }
        }
        return false;
    }

    public void updateDistance(ALVertex a, ALVertex b, int x) {
        for (int i = 0; i < start.size(); i++) {
            if (((ALVertex) start.get(i)).equals(a) || ((ALVertex) end.get(i)).equals(b)) {
                dist.set(i, x);
            }
        }
    }

    public int getShortestDistance(ALVertex b) {
        int l = 0;
        for (int i = 0; i < dist.size(); i++) {
            if (((ALVertex) end.get(i)).equals(b)) {
                if (l == 0 || l > (int) dist.get(i)) {
                    l = (int) dist.get(i);
                }
            }
        }
        return -1;
    }

    public ALVertex getClosest(ALVertex b) {
        int s = getShortestDistance(b);
        for (int i = 0; i < start.size(); i++) {
            if (s == (int) dist.get(i)) {
                return (ALVertex) start.get(i);
            }
        }
        return null;
    }
}
