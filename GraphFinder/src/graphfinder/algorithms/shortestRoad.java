/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphfinder.algorithms;

import graphfinder.adjlist.ALVertex;
import graphfinder.adjlist.AdjList;
import java.util.List;

/**
 *
 * @author HP
 */
public interface ShortestRoad {
    public List road(ALVertex a, ALVertex b, AdjList l);   
    public List road(String a, String b, AdjList l);
}
