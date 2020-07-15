/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.common;

import ec.edu.espol.util.DoublyLinkedList;

/**
 *
 * @author cajas
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DoublyLinkedList<Integer> lista= new DoublyLinkedList<>();
        lista.addLast(10);
        lista.addLast(5);
        lista.addLast(10);
        lista.addLast(25);
        lista.addLast(8);
        lista.addLast(10);
        lista.removeAll(10);
        System.out.println(lista.toString());
        
    }
    
}
