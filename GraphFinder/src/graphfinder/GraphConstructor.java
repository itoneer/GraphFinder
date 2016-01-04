/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphfinder;

import graphfinder.adjlist.AdjList;
import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author HP
 */
public class GraphConstructor {
    public static void makeGraph(AdjList l, BufferedReader f) throws IOException,
            IllegalArgumentException {
        String [] in = new String[1];
        in[0] = "";
        while (f.ready() && !in[0].equals("%v")) {
            in = f.readLine().split("\\s+"); 
        }
        while (f.ready() && !in[0].equals("%e")) {
            in = f.readLine().split("\\s+");
            if (!in[0].equals("%e")) l.addVertex(in[0], Integer.parseInt(in[1]));
        } 
        
        if (l.getVertices().isEmpty()) {
                throw new IllegalArgumentException("Brak wierzołków do wczytania.");
        }
        while (f.ready() && !in[0].equals("%r")) {
            in = f.readLine().split("\\s+");
            if (!in[0].equals("%r")) l.addEdge(l.getVertex(in[0]), l.getVertex(in[1]),
                    Boolean.parseBoolean(in[2]), Integer.parseInt(in[3]),
                    Integer.parseInt(in[4]), Integer.parseInt(in[5]));
        }
        
        if (l.getEdges().isEmpty()) {
                throw new IllegalArgumentException("Brak krawędzi do wczytania.");
        }
    }
}
