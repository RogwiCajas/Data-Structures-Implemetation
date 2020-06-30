/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.common;

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
        /*SimplyLinkedList<Integer> numeros= new SimplyLinkedList<>();
        numeros.addFirst(3);
        numeros.addFirst(2);
        numeros.addFirst(1);
        numeros.addLast(4);
        numeros.addLast(5);//sera removido
        numeros.addFirst(0);//sera rmovido
        
        System.out.println(numeros.toString());
        System.out.println(numeros.removeFirst());
        System.out.println(numeros.removeLast());
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
        
        //doubly
        DoublyLinkedList<Integer> d=new DoublyLinkedList<>();
        d.addFirst(3);
        d.addFirst(2);
        d.addFirst(1);
        d.addLast(4);
        d.addLast(5);//sera removido
        d.addFirst(0);
        
        System.out.println(d.toString());
        System.out.println(d.removeFirst());
        System.out.println(d.removeLast());
        System.out.println(d.contains(4));
        System.out.println(d.get(0));
        System.out.println(d.getFirst());
        System.out.println(d.getLast());
        System.out.println(d.indexOf(3));
        System.out.println(d.insert(1, 22));
        System.out.println(d.toString());
        System.out.println(d.remove(1));
        System.out.println(d.toString());
        System.out.println(d.set(2, 35));
        
        //circular Simply
        
        CircularSimplyLinkedList<Integer> cs=new CircularSimplyLinkedList<>();
        cs.addFirst(3);
        cs.addFirst(2);
        cs.addFirst(1);
        cs.addLast(4);
        cs.addLast(5);//sera removido
        cs.addFirst(0);
        
        System.out.println(cs.toString());
        System.out.println(cs.removeFirst());
        System.out.println(cs.removeLast());
        System.out.println(cs.contains(4));
        System.out.println(cs.get(0));
        System.out.println(cs.getFirst());
        System.out.println(cs.getLast());
        System.out.println(cs.indexOf(3));
        System.out.println(cs.insert(1, 22));
        System.out.println(cs.toString());
        System.out.println(cs.remove(1));
        System.out.println(cs.toString());
        System.out.println(cs.set(2, 35));
        
        //circular doubly
        
        CircularDoublyLinkedList<Integer> cd=new CircularDoublyLinkedList<>();
        cd.addFirst(3);
        cd.addFirst(2);
        cd.addFirst(1);
        cd.addLast(4);
        cd.addLast(5);//sera removido
        cd.addFirst(0);
        
        System.out.println(cd.toString());
        System.out.println(cd.removeFirst());
        System.out.println(cd.removeLast());
        System.out.println(cd.contains(4));
        System.out.println(cd.get(0));
        System.out.println(cd.getFirst());
        System.out.println(cd.getLast());
        System.out.println(cd.indexOf(3));
        System.out.println(cd.insert(1, 22));
        System.out.println(cd.toString());
        System.out.println(cd.remove(1));
        System.out.println(cd.toString());
        System.out.println(cd.set(2, 35));*/
        DoublyLinkedList<Integer> d=new DoublyLinkedList<>();
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
