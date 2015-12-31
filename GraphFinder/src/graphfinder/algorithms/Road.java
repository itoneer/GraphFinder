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
    List road;
    int time;
    
    public Road(List road, int time) {
        this.road = road;
        this.time = time;
    }
    
    public Road (ALVertex v) {
        road = new ArrayList();
        road.add(v);
        time = 0;
    }
    
    public List getRoad () {
        return road;
    }
    
    public void nextStep (ALVertex v, int t) {
        road.add(v);
        time += t;
    }
    
    @Override
    public String toString() {
        String r = "Droga: ";
        for (Object o: road) {
            r = r + o.toString() + "-";
        }
        r = r + ".\n";
        return r;
    }
}
