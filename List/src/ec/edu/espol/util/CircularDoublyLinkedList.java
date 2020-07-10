/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.util;

import java.util.Iterator;
import java.util.ListIterator;

/**
 *
 * @author cajas
 */
public class CircularDoublyLinkedList <E> implements List<E> {
    //private Node<E> first;
    private Node<E> last;
    private int efectivo;

    public CircularDoublyLinkedList() {
        efectivo=0;
        last=null;
    }

    
    private class Node<E>{
        private E data;
        private Node<E> next;
        private Node<E> previous;
        
        public Node(E data){
            this.data=data;
            this.next=null;
        }

        public Node<E> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<E> previous) {
            this.previous = previous;
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
    public boolean contains(E element) {
        if(isEmpty()|| element==null){
            return false;
        }else{
            int contador=0;
            for(Node<E> q=last.next;contador<efectivo;q=q.getNext()){
                if(q.getData()==element){
                    return true;
                }
                contador++;
                
            }
        }
        return false;
    }

    @Override
    public int size() {
        return efectivo;
    }

    
    @Override
    public boolean addLast(E e) {
        Node<E> n = new Node<>(e);
        if(isEmpty()){
            last = n;
            last.next = last;
            last.previous=last;
        }
        else
        {
            n.next = last.next;
            last.next.setPrevious(n);
            last.next = n;
            n.previous=last;
            last = n;
        }
        efectivo++;
        return true;
    }

    @Override
    public boolean addFirst(E e) {
        Node<E> n=new Node<>(e);
        if(isEmpty()){ 
            last= n;
            last.next=last;
            last.previous=last;
        }else{
            Node<E> first=last.next;
            last.next=n;
            n.next=first;
            first.previous=n;
            n.previous=last;
            
        }
        efectivo++;
        return true;
            
    }
    @Override
    public boolean removeLast() throws NullPointerException{
        if(isEmpty()) throw  new NullPointerException();
        else if(efectivo==1){
            last.setData(null);
            last.setNext(null);
            last.setPrevious(null);
            
        }else{
            Node<E> n=last.previous;//capturo referencia al nuevo last;
            n.next=last.next;//enla<o con el primero
            last.next.setPrevious(n);
            last.setData(null);
            last.setNext(null);
            last.setPrevious(null);
            last=n;
        }
        efectivo--;
        return true;
    }

    @Override
    public boolean removeFirst() throws NullPointerException{
        if(isEmpty()) throw  new NullPointerException();
        else if(efectivo==1){
            last.setData(null);
            last.setNext(null);
            last.setPrevious(null);
        }else{
            Node<E> nuevoFirst=last.next.next;
            //elimino al first
            last.next.setData(null);
            last.next.setNext(null);
            last.next.setPrevious(null);
            //creo nuevas conexiones
            last.next=nuevoFirst;
            nuevoFirst.previous=last;
            
            
            
        }
        efectivo--;
        return true;
    }

    @Override
    public E getFirst() throws NullPointerException{
        if(isEmpty()){
            throw new NullPointerException();
        }
        else
        {
            return last.next.getData();
        }
    }

    @Override
    public E getLast() throws NullPointerException{
        if(isEmpty()){
            throw new NullPointerException();
        }
        else
        {
            return last.getData();
        }
        
    }
    private Node<E> getNode(int index) throws IndexOutOfBoundsException{
        if(isEmpty()|| (index<0 || index>=efectivo)){//si esta vacio o el indice no es correcto
            throw new IndexOutOfBoundsException("indice no valido o lista vacia");
            
        }else{
            int contador=0;
            for(Node<E> q=last.next; contador<efectivo;q=q.getNext()){
                if(contador==index){
                    return q;
                }
                contador++;
            }
            return null;//si no lo encuentra
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
    public E get(int index) {
        return getNode(index).getData();
    }

    @Override
    public boolean isEmpty() {
         return efectivo==0;
    }

    @Override
    public boolean insert(int index, E e) throws IndexOutOfBoundsException, NullPointerException{
        if(index<0 || index>this.size()){
            throw new IndexOutOfBoundsException("Index fuera de rango");
        }
        else if(e==null){
            throw  new NullPointerException();
        }
        else if(index==0){
            
            return addFirst(e);
        }
        else if(index==(efectivo)){
            
            return addLast(e);
        }
        else{
            //creo un nodo
            Node<E> q= getNode(index-1);//implementar Node <E > nodeIndex(index)
            Node<E> p=q.getNext();
            
            Node<E> node=new Node<>(e);//nodo a insertar
            q.setNext(node);
            node.setPrevious(q);
            node.setNext(p);
            p.setPrevious(node);
            
            efectivo++;
            return true;
        }
        
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
            Node<E> n=getNode(index);//anterior
            n.getPrevious().setNext(n.getNext());//anterior al siguiente
            n.getNext().setPrevious(n.getPrevious());//siguiente  al anterior
            
            n.setPrevious(null);
            n.setData(null);
            n.setNext(null);
            efectivo--;
            return true;
        }
        
    }
    @Override
    public String toString(){
        if(isEmpty()) return "[]\n";
        StringBuilder sb= new StringBuilder();
        sb.append("[");
        for(Node<E> q=last.next; q!=last;q=q.getNext()){
            sb.append(q.data);
            sb.append(",");
            
        }
        sb.append(last.data);
        sb.append("]");
        return sb.toString();
        
    }
    /*@Override
    public boolean equals(Object o){
        if (o == null || !(o instanceof CircularDoublyLinkedList)){
            return false;
        }
        CircularDoublyLinkedList<E> other = (CircularDoublyLinkedList<E>) o;
        if(this.efectivo != other.efectivo){
            return false;
        }
        Node<E> q = this.first;
        Node<E> p = other.first;
        int contador=0;
        for(Node<E> t = this.first; contador<efectivo;q=q.getNext()){
            Object e1= q.getNext();
            Object e2= p.getNext();
            if(!e1.equals(e2) ){
            return false;
            }
            contador++;
        }
        return true;
    }*/
    
     public Iterator<E> iterator(){
         Iterator<E>it= new Iterator<E>(){
             public Node<E> p = last.next;//inicio
             public int index=0;
             @Override
             public boolean hasNext() {
                return !(index==efectivo);
                //return !(isEmpty());  carrusel
             }

             @Override
             public E next() {
                E tmp = p.getData();
                p=p.getNext();
                index++;
                return tmp;
             }
             
         };
     return it;    
     }
     public ListIterator<E> listiterator(){
            ListIterator<E> lit = new ListIterator<E>(){
            private Node<E> p = last.next;
            private int i = 0;
            @Override
            public boolean hasNext() {
                return p!=null;
            }

            @Override
            public E next() {
                E tmp = p.data;
                p = p.next;
                i++;
                return tmp;
            }

            @Override
            public boolean hasPrevious() {
                return p!=null;
            }

            @Override
            public E previous() {
                E tmp = p.data;
                p = p.previous;
                i--;
                return tmp;
            }

            @Override
            public int nextIndex() {
                return i+1;
            }

            @Override
            public int previousIndex() {
                return i-1;
            }

            @Override
            public void remove() {
                if(!isEmpty()){
                    Node<E> anterior=p.getPrevious();
                    Node<E> siguiente=p.getNext();
                    
                    anterior.setNext(siguiente);
                    siguiente.setPrevious(anterior);
                    
                    Node<E> borrado=p;
                    borrado.setData(null);
                    borrado.setNext(null);
                    borrado.setPrevious(null);
                    
                    p=siguiente;
                    
                    
                }
            }

            @Override
            public void set(E arg0) {
                 if(arg0!=null){
                    p.setData(arg0);
                }
            }

            @Override
            public void add(E arg0) {
                if(arg0!=null){
                    Node<E> anterior=p.getPrevious();
                    Node<E> nuevo=new Node<>(arg0);
                    anterior.setNext(nuevo);
                    nuevo.setPrevious(anterior);
                    p.setPrevious(nuevo);
                    nuevo.setNext(p);
                    //el iterator se maantiene aqui
                    
                }
            }
        };
        return lit;
    }
    
    public ListIterator<E> listiterator(int index)
    {
        ListIterator<E> lit = new ListIterator<E>(){
            private Node<E> p = getNode(index);
            private int i = index;
            @Override
            public boolean hasNext() {
                return p!=null;
            }

            @Override
            public E next() {
                E tmp = p.data;
                p = p.next;
                i++;
                return tmp;
            }

            @Override
            public boolean hasPrevious() {
                return p!=null;
            }

            @Override
            public E previous() {
                E tmp = p.data;
                p = p.previous;
                i--;
                return tmp;
            }

            @Override
            public int nextIndex() {
                return i+1;
            }

            @Override
            public int previousIndex() {
                return i-1;
            }

            @Override
            public void remove() {
                if(!isEmpty()){
                    Node<E> anterior=p.getPrevious();
                    Node<E> siguiente=p.getNext();
                    
                    anterior.setNext(siguiente);
                    siguiente.setPrevious(anterior);
                    
                    Node<E> borrado=p;
                    borrado.setData(null);
                    borrado.setNext(null);
                    borrado.setPrevious(null);
                    
                    p=siguiente;
                    
                    
                }
            }

            @Override
            public void set(E arg0) {
                 if(arg0!=null){
                    p.setData(arg0);
                }
            }

            @Override
            public void add(E arg0) {
                if(arg0!=null){
                    Node<E> anterior=p.getPrevious();
                    Node<E> nuevo=new Node<>(arg0);
                    anterior.setNext(nuevo);
                    nuevo.setPrevious(anterior);
                    p.setPrevious(nuevo);
                    nuevo.setNext(p);
                    //el iterator se maantiene aqui
                    
                }
            }
        };
        return lit;
    }

    public void reverse(){
        
    }
    @Override
    public int indexOf(E e) throws NullPointerException{
        int index=0;
        if(e==null){
            throw new NullPointerException();
        }else{
            for(Node <E> n=last.next;index<efectivo;n=n.next){
                if(n.getData()==e){
                    return index;
                }
                index++;
            }
        }
        return -1;
    }
    
    public  void switchFirstandLast(){
        //asumo que siempre la lista tiene 3 o mas elementos
        //capturo ambos
        Node<E> first=last.next;
        Node<E> l=last;
        l.setNext(first.next);
        first.next.setPrevious(last);
        
        l.previous.setNext(first);
        first.setPrevious(l.previous);
        
        first.setNext(last);
        last.setPrevious(first);
        
        
        
    }
}

