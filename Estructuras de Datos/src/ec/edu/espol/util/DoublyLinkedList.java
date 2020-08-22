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
 * @param <E>
 */
public class DoublyLinkedList <E> implements List<E>, Iterable<E>{
    private Node<E> first;
    private Node<E> last;
    private int efectivo;
    
    public DoublyLinkedList(){
        first =last=null;
        efectivo=0;
    }
    private class Node<E>{
        private E data;
        private Node<E> next;
        private Node<E> previous;
        
        public Node(E data){
            this.data=data;
            this.next=null;
            this.previous=null;
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
    /**
     * Consulta si la lista contiene al elemento
     * @param element
     * @return true si contiene al elemento.
     */
    @Override
    public boolean contains(E element) {
        if(isEmpty()|| element==null){
            return false;
        }else{
            for(Node<E> q=this.first;q!=null;q=q.getNext()){
                if(q.getData().equals(element)){
                    return true;
                }
                
            }
        }
        return false;
    }
    /**
     * Tamaño de la lista
     * @return tamaño entero de la lista
     */
    @Override
    public int size() {
        return efectivo;
    }
    /**
     * Agrega un elmento al final de la lista.
     * @param element
     * @return true, si fue agregado correctamente.
     */
    @Override
    public boolean addLast(E element) {
        if( element==null){
            return false;
        }else if(isEmpty()){
            Node<E> node=new Node<>(element);
            last=first =node;
        }
        
        else{
            Node<E> node=new Node<>(element);//creo el nodo
            last.setNext(node);//enlazo el anterior last al nuevo
            node.setPrevious(last);//enlazo el nuevo last al antiguo
            last=node;
            
            
        }
        efectivo++;
        return true;
    }
    /**
     * Agrega un elemento al inicio de la lista
     * @param element
     * @return true, si el elemento es agregado correctamente.
     */
    @Override
    public boolean addFirst(E element) {
        if(element==null){
            return false;
        }else if(isEmpty()){
            Node<E> n=new Node<>(element);
            first=last=n;
        }      
        else{
            Node<E> node=new Node<>(element);//creo el nodo
            node.setNext(first);//enlazo el nuevo al first
            first.setPrevious(node);//enlazo first al nuevo
            first=node;//seteo el nuevo first                       
        }
        efectivo++;
        return true;
    }
    /**
     * Remueve el ultimo elemento de la lista.
     * @return true, si se removio correctamente.
     */
    @Override
    public boolean removeLast() {
        if(isEmpty()){
            return false;
        }else if(first==last){
            first.setData(null);
            first=last=null;
        }else{
            Node<E> tempo=last;//guardamos en un tmp
            
            last=last.getPrevious();//seteo el nuevo last
            last.setNext(null);
            
            tempo.setData(null);
            tempo.setNext(null);
            tempo.setPrevious(null);
                        
            
        }
        efectivo--;
        return true;
    }
    /**
     * Remueve el primer elemento de la lista.
     * @return true si se elimino correctamente.
     */
    @Override
    public boolean removeFirst() {
        if(isEmpty()){
            return false;
        }else if (first==last){//un nodo
            first.setData(null);//libero memoria
            first=last=null;
            return true;
        }else{
            //guaradamos en temp
            Node<E> tempo=first;
            //asigno el fist de arreglo al siguiente.
            first=first.getNext();
            //elimino las referencia del atiguo first
            first.setPrevious(null);
            tempo.setNext(null);
            tempo.setPrevious(null);
            tempo.setData(null);
        }
        efectivo--;
        return true;
    }
    /**
     * Consulta el primer elemento de la lista
     * @return el primer objeto de la lista.
     */
    @Override
    public E getFirst() {
         if(isEmpty()){
            return null;
        }else{
            return this.first.getData();
        }
    }
    /**
     * Consulta el ultimo elemento de la lista
     * @return el ultimo objeto de la lista.
     */
    @Override
    public E getLast() {
         if(isEmpty()){
            return null;
        }else{
            return this.last.getData();
        }
    }
    /**
     * Cambia el valor de la lista en Index por el valor enviado.
     * @param index posicion a cambiar
     * @param element valor nuevo
     * @return true si se cambio correctamente.
     */
    @Override
    public boolean set(int index, E element) {
        if(isEmpty() || element==null|| index<0||index>=efectivo){
            return false;
        }else{
            nodeIndex(index).setData(element);
            
            
            return true;
            
        }
    }
    /**
     * Consulta el elemento de la lista que ocupe la poscicion requerida.
     * @param index posicion.
     * @return valor en index.
     */
    @Override
    public E get(int index) {
        if(isEmpty()|| (index<0||index>=efectivo)){//si esta vacio o el indice no es correcto
            return null;
            
        }if(index==efectivo-1){
           return last.getData();
        }else{
            int contador=0;
            for(Node<E> q=this.first; q!=null;q=q.getNext()){
                if(contador==index){
                    return q.getData();
                }
                contador++;
            }
        }
        return null;
    }
    /**
     * Consulta si la lista esta vacia
     * @return true si esta vacia.
     */
    @Override
    public boolean isEmpty() {
        return efectivo==0;
    }
    /**
     * Inserta un nuevo elemento en la posicion index, desplaza a los elementos
     * subsecuentes hacias adelante.
     * @param index posicion 
     * @param element nuevo elemento.
     * @return true, si se insertó correctamente.
     */
    @Override
    public boolean insert(int index, E element) {
        if(index==0){
            return addFirst(element);
        }else if(element==null|| index<0|| index>=efectivo){
            return false;
            
        }else{
            //creo un nodo
            Node<E> q= nodeIndex(index-1);//implementar Node <E > nodeIndex(index)
            Node<E> p=q.getNext();
            
            Node<E> node=new Node<>(element);//nodo a insertar
            q.setNext(node);
            node.setPrevious(q);
            
            node.setNext(p);
            p.setPrevious(node);
            
            efectivo++;
            return true;
        }
    }
    /**
     * Remueve el elmento en la posicion index
     * @param index posicion aremover
     * @return true, si se elimino correctamente.
     */
    @Override
    public boolean remove(int index) {
        if(isEmpty() ||  index<0||index>=efectivo){//si esta vacio o elindice no es correcto
            
            return false;
        }else if(first==last){//tiene un solo nodo 1
            first.setData(null);
            first=last=null;
            efectivo--;
        }else{ //tiene  2 nodos o mas
            //Obtengo el nodo en index
            Node<E> nodo=nodeIndex(index); //obtengo el nodo en index
            
           if(nodo==first){
               return removeFirst();
              
           }else if(nodo==last){
               return removeLast();
           } else{
               Node<E> nodoanterior=nodo.getPrevious();
               Node<E> nodosiguiente=nodo.getNext();
               
               nodoanterior.setNext(nodosiguiente);
               nodosiguiente.setPrevious(nodoanterior);
               nodo.setData(null);
               nodo.setNext(null);
               nodo.setPrevious(null);
               efectivo--;
           }
                     
                      
                       
            
            
            
        }
        
        return false;
    }
    /**
     * Consulta un nodo basado en su indice.
     * @param index
     * @return 
     */
    private Node<E> nodeIndex(int index){
        if(isEmpty()|| (index<0&&index>=efectivo)){//si esta vacio o el indice no es correcto
            return null;
            
        }else{
            int contador=0;
            for(Node<E> q=this.first; q!=null;q=q.getNext()){
                if(contador==index){
                    return q;
                }
                contador++;
            }
        }
        return null;
    }
    /**
     * Crea una representacion String de la lista
     * @return lista en String
     */
    @Override
    public String toString(){
        if(isEmpty()) return "[]\n";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(Node<E> p = first; p!=last; p=p.next)//hasta el penultimo
        {
            sb.append(p.data);
            sb.append(",");
        }
        sb.append(last.data);
        sb.append("]");
        return sb.toString();
           
    }
    /**
     * Comparador, compara 2 listas enlazadas dobles
     * @param o
     * @return true si son iguales.
     */
    @Override
    public boolean equals(Object o){
        if (o == null || !(o instanceof DoublyLinkedList)){
            return false;
        }
        DoublyLinkedList<E> other = (DoublyLinkedList<E>) o;
        if(this.efectivo != other.efectivo){
            return false;
        }
        Node<E> q = this.first;
        Node<E> p = other.first;
        
        for(Node<E> t = this.first; q!= null;q=q.getNext()){
            Object e1= q.getNext();
            Object e2= p.getNext();
            if(!e1.equals(e2) ){
            return false;
            }
        }
        return true;
    }
    
    /**
     * Comprueba si 2 Listas son una la Reversa de la otra.
     * @param l1
     * @param l2
     * @return true si son reversas.
     */
    public static boolean isReverse(DoublyLinkedList<Integer> l1, DoublyLinkedList<Integer> l2){
        //ver si l2 es reverse de l1
        return true;
    }
    /**
     * Condulta el indice que ocupa un elemento dentro de la lista.
     * @param e
     * @return 
     * @throws NullPointerException 
     */
    @Override
    public int indexOf(E e) throws NullPointerException {
        int index=0;
        if(e==null){
            throw new NullPointerException();
        }else{
            for(Node <E> n=first;n!=null;n=n.next){
                if(n.getData()==e){
                    return index;
                }
                index++;
            }
        }
        return -1;
    }
    
    /**
     * Crea un Iterator paara la lista
     * @return 
     */
    @Override
    public Iterator<E> iterator(){
         Iterator<E>it= new Iterator<E>(){
             public Node<E> p = first;
             @Override
             public boolean hasNext() {
                return p!=null;
             }

             @Override
             public E next() {
                E tmp = p.getData();
                p=p.getNext();
                return tmp;
             }
             
         };
     return it;    
     }
    /**
     * Crea un listIterator para la lista
     * @return 
     */
     public ListIterator<E> listiterator(){
        ListIterator<E> lit = new ListIterator<E>(){
            private Node<E> p = first;
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
                if(i==efectivo){
                    //el indice esta en null, 
                    p=last;
                }
                return (p!=null);
            }

            @Override
            public E previous() {
                //regreso el indice, si se hace next y previous unos tras otro deberia repetir infinitamente el mismo valor
                E tmp = p.data;
                p=p.previous;
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
                    if(p==first){
                        removeFirst();//elimina el primero validando
                        p=first;
                    }else if(p==last){
                        removeLast();
                        p=last;
                    }else{
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
                    if(p==first){
                        addFirst(arg0);
                    }else if(p==last){
                        addLast(arg0);
                    }else{
                    Node<E> anterior=p.getPrevious();
                    Node<E> nuevo=new Node<>(arg0);
                    anterior.setNext(nuevo);
                    nuevo.setPrevious(anterior);
                    p.setPrevious(nuevo);
                    nuevo.setNext(p);
                    //el iterator se maantiene aqui
                    }
                    i++;
                }
            }
        };
        return lit;
    }
    /**
     * Crea un list iterator con inicio en index para la lista
     * @param index
     * @return 
     */
    public ListIterator<E> listiterator(int index)
    {
        ListIterator<E> lit = new ListIterator<E>(){
            private Node<E> p = nodeIndex(index);
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
                if(i==efectivo){
                    //el indice esta en null, 
                    p=last;
                }
                return (p!=null);
            }

            @Override
            public E previous() {
                //regreso el indice, si se hace next y previous unos tras otro deberia repetir infinitamente el mismo valor
                E tmp = p.data;
                p=p.previous;
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
                    if(p==first){
                        removeFirst();//elimina el primero validando
                        p=first;
                    }else if(p==last){
                        removeLast();
                        p=last;
                    }else{
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
                    if(p==first){
                        addFirst(arg0);
                    }else if(p==last){
                        addLast(arg0);
                    }else{
                    Node<E> anterior=p.getPrevious();
                    Node<E> nuevo=new Node<>(arg0);
                    anterior.setNext(nuevo);
                    nuevo.setPrevious(anterior);
                    p.setPrevious(nuevo);
                    nuevo.setNext(p);
                    //el iterator se maantiene aqui
                    }
                    i++;
                }
            }
        };
        return lit;
    }
    /**
     * Consulta si una lista es palindroma, es decir,se le igual de inicio a fin que de fin a inicio.
     * @return 
     */
    public boolean esPalindromoRecursivo(){
        if(isEmpty()){return false;
        }
        return esPalindromoRecursivo(first,last,0, efectivo-1);
    }
    private boolean esPalindromoRecursivo(Node<E> start,Node<E> fin,int i, int  j){
        if(!(start.getData().equals(fin.getData()))){
            return false;
        }else if(start.getData().equals(fin.getData()) && j>=i){//si el siguiente es igul
            return esPalindromoRecursivo(start.getNext(),fin.getPrevious(),i+1,j-1);
            
        }else{
            return true;
            
            
        
         }
        
    }
    /**
     * Remueve todos los elementos e de la lista.
     * @param e 
     */
    public void removeAll(E e){
        ListIterator<E> itInicial=this.listiterator();
        ListIterator<E> itFinal=this.listiterator(efectivo);
        // 2, 4,5,6,7,5,3,4
        removeAll(itInicial,itFinal,e);
    }
    private void removeAll(ListIterator<E> first, ListIterator<E> last,E e){
        // |0  |2
        if(last.hasPrevious()&&first.hasNext() ){
            E data=last.previous();
            E data2=first.next();
            if(e.equals(data)){
                last.next();
                last.remove();
            }
            if(e.equals(data2)){
                first.previous();
                first.remove();
            }
            removeAll(first,last,e);
        
            
            
        }
    }
    /**
     * Revierte la lista.
     * @return true, si se revirtio correctamente
     */
    public boolean reverse(){
        if(isEmpty() || efectivo==1)   return false;
        return reverse(first,last);
        
    }
    
    private boolean reverse(Node<E> f, Node<E> l){
        if(f==l)    return true;
        else if(l.getNext()==f)  return true;
        else{
            E e = f.getData();
            f.setData(l.getData());
            l.setData(e);
            return reverse(f.getNext(),l.getPrevious());
        }
    }
    /**
     * Genera un recorte de la lista desde la posicion start, hasta end
     * @param start posicion inicial 
     * @param end posicicion final, no incluida
     * @return lista con el recorte.
     */
    public DoublyLinkedList<E> slicing(int start,int end){
        DoublyLinkedList<E> nueva = new DoublyLinkedList<>();
        if(!isEmpty() && start<end){
            Node<E> p = nodeIndex(start);
            while(start!= end){
                nueva.addLast(p.data);
                p=p.next;
                start++;
            }
        }
        return nueva;
   
    }
}

