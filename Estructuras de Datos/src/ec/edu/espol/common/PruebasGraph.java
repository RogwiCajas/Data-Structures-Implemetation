/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.common;

import ec.edu.espol.graph.GraphLA;
import ec.edu.espol.graph.GraphMA;

/**
 *
 * @author rogwi
 */
public class PruebasGraph {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GraphMA<String> ma;
        ma = new GraphMA<>(true);
        ma.addVertex("A");
        ma.addVertex("B");
        ma.addVertex("C");
        ma.addEdge("A", "B", 2);
        ma.addEdge("B", "A", 3);
        ma.addEdge("C", "A", 4);
        ma.addEdge("C", "B", 5);
        System.out.println(ma.toString());
        System.out.print(ma.outDegree("A")+"\n");
        System.out.print(ma.inDegree("A")+"\n");
        //------------------------------
        System.out.println("----------------------------------------------------");
        GraphLA<String> la= new GraphLA<>(true);
        la.addVertex("A");
        la.addVertex("B");
        la.addVertex("C");
        la.addEdge("A", "B", 2);
        la.addEdge("B", "A", 3);
        la.addEdge("C", "A", 4);
        la.addEdge("C", "B", 5);
        System.out.println(la.toString());
        System.out.print(ma.outDegree("A")+"\n");
        System.out.print(ma.inDegree("A")+"\n");
    }
    
}
