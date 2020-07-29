/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.util;

import java.util.Iterator;
import java.util.ListIterator;

/**
* The program implemnets the ArrayList Java Class using
* Array.
*
* @author  cajas
* @version 1.0
* @since   2020-06-09
*/
public class ArrayList <E> implements List<E>,Iterable<E>{
    private E[] array;
    private int current;
    private int capacity;
    
    public ArrayList(){
        capacity=10;
        current=0;
        array=(E[])new Object[capacity];
    }
   /**
   * Este metodo sirve para agregar un elemnto al inicio
   * del ArrayList.
   * .
   * @param e Elemento a ser agregado.
   * @return Verdadero si el elemento e es correctamente agregado.
   */
    @Override
    public boolean addFirst(E e) {
        if(e == null) return false;
        if(current == capacity) addCapacity();
        for(int i = current-1;i>=0;i--)
            array[i+1] = array[i];
        array[0] = e;
        current++;
        return true;
    }
   /**
   * Este metodo sirve para agregar un elemnto al final
   * del ArrayList.
   * .
   * @param e Elemento a ser agregado.
   * @return Verdadero si el elemento e es correctamente agregado.
   */
    @Override
    public boolean addLast(E e) {
        if(e == null) return false;
        if(current == capacity) addCapacity();
        array[current++] = e;
        return true;
    }
   /**
   * Este metodo consulta el primer elemento 
   * del ArrayList
   * @return primer elemento e del ArrayList.
   */
    @Override
    public E getFirst() {
        if(isEmpty()) return null;
        return array[0];
    }
        
   /**
   * Este metodo consulta el ultimo elemento 
   * del ArrayList
   * @return uiltimo elemento e del ArrayList, si el ArrayList està vacio devuelve null.
   */
    @Override
    public E getLast() {
        if (isEmpty()) return null;
        return array[current-1];
        
    } 
    /**
   * Este metodo sirve para insertar un elemento e 
   * del ArrayList en la posicion index.
   * .
   * @param e Elemento nuevo.
   * @param index posicion donde se insertara e.
   * @return El valor alojado en el indice index, en caso de estar vacio o no estar retorno -1.
   */
    @Override
    public int indexOf(E e) {
        if(isEmpty()) return -1;
        for(int i=0;i<array.length-1;i++){
            if(array[i].equals(e)){
                return i;
            }
            
        }
        return -1;
        }
   /**
   * Este metodo sirve para consultar el tamaño 
   * del ArrayList.
   * @return el tamaño del ArrayList como int.
   */
    @Override
    public int size() {
        return current;
    }
   /**
   * Este metodo sirve para eliminar el ultimo elemento
   * del ArrayList.
   * @return Verdadero si el elemento e es correctamente removido.
   */
    @Override
    public boolean removeLast() {
        if(isEmpty()){
            return false;
        }
        array[current--] = null;
        return true;
    }
   /**
   * Este metodo sirve para eliminar el primer elemento.
   * del ArrayList.
   * @return Verdadero si el elemento e es correctamente removido.
   */
    @Override
    public boolean removeFirst() {
        if(isEmpty()){
            return false;
        }
        for(int i = 0; i < current - 1; i++){
            array[i] = array[i + 1];
        }
        array[--current] = null;
        return true;
    }
    /**
   * Este metodo sirve para insertar un elemento e 
   * del ArrayList en la posicion index.
   * .
   * @param e Elemento nuevo.
   * @param index posicion donde se insertara e.
   * @return Verdadero si el elemento es insertado adecuadamente.
   */
    @Override
    public boolean insert(int index, E e) {
        if(e == null || index >= current|| index < 0){
            return false;
        }else if(current== capacity){
            addCapacity();
        }
        for(int i = current; i > index; i--){
            array[i] = array[i-1];
        }
        array[index] = e;
        current++;
        return true;
    }
    /**
   * Este metodo sirve para reemplazar un  un elemnto 
   * del ArrayList en la posicion index.
   * .
   * @param e Elemento nuevo.
   * @param index indice del valor a ser reemplazado.
   * @return Verdadero si el elemento es reemplazado adecuadamente.
   */
    @Override
    public boolean set(int index, E e) {
        if(index >= current|| index < 0){
            return false;
        }
        array[index] = e;
        return true;
    }
   /**
   * Este metodo sirve para consultar si el arreglo
   * esta vacio.
   * @return Verdadero si el arreglo está vacio.
   */
    @Override
    public boolean isEmpty() {
        return current == 0;
    }
    /**
   * Este metodo sirve para consultar  un elemnto 
   * del ArrayList en la posicion index.
   * 
   * @param index indice del valor a ser consultado.
   * @return E elemento en la posicion index.
   */
    @Override
    public E get(int index) {
        if(isEmpty()) return null;
        else if(index<0) return null; 
        return array[index];
    }
    /**
   * Este metodo sirve para consultar si el ArrayList contiene el Elemento e
   * @param e Elemento a ser consultado.
   * @return Verdadero si el ArrayList contiene al elemento e.
   */
    @Override
    public boolean contains(E e) {
        for(int i=0; i<current; i++)
        {
            if(array[i].equals(e))
                return true;
        }
        return false;
    }
    /**
   * Este metodo sirve para remover  un elemnto 
   * del ArrayList en la posicion index.
   * 
   * @param index indice del valor a ser removido.
   * @return Verdadero si el valor es removido correctamente.
   */
    @Override
    public boolean remove(int index) {
        if(index >= current || index < 0){
            return false;
        }
        for(int i = index; i < current - 1; i++){
            array[i] = array[i + 1];
        }
        array[--current] = null;
        return true;
    }
   /**
   * Este Metodo es para implementar la capacidad del Array
   */
    private void addCapacity()
    {
        E[] tmp = (E[])new Object[(capacity*3)/2];
        for(int i=0;i<current;i++)
            tmp[i] = array[i];//deep copy
        array = tmp;//shallow copy
        capacity = (capacity * 3)/2;
    }
   /**
   * Implementación del Metodo toString para ArrayList.
   * @return El ArrayList expresado como String.
   */
    @Override
    public String toString()
    {
        if(isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i=0;i<current-1;i++)//hasta el penultimo elemento lleva coma
        {
            sb.append(array[i]);
            sb.append(",");
        }    
        sb.append(array[current-1]);//agrego el ultimo elemento sin coma
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {
            Iterator<E> it = new Iterator<E>() {
            private int i=0;
            @Override
            public boolean hasNext() {
                return i<current;
            }

            @Override
            public E next() {
                E tmp = array[i];
                i++;
                return tmp;
            }
        };
        return it;
    }
    public ListIterator<E> listiterator() throws IndexOutOfBoundsException{
            
            ListIterator<E> lit = new ListIterator<E>(){
            
            private int i = 0;
            @Override
            public boolean hasNext() {
                return i<current;
            }

            @Override
            public E next() {
                if(!hasNext()) throw new IndexOutOfBoundsException("Valor fuera de rango");
                E tmp = array[i];
                i++;
                return tmp;
            }

            @Override
            public boolean hasPrevious() {
                return i>0;
            }

            @Override
            public E previous() {
                if(!hasPrevious()) throw new IndexOutOfBoundsException("Valor fuera de rango");
                E tmp = array[i-1];
                i--;
                return tmp;
            }

            @Override
            public int nextIndex() {
                if(hasNext()){
                    return i+1;
                }
                else {
                    throw new IndexOutOfBoundsException("Valor fuera de rango");
                }
                
                
            }

            @Override
            public int previousIndex() {
                if(hasPrevious()){
                    return i-1;
                }
                else {
                    throw new IndexOutOfBoundsException("Valor fuera de rango");
                }
            }
            /**
             * Remueve el ultimo valor que se obtuvo con next()
             */
             @Override
            public void remove() {
                i--;
                if(i< current &&  i>= 0){
                    for(int j = i; j < current; j++){
                    array[j] = array[ j+ 1];
                    }
                    array[--current] = null;
                                        
                }
            }

            @Override
            public void set(E arg0) {
                if(i<current && i>=0){
                    array[i]=arg0;
                }
            }

            @Override
            public void add(E arg0) {
               
                if(current== capacity){
                    addCapacity();
                }
                for(int j = current; j > i; j--){
                    array[j] = array[j-1];
                }
                array[i] = arg0;
                current++;
                
                
            }
        };
        return lit;
    }
    
    public ListIterator<E> listiterator(int index) throws IndexOutOfBoundsException
    {
            if(index<0 ||index>=current){
                throw  new IndexOutOfBoundsException("Index debe estar entre 0 y current-1");
            }
            ListIterator<E> lit = new ListIterator<E>(){
                        
            private int i = index;
            @Override
            public boolean hasNext() {
                return i<current;
            }

            @Override
            public E next() {
                if(!hasNext()) throw new IndexOutOfBoundsException("Valor fuera de rango");
                E tmp = array[i];
                i++;
                return tmp;
            }

            @Override
            public boolean hasPrevious() {
                return i>0;
            }

            @Override
            public E previous() {
                if(!hasPrevious()) throw new IndexOutOfBoundsException("Valor fuera de rango");
                E tmp = array[i-1];
                i--;
                return tmp;
            }

            @Override
            public int nextIndex() {
                if(hasNext()){
                    return i+1;
                }
                else {
                    throw new IndexOutOfBoundsException("Valor fuera de rango");
                }
                
                
            }

            @Override
            public int previousIndex() {
                if(hasPrevious()){
                    return i-1;
                }
                else {
                    throw new IndexOutOfBoundsException("Valor fuera de rango");
                }
            }

            /**
             * Remueve el ultimo valor que se obtuvo con next()
             */
             @Override
            public void remove() {
                i--;
                if(i< current &&  i>= 0){
                    for(int j = i; j < current; j++){
                    array[j] = array[ j+ 1];
                    }
                    array[--current] = null;
                                        
                }
            }

            @Override
            public void set(E arg0) {
                if(i<current && i>=0){
                    array[i]=arg0;
                }
            }

            @Override
            public void add(E arg0) {
               
                if(current== capacity){
                    addCapacity();
                }
                for(int j = current; j > i; j--){
                    array[j] = array[j-1];
                }
                array[i] = arg0;
                current++;
                
                
            }
        };
        return lit;
    }
}
