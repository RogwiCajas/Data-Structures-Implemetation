/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.common;

import auxiliar.Mail;
import auxiliar.Paciente;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author cajas
 */
public class EjerciciosListasColasPilasMapas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
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
   /**
    * Dada una lista de palabras l=[a,s,s,s,a,b,d,d], el metodo elimina aquellas que se repitan
    * una despues de otra.
    * 
    * @param lista
    * @return List<String> n=[a,a,b]
    */
   public static List<String> eliminarRepetidas(List<String> lista)
    {
        Stack<String> pila = new Stack<>();
        List<String> nueva = new LinkedList<>();
        for(String palabra : lista){
            if(!pila.isEmpty() && !pila.peek().equals(palabra)){
                String ultima = pila.pop();
                if(!pila.isEmpty() && pila.peek().equals(ultima)){
                    while(!pila.isEmpty() && pila.peek().equals(ultima))
                        pila.pop();
                }
                else
                    pila.push(ultima);
            }
            pila.push(palabra);
        }
        nueva.addAll(pila);
        return nueva;
    }
   /**
    * Recibe una cola de emails y un mapa de dominios restringidos, 
    * Ordena los emails por prioridad y asigana a cada emitente su bandeja de entrada y su bandeja de correo no deseado
    * @param emails
    * @param filtroSpam
    * @return 
    */
    public static Map<String, java.util.ArrayList<LinkedList<Mail>>> distribuirEmails (Queue<Mail> emails, Map<String, Integer> filtroSpam)
    {
        Map<String, java.util.ArrayList<LinkedList<Mail>>> mapa = new HashMap<>();
        PriorityQueue<Mail> importantes = new PriorityQueue<>((Mail m1, Mail m2)->m2.getImportancia()-m1.getImportancia());
        PriorityQueue<Mail> spams = new PriorityQueue<>((Mail m1, Mail m2)->m1.getImportancia()-m2.getImportancia());
        while(!emails.isEmpty())
        {
            Mail m = emails.poll();
            String dominio = m.getRemitente().split("@")[1];
            if(filtroSpam.containsKey(dominio))
            {
                m.setImportancia(filtroSpam.get(dominio));
                spams.offer(m);
            }
            else
                importantes.offer(m);
        }
        while(!importantes.isEmpty())
        {
            Mail m = importantes.poll();
            if(!mapa.containsKey(m.getDestinatario()))
            {
                java.util.ArrayList<LinkedList<Mail>> arraylist = new java.util.ArrayList<>();
                arraylist.add(new LinkedList<>());
                arraylist.add(new LinkedList<>());
                mapa.put(m.getDestinatario(), arraylist);
            }
            mapa.get(m.getDestinatario()).get(0).add(m);
        }
        while(!spams.isEmpty())
        {
            Mail m = spams.poll();
            if(!mapa.containsKey(m.getDestinatario()))
            {
                java.util.ArrayList<LinkedList<Mail>> arraylist = new java.util.ArrayList<>();
                arraylist.add(new LinkedList<>());
                arraylist.add(new LinkedList<>());
                mapa.put(m.getDestinatario(), arraylist);
            }
            mapa.get(m.getDestinatario()).get(1).add(m);
        }
        return mapa;
    }
}
