/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.util;

import java.util.Iterator;

/**
 *
 * @author cajas
 * @param <E> elemneto
 */
public class SimplyLinkedList <E> implements List<E>, Iterable<E>{
    private Node<E> first;
    private Node<E> last;
    private int current;
    
    public SimplyLinkedList(){
        
        first = last = null;
        current = 0;
        
    }
    
    private class Node<E>{
        private E data;
        private Node<E> next;
        
        public Node(E data){
            this.data=data;
            this.next=null;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
        
    }
    
    @Override
    public boolean addFirst(E e) {
        if(e==null) return false;
        Node<E> n=new Node<>(e);
        if(isEmpty()){
            first = last = n;
        }        
        else{
            n.next=this.first;
            first=n;
        }
        current++;
        return true;
    }

    @Override
    public boolean addLast(E e) {
        if(e==null) return false;
        Node<E> n=new Node<>(e);
        if(isEmpty()){
            first = last = n;
        }
        else{
            last.setNext(n);
            this.last=n;
        }
        current++;
        return true;
    }

    @Override
    public E getFirst() throws NullPointerException{
        if(isEmpty()) throw new NullPointerException("Obteniendo primer elemento de una ista vacía");
        return this.first.getData();
    }

    @Override
    public E getLast() throws NullPointerException{
        if(isEmpty()) throw new NullPointerException("Obteniendo primer elemento de una ista vacía");
        return this.last.getData();
    }

    @Override
    public int indexOf(E e) throws IllegalArgumentException{
        if(e==null ){
            throw new IllegalArgumentException("Argumento no Valido");
        }
        if(!isEmpty()){
            int index=0;
            for(Node<E> p=this.first;p!=null;p=p.getNext()){
                if(p.getData()==e){
                    return index;               
                }
            index++;
            }    
        }
        return -1;
    }

    @Override
    public int size() {
        return this.current;
    }

    @Override
    public boolean removeLast() {
         if(isEmpty()) return false;
         if(first==last){
             last.setData(null);
             first=last=null;          
             
         }else{
             Node<E> p=last;
             last=getPrevious(last);
             p.setData(null);
             last.setNext(null);
         }
         current--;
         return true;
    }

    @Override
    public boolean removeFirst() {
        if(isEmpty()) return false;
        if(first==last){
            first.setData(null);
            first=last=null;            
        }else{
            Node<E> p=first;
            first=first.getNext();
            p.setData(null);
            p.setNext(null);         
        }
        current--;
        return true;
        
    }

    @Override
    public boolean insert(int index, E e) throws IndexOutOfBoundsException{
        if(index<0 || index>this.size()){
            throw new IndexOutOfBoundsException("Index fuera de rango");
        }
        else if(index==0){
            
            return addFirst(e);
        }
        else if(index==(current)){
            
            return addLast(e);
        }
        else{
            //creo un nodo
            Node<E> q= getNode(index-1);//implementar Node <E > nodeIndex(index)
            Node<E> p=q.getNext();
            
            Node<E> node=new Node<>(e);//nodo a insertar
            q.setNext(node);
            node.setNext(p);
            
            current++;
            return true;
        }
        
    }

    @Override
    public boolean set(int index, E e) throws IndexOutOfBoundsException{
        if(index<0 || index>=this.size()){
            throw new IndexOutOfBoundsException("Index fuera de rango");
        }
        getNode(index).setData(e);
        return true;
    }

    @Override
    public boolean isEmpty() {
        if(first==null&&last==null){
            return true;  
        }
        return false;
    }

    @Override
    public E get(int index) {
        return getNode(index).getData();
    }

    @Override
    public boolean contains(E e) throws IllegalArgumentException{
        if(e==null) throw new IllegalArgumentException("Argumento nullo");
        for(Node<E> n=this.first;n!=null;n=n.getNext()){
            if(n.getData().equals(e)) 
                return true;           
        }
        return false;
    }

    @Override
    public boolean remove(int index) throws IndexOutOfBoundsException {
        if(isEmpty()) return false;
        if(index<0 || index>=this.size()){
            throw new IndexOutOfBoundsException("Index fuera de rango");
        }
        else if(index==0){
            removeFirst();
            return true;
        }
        else if(index==size()-1){
            removeLast();
            return true;
        }else{
            Node<E> n=getNode(index);
            getPrevious(n).setNext(n.getNext());//enlazo el anterior al posterior
            n.setData(null);
            n.setNext(null);
            current--;
            return true;
        }
        
    }
    private Node<E> getPrevious(Node<E> p){//lanzar exepcion illegal argument
        if(p==this.first || p==null) return null;
        for(Node<E> q=this.first;q!=null;q=q.getNext()){
            if(q.getNext()==p){
                return q;
            }
        }
        return null;
    }
    private Node<E> getNode(int index) throws IndexOutOfBoundsException{
        if(isEmpty()|| (index<0 || index>=current)){//si esta vacio o el indice no es correcto
            throw new IndexOutOfBoundsException("indice no valido o lista vacia");
            
        }else{
            int contador=0;
            for(Node<E> q=this.first; q!=null;q=q.getNext()){
                if(contador==index){
                    return q;
                }
                contador++;
            }
            return null;
        }
        
        
    }
    
    @Override
    public String toString()
    {
        if(isEmpty()) return "[]\n";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(Node<E> n=this.first;n!=this.last;n=n.getNext()){//hasta el penultimo nodo
            sb.append(n.getData());
            sb.append(",");
        } 
        sb.append(getLast());//agrego el ultimo elemento sin coma
        sb.append("]");
        return sb.toString();
    }
    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {
            private Node<E> p = first;
            @Override
            public boolean hasNext() {
                return p!=null;
            }

            @Override
            public E next() {
                E tmp = p.data;
                p = p.next;
                return tmp;
            }
        };
        return it;
    }
    //@Override
    public void reverse() {
        reverse(0,current-1);
    }
    private void reverse(int start, int end){
       Node<E> inicio =getNode  (start);
       Node<E> fin =getNode(end);
        if(start<end){
             E tmp= inicio.getData();
             E tmp2= fin.getData();
             fin.setData(tmp);
             inicio.setData(tmp2);
            reverse(++start,--end);
        }
    }
     public List<E> slicing(int start, int end) {
       List<E> l= new SimplyLinkedList<>();
       Node<E> inicio =getNode(start);
       Node<E> fin =getNode(end);
       if(start<0 || end<0|| start>=end || start==end)
            return l;
        else 
            for(Node<E> p =inicio;p!=fin;p=p.getNext()){
                E element=p.getData();
                l.addLast(element);
            }
        return l;
    }
    public Iterator<E> iteratorStep(int start, int step){
        if(start>this.size()||start<0) throw new IndexOutOfBoundsException("Indice fuera del rango");
        Iterator<E> it = new Iterator<E>() {           

            Node<E> p = getNode(start);
            
            @Override 
            public boolean hasNext() {
                return p!=null;
            } 

            @Override 

            public E next() {
                Node<E> temp = p;
                int i=0;
                while(i<step && p!=null){
                    p=p.next;
                    i++;
                }
                return temp.data;
            } 

        }; 

        return it; 
    } 
}
