/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.common;

import auxiliar.Paciente;
import ec.edu.espol.util.ArrayList;
import ec.edu.espol.util.CircularDoublyLinkedList;
import ec.edu.espol.util.CircularSimplyLinkedList;
import ec.edu.espol.util.DoublyLinkedList;
import ec.edu.espol.util.SimplyLinkedList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.PriorityBlockingQueue;

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
    
    //Mas metodos relacionados con el manejo de Estructuras de Datos
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
    
    //DEBER
    public static int nCambios(String exp){
        if(exp.length()%2==1){
            return -1;
        }
        int cambios=0;
        Deque<Character> pila=new LinkedList<>();
        for(int i=0;i<exp.length();i++){
            char c=exp.charAt(i);
            if(c=='('){
                pila.push(c);
            }else{
                if(pila.isEmpty()){
                    pila.push('(');
                    cambios++;
                }else{
                    pila.pop();
                }
            }
            
        }        
        
        cambios+=pila.size()/2;
        
        return cambios;    
    }
    
    public static Stack<Integer> eliminarPrimerosK(int[] array, int k){ 
        if(k<0) throw new RuntimeException("negativo");
        Stack<Integer> pila= new Stack<>();
        
        int i=0;
        while(i<array.length){
            if(pila.isEmpty()|| pila.peek()>=array[i]){
                pila.push(array[i++]);
                
            }else{
                if(k>0){
                    pila.pop();
                    k--;
                }else{
                    pila.push(array[i++]);
                }
            }
        }
        return pila;
    }
    
    public static LinkedList<Paciente> atencion(LinkedList<Paciente> pacientes ){
        PriorityQueue<Paciente> cola= new PriorityQueue<>((Paciente p1, Paciente p2 )->p2.getEdad()-p1.getEdad());
        cola.addAll(pacientes);
        LinkedList<Paciente> atendidos=new LinkedList<>();
        
        while(!cola.isEmpty()){//recorremos
            Paciente p=cola.poll();
            if(p.getTiempo()>15){
                p.setTiempo(p.getTiempo()-15);
                cola.offer(p);
                //atendidos.add(p.copy());
            }else{
                p.setTiempo(0);
                //atendidos.add(p.copy());
            }
            atendidos.add(p.copy());
            
        }
        return atendidos;
    }
    
    public static String  simplify(String exp){
        LinkedList<Character> sym = new LinkedList<>();
        sym.add('(');
        sym.add(')');
        sym.add('+');
        sym.add('-');
        
        Stack<String> pila =new Stack<>();
        for(int i=0 ; i<exp.length();i++){
            Character c=exp.charAt(i);
            
            if(c!=')'){
                if(pila.isEmpty()){
                    pila.push(c.toString());//agrego el rpimer elemento
                    
                }else if(!sym.contains(c)){//si no es simbolo
                    if(pila.peek().equals("(")){
                        pila.push("+"+c.toString());
                        
                    }else{//es simbolo
                        String s=pila.pop();
                        pila.push(s+c.toString());
                    }
                }else{//si es simbolo
                    pila.push(c.toString());
                }
                
            }else{
                StringBuilder sb =new StringBuilder();
                String pop;
                do{
                    pop=pila.pop();
                    if(!pop.equals("(")){ //saco  elemntos de la pila hasta halla el parentesis que cierre
                        sb.insert(0, pop);
                    }
                }while(!pop.equals("("));
                pop=pila.pop();
                
                //Valido si cambiar o los signos
                if(pop.equals("+")){
                    pila.push(sb.toString());
                    
                }else{
                    pila.push(cambiarSimbolos(sb.toString()));
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!pila.isEmpty()){
            sb.insert(0,pila.pop());
            
        }
        return sb.toString();
                
                
   }
                
   private static String cambiarSimbolos(String exp){
       StringBuilder sb=new StringBuilder();
       for(int i=0; i<exp.length();i++){
           if(exp.charAt(i)== '+'){
               sb.append('-');
               
           }else if(exp.charAt(i) == '-'){
               sb.append('+');
           }else {
               sb.append(exp.charAt(i));
           }
           
       }
       return sb.toString();
   }
   
   public static void filtrarImpares(Stack<Integer> pila){
       Stack<Integer> pares=new Stack<>();
       
       while(!pila.isEmpty()){//mientras mi pila no este vacia
           Integer num=pila.pop();
           if(num%2==0){//si par lo añado a la pila axu
               pares.push(num);//añado el par
           }
           
       }
       //ahora reordeno 
       while(!pares.isEmpty()){
           Integer num=pares.pop();
           pila.push(num);
       }
   }
   
   public static Integer suma(Queue<Integer> cola){
       int len=cola.size();
       int cont=0;
       int sum=0;
       while(!cola.isEmpty()&& cont<len){
           int e=cola.poll();
           sum+=e;
           cola.offer(e);//se devuelve al final
           cont++;
       }
       return sum;
   }
    
   
    
    
    
    
    
    
    
    
    
    
    
    
}








