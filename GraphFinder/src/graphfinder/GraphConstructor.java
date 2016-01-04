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
    public static void makeGraph(AdjList l, BufferedReader f) throws IOException {
        String [] in = new String[1];
        while (f.ready() || ( in.length == 1 && !in[0].equals("%v"))) {
            in = f.readLine().split("\\s+"); 
        }
       
        do {
            in = f.readLine().split("\\s+");
            l.addVertex(in[0], Integer.parseInt(in[1]));
        } while (f.ready() || (in.length == 1 && !in[0].equals("%e")));
        
        do {
            in = f.readLine().split("\\s+");
            l.addEdge(l.getVertex(in[0]), l.getVertex(in[1]),
                    Boolean.getBoolean(in[2]), Integer.parseInt(in[3]),
                    Integer.parseInt(in[4]), Integer.parseInt(in[5]));
        } while (f.ready() || (in.length == 1 && !in[0].equals("%r")));
    }
}
