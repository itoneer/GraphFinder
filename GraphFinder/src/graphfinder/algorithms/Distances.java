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
            if (((ALVertex) start.get(i)).equals(a)
                    || ((ALVertex) end.get(i)).equals(b)) {
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
                if (l == 0 || (l > (int) dist.get(i) && (int) dist.get(i) != 0)) {
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

    /**
     * Registers vertex a as being previous to vertex b.
     *
     * Requires vertices a and b to be nonequal.
     *
     * @param a previous vertex
     * @param b current vertex
     */
    public void setPrevious(ALVertex a, ALVertex b) {
        if (a.equals(b)) {
            return;
        }
        start.add(a);
        end.add(b);
        dist.add(0);
    }

    public ALVertex getPrevious(ALVertex b) {
        for (int i = 0; i < start.size(); i++) {
            if ((int) dist.get(i) == 0
                    && !((ALVertex) start.get(i)).equals((ALVertex) end.get(i))) {
                return (ALVertex) start.get(i);
            }
        }
        return null;
    }
    
   public ALVertex findClosestFrom(ALVertex s, List a, List b) {
       List left = new ArrayList();
       int c = 0;
       left.addAll(a);
       left.removeAll(b);
       
       for (int i = 0; i < start.size(); i++) {
           if (((ALVertex)start.get(i)).equals(s) && left.contains(end.get(i)) &&
                   (c == 0 || c < (int) dist.get(i)))
               c = (int) dist.get(i);
       }
       
       for (int i = 0; i < start.size(); i++) {
            if (c == (int) dist.get(i)) {
                return (ALVertex) start.get(i);
            }
        }
        return null;
       
   }
}
