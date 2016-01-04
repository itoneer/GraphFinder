/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphfinder;

import graphfinder.adjlist.AdjList;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class GraphFinder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedReader in;
        try {
            in = new BufferedReader(new FileReader(args[1]));
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku źródłowego.");
            return;
        }
        AdjList l = new AdjList();
        try {
            GraphConstructor.makeGraph(l, in);
        } catch (IOException ex) {
            System.out.println("Wystąpił błąd pliku.");
            return;
        }
        List road = new ArrayList();
    }
    
}
