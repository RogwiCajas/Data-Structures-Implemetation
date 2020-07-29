/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.common;

import ec.edu.espol.util.ArrayList;
import ec.edu.espol.util.DoublyLinkedList;
import ec.edu.espol.util.SimplyLinkedList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author cajas
 */
public class PruebasIterator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Prueba iterator ArrayList
        ArrayList<Integer> a=new ArrayList<>();
        a.addLast(0);
        a.addLast(1);
        a.addLast(2);
        a.addLast(3);
        
        /*Iterator it=a.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }*/
        ListIterator<Integer> lit= a.listiterator();
        while(lit.hasNext()){
            int n=lit.next();
            if(n==3){
                lit.remove();//remueve el 3
            }
            if(n==0){
                lit.add(10);
            }
        }
        while(lit.hasPrevious()){
            System.out.println(lit.previous());
            
        }
        /*ListIterator<Integer> liti=a.listiterator(2);
        while(liti.hasNext()){
            System.out.println(liti.next());
        }*/
        ///////////////////////////SimplyLinkedList////////////////////////////
        /*
        SimplyLinkedList<Integer> a=new SimplyLinkedList<>();
        a.addLast(0);
        a.addLast(1);
        a.addLast(2);
        a.addLast(3);
        
        Iterator it=a.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        */
       
        
    }
    
}
