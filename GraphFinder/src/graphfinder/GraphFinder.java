/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphfinder;

import graphfinder.adjlist.ALVertex;
import graphfinder.adjlist.AdjList;
import graphfinder.algorithms.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class GraphFinder {

    /**
     * @param args the comsmand line arguments
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("GraphFinder - wyszukiwanie najkrótszej drogi w grafie");
            System.out.println("Działanie:");
            System.out.println("GraphFinder [plik_wej] <-d|-s>");
            System.out.println("-d - wyszukiwanie algorytmem Dijkstry (domyślnie)");
            System.out.println("-s - wyszukiwanie algorytmem własnym");
            return;
        }
        BufferedReader in;
        try {
            in = new BufferedReader(new FileReader(args[0]));
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku źródłowego.");
            return;
        }
        AdjList l = new AdjList();
        try {
            GraphConstructor.makeGraph(l, in);
        } catch (IOException e) {
            System.out.println("Wystąpił błąd pliku.");
            return;
        }
        List road;
        ShortestRoad d;
        if (args[1].equals("-s") || args[1].equals("-S"))
            d = new ShortestOwn();
        else if (args.length == 1 || args[1].equals("-d") || args[1].equals("-D"))
            d = new ShortestDijkstra();
        else {
            System.out.println("GraphFinder - wyszukiwanie najkrótszej drogi w grafie");
            System.out.println("Działanie:");
            System.out.println("GraphFinder [plik_wej] <-d|-s>");
            System.out.println("-d - wyszukiwanie algorytmem Dijkstry (domyślnie)");
            System.out.println("-s - wyszukiwanie algorytmem własnym");
            return;
        }
        String [] se;
        
        try {
            se = in.readLine().split("\\s+");
            in.close();
        } catch (IOException e) {
            System.out.println("Wystąpił błąd pliku.");
            return;
        } catch (IllegalArgumentException e) {
            return;
        }
        road = d.road(se[0], se[1], l);
        String out = "";
        System.out.print("Najkrótsza droga z " + se[0] + " do " + se[1] + " to: ");
        for(int i = road.size()-1; i >= 0; i--) {
            out = out + ((ALVertex) road.get(i)).getName() + "-";
        }
        out = out + se[1];
        System.out.println(out);
        
    }
    
}
