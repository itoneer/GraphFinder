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
public class Road {

    private final List road;
    private double time;

    public Road(List road, double time) {
        this.road = road;
        this.time = time;
    }

    public Road(ALVertex v) {
        road = new ArrayList();
        road.add(v);
        time = 0;
    }
    
    public Road (Road r) {
        road = new ArrayList();
        road.addAll(r.getRoad());
        time = r.getTime();
    }

    public List getRoad() {
        return road;
    }
    
    public ALVertex getStart() {
        return (ALVertex) road.get(0);
    }

    public void nextStep(ALVertex v, double t) {
        road.add(v);
        time += t;
    }
    
    public void addTime(double t) {
        time += t;
    }
    
    public boolean visited (ALVertex v) {
        return road.contains(v);
    }
    
    public double getTime() {
        return time;
    }

    @Override
    public String toString() {
        String r = "Droga: ";
        for (Object o : road) {
            r = r + o.toString() + "-";
        }
        r = r + ".\n";
        return r;
    }
}
