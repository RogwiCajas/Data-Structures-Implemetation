/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.common;

import auxiliar.Mail;
import auxiliar.Paciente;
import ec.edu.espol.util.ArrayList;
import ec.edu.espol.util.CircularDoublyLinkedList;
import ec.edu.espol.util.CircularSimplyLinkedList;
import ec.edu.espol.util.DoublyLinkedList;
import ec.edu.espol.util.SimplyLinkedList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.PriorityBlockingQueue;

/**
 *
 * @author cajas
 */
public class PruebasInterfaceList {

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
        /*
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
        */
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
        System.out.println(numeros.contains(100));
        System.out.println(numeros.indexOf(100));
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
        /*
        System.out.println("pruebas Circular doble");
        CircularDoublyLinkedList<Integer> numeros=new CircularDoublyLinkedList<>();
        numeros.addFirst(3);
        numeros.addFirst(2);
        numeros.addFirst(1);
        numeros.addLast(4);
        numeros.addLast(5);
        numeros.addLast(6);
        numeros.addLast(7);
        //prueba itearor
        System.out.println(numeros.toString());
        //System.out.println(numeros.getLast());
        Iterator it=numeros.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
            
        }
        */
        /*System.out.println(numeros.toString());
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
        */
        CircularDoublyLinkedList<Integer> c;
        c = new CircularDoublyLinkedList<>();
        c.addLast(1);
        c.addLast(2);
        c.addLast(3);
        c.addLast(4);
        
        System.out.println(c.toString());
        c.switchFirstandLast();
        System.out.println(c.toString());
        
        /*LinkedList<Integer> A= new LinkedList<>();
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
        
        //EJERCICIO1
        /*System.err.println(nCambios("()"));
        System.err.println(nCambios("))"));
        System.err.println(nCambios("(("));
        System.err.println(nCambios(")("));
        System.err.println(nCambios("))(("));
        System.err.println(nCambios(")(())((("));
        System.err.println(nCambios("((("));
        //EJERCICIO2
        */
        /*int array[]={20,10,25,30,40};
        System.out.println(eliminarPrimerosK(array, 2));*/
        //EJERCICIO3
        /*LinkedList<Paciente> p=new LinkedList<>();
        p.add(new Paciente("Juan", 30, 20));
        p.add(new Paciente("Paula", 45, 65));
        p.add(new Paciente("luisa", 20, 65));
        
        LinkedList<Paciente> atendidos=atencion(p);
        System.out.println(atendidos);
        */
        
        //System.out.println(simplify("a-(b-c)-d-(e-f)"));
        
        /*Stack<Integer> pila=new Stack<>();
        pila.push(6);
        pila.push(1);
        pila.push(2);
        pila.push(4);
        pila.push(3);
        pila.push(5);
        pila.push(6);
        System.out.println(pila);
        filtrarImpares(pila);
        
        System.out.println(pila);
        */
        /*LinkedList l= new LinkedList<>();
        l.addLast(1);
        l.addLast(2);
        l.addLast(3);
        
        Queue<Integer> cola=new LinkedList<>();
        cola.addAll(l);
        System.out.println(cola);
        System.out.println(suma(cola));*/
        
    }
    
}








