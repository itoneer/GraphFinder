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

    public void addDistance(ALVertex a, ALVertex b, double x) {
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
    public double getDist(ALVertex a, ALVertex b) {
        for (int i = 0; i < start.size(); i++) {
            if (((ALVertex) start.get(i)).equals(a)
                    && ((ALVertex) end.get(i)).equals(b) && (double) dist.get(i) != 0) {
                return (double) dist.get(i);
            }
        }
        return -1;
    }

    public double getDist (int x) throws ArrayIndexOutOfBoundsException {
        if (x >= start.size()) throw new ArrayIndexOutOfBoundsException();
        return (double) dist.get(x);
    }

    public boolean isCalculated(ALVertex a, ALVertex b) {
        for (int i = 0; i < start.size(); i++) {
            if (!((ALVertex) start.get(i)).equals(a)
                    || !((ALVertex) end.get(i)).equals(b) || (double) dist.get(i) == 0) {
                continue;
            }
            return true;
        }
        return false;
    }

    /**
     * Finds the closest distance from an end vertex.
     *
     * @param b end vertex
     * @return shortest distance from b, -1 if none are registered
     */
    public double getShortestDistance(ALVertex b) {
        double l = 0;
        for (int i = 0; i < dist.size(); i++) {
            if (((ALVertex) end.get(i)).equals(b)) {
                if (l == 0 || (l > (double) dist.get(i) && (double) dist.get(i) != 0)) {
                    l = (double) dist.get(i);
                }
            }
        }
        return (l != 0 ? l : -1);
    }

    /**
     * Returns starting vertex closest to b.
     *
     * @param b end vertex
     * @return start vertex closest to b, null if none are registered
     */
    public ALVertex getClosestStart(ALVertex b) {
        double s = getShortestDistance(b);
        if (s != -1) {
            for (int i = 0; i < start.size(); i++) {
                if (s == (double) dist.get(i) && (double) dist.get(i) != 0) {
                    return (ALVertex) start.get(i);
                }
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
        dist.add(0.0);
    }

    /**
     * Returns the previous vertex for given end vertex b.
     *
     * @param b end vertex
     * @return starting vertex for b, null if none is registered
     */
    public ALVertex getPrevious(ALVertex b) {
        for (int i = 0; i < start.size(); i++) {
            if ((double) dist.get(i) == 0.0
                    && !((ALVertex) start.get(i)).equals((ALVertex) end.get(i))) {
                return (ALVertex) start.get(i);
            }
        }
        return null;
    }

    /**
     * Returns the end vertex from the shortest found distance.
     *
     * @return end vertex, null if no viable found
     */
    public ALVertex getClosestEnd() {
        double x = 0;
        for (int i = 0; i < start.size(); i++) {
            if (x == 0 || (x > (double) dist.get(i) && (double) dist.get(i) != 0)) {
                x = (double) dist.get(i);
            }
        }

        for (int i = 0; i < start.size(); i++) {
            if ((double) dist.get(i) == x && (double) dist.get(i) != 0) {
                return (ALVertex) end.get(i);
            }
        }
        return null;
    }

    public void clear() {
        start.clear();
        end.clear();
        dist.clear();
    }

}
