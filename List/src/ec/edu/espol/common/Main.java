/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.common;

import ec.edu.espol.util.ArrayList;
import ec.edu.espol.util.CircularDoublyLinkedList;
import ec.edu.espol.util.CircularSimplyLinkedList;
import ec.edu.espol.util.DoublyLinkedList;
import ec.edu.espol.util.SimplyLinkedList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author cajas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*System.out.println("Prueba ArrayList");
        ArrayList<Integer> numeros=new ArrayList<>();
        System.out.print(numeros);
        //del 0 al 5
        numeros.addFirst(3);
        numeros.addFirst(2);
        numeros.addFirst(1);
        numeros.addLast(4);
        numeros.addLast(5);
        numeros.addFirst(0);
        
        System.out.println(numeros.toString());
        System.out.println(numeros.removeFirst());
        System.out.println(numeros.toString());
        System.out.println(numeros.removeLast());
        System.out.println(numeros.toString());
        System.out.println(numeros.contains(4));
        System.out.println(numeros.get(0));
        System.out.println(numeros.getFirst());
        System.out.println(numeros.getLast());
        System.out.println(numeros.indexOf(3));
        System.out.println(numeros.insert(1, 22));
        System.out.println(numeros.toString());
        System.out.println(numeros.remove(1));
        System.out.println(numeros.toString());
        System.out.println(numeros.set(2, 35));
        System.out.println(numeros.toString());
        */
        
        /*System.out.println("Prueba ArrayList");
        SimplyLinkedList<Integer> numeros= new SimplyLinkedList<>();
        System.out.print(numeros);
        numeros.addFirst(3);
        numeros.addFirst(2);
        numeros.addFirst(1);
        numeros.addLast(4);
        numeros.addLast(5);
        numeros.addFirst(0);
        
        System.out.println(numeros.toString());
        System.out.println(numeros.removeFirst());
        System.out.println(numeros.toString());
        System.out.println(numeros.removeLast());
        System.out.println(numeros.toString());
        System.out.println(numeros.contains(4));
        System.out.println(numeros.get(0));
        System.out.println(numeros.getFirst());
        System.out.println(numeros.getLast());
        System.out.println(numeros.indexOf(3));
        System.out.println(numeros.insert(1, 22));
        System.out.println(numeros.toString());
        System.out.println(numeros.remove(1));
        System.out.println(numeros.toString());
        System.out.println(numeros.set(2, 35));
        System.out.println(numeros.toString());
        System.out.println(numeros.remove(3));
        System.out.println(numeros.toString());
        */
        
         //doubly
          System.out.println("Prueba DoublyLinkedList");
        DoublyLinkedList<Integer> numeros=new DoublyLinkedList<>();
        System.out.print(numeros);
        numeros.addFirst(3);
        numeros.addFirst(2);
        numeros.addFirst(1);
        numeros.addLast(4);
        numeros.addLast(5);
        numeros.addFirst(0);
        
        System.out.println(numeros.toString());
        System.out.println(numeros.removeFirst());
        System.out.println(numeros.toString());
        System.out.println(numeros.removeLast());
        System.out.println(numeros.toString());
        System.out.println(numeros.contains(4));
        System.out.println(numeros.get(0));
        System.out.println(numeros.getFirst());
        System.out.println(numeros.getLast());
        System.out.println(numeros.indexOf(3));
        System.out.println(numeros.insert(1, 22));
        System.out.println(numeros.toString());
        System.out.println(numeros.remove(1));
        System.out.println(numeros.toString());
        System.out.println(numeros.set(2, 35));
        System.out.println(numeros.toString());
        System.out.println(numeros.remove(3));
        System.out.println(numeros.toString());
        
        //circular Simply
        
        /*
        
        System.out.println("Prueba Circular Simple");
        CircularSimplyLinkedList<Integer> numeros=new CircularSimplyLinkedList<>();
        numeros.addFirst(3);
        numeros.addFirst(2);
        numeros.addFirst(1);
        numeros.addLast(4);
        numeros.addLast(5);
        numeros.addFirst(0);
        
        System.out.println(numeros.toString());
        System.out.println(numeros.removeFirst());
        System.out.println(numeros.toString());
        System.out.println(numeros.removeLast());
        System.out.println(numeros.toString());
        System.out.println(numeros.contains(4));
        System.out.println(numeros.get(0));
        System.out.println(numeros.getFirst());
        System.out.println(numeros.getLast());
        System.out.println(numeros.indexOf(3));
        System.out.println(numeros.insert(1, 22));//
        System.out.println(numeros.insert(5, 5));
        System.out.println(numeros.toString());
        System.out.println(numeros.remove(1));
        System.out.println(numeros.toString());
        System.out.println(numeros.set(2, 35));
        System.out.println(numeros.toString());
        System.out.println(numeros.remove(3));
        System.out.println(numeros.toString());
        */
        //circular doubly
        /*System.out.println("pruebas Circular doble");
        CircularDoublyLinkedList<Integer> numeros=new CircularDoublyLinkedList<>();
        numeros.addFirst(3);
        numeros.addFirst(2);
        numeros.addFirst(1);
        numeros.addLast(4);
        numeros.addLast(5);
        numeros.addLast(6);
        numeros.addLast(7);
        //sera removido
        //cd.addFirst(0);
        
        System.out.println(numeros.toString());
        System.out.println(numeros.removeFirst());
        System.out.println(numeros.toString());
        System.out.println(numeros.removeLast());
        System.out.println(numeros.toString());
        System.out.println(numeros.contains(4));
        System.out.println(numeros.get(0));
        System.out.println(numeros.getFirst());
        System.out.println(numeros.getLast());
        System.out.println(numeros.indexOf(3));
        System.out.println(numeros.insert(1, 22));//
        System.out.println(numeros.insert(6, 15));///insert al fnal
        System.out.println(numeros.toString());
        System.out.println(numeros.remove(1));
        System.out.println(numeros.toString());
        System.out.println(numeros.set(2, 35));
        System.out.println(numeros.toString());
        System.out.println(numeros.remove(3));
        System.out.println(numeros.toString());
        
        */
        /*DoublyLinkedList<Integer> d=new DoublyLinkedList<>();
        d.addLast(10);
        d.addLast(5);
        d.addLast(5);
        d.addLast(10);
        
        System.out.println(d.toString());
        System.out.println(d.esPalindromoRecursivo());
        
        CircularDoublyLinkedList<Integer> c;
        c = new CircularDoublyLinkedList<>();
        c.addLast(10);
        c.addLast(5);
        c.addLast(5);
        c.addLast(10);
        
        System.out.println(c.toString());
        c.switchFirstandLast();
        System.out.println(c.toString());
        
        LinkedList<Integer> A= new LinkedList<>();
        LinkedList<Integer> B= new LinkedList<>();
        A.add(2);
        A.add(3);
        A.add(8);
        A.add(4);
        A.add(1);
        B.add(1);
        B.add(1);
        B.add(3);
        B.add(2);
        B.add(5);
        B.add(6);
        
        LinkedList<Integer> suma=sumaMenores(A, B);
        System.out.print(A.toString());
        System.out.print(B.toString());
        System.out.print(suma.toString());
        
        */
    }
    public static  LinkedList<Integer> sumaMenores(LinkedList<Integer> A, LinkedList<Integer> B){
        //recorro a y recorro b
        LinkedList<Integer> suma=new LinkedList<>();
        Iterator itA=  A.iterator();
        Iterator itB= B.iterator();
        
        while(itA.hasNext()){
            int sum=0;
            int a=(Integer)itA.next();
            while(itB.hasNext()){
                int b= (Integer)itB.next();
                if(b<a){
                    sum+=b;
                }
                else{
                    break;
                }
            }
            itB=B.iterator();//devuelvo al inicio el iteratorb
            suma.add(sum);
            
            
        }
        
        
        return suma;
    }        
    
    
    
    
    
    
}
