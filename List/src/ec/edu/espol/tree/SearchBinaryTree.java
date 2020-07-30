/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.tree;

import java.util.Comparator;

/**
 *
 * @author cajas
 */
public class SearchBinaryTree<E> {
    private Node<E> root;
    private Comparator<E> f;
    private class Node<E>{
        private E data;
        private Node<E> left;
        private Node<E> right;

        public Node(E data){
            this.data=data;
        }
    } 
    public SearchBinaryTree(Comparator<E> f){
        this.f=f;        
    }
    /**
     * Agrega el elemento al arbol
     * @param element
     * @return 
     */
    public boolean add(E element){
        if(element==null){
            return false;
        }
        this.root = add(element,root);//
        return true;
    }
    private Node<E> add(E element,Node<E> n){
        if(n == null){//Esta vacio
            n = new Node<>(element);
            return n;
        }
        else if(f.compare(element,n.data)>0){
            n.right = add(element, n.right);
        }else if(f.compare(element, n.data)<0){
            n.left = add(element, n.left);
        }
        return n;
    }
    /**
     * Consulta el elemento menor
     * @return 
     */
    public E min(){
        return min(root);
    }
    private E min(Node<E> n){
        if(n==null) return null;
        else if(n.left==null){
            return n.data;
        }    
        else
            return min(n.left);
    }
    /**
     * Consulta al elemento mayor
     * @return 
     */
    public E max(){
        return max(root);
    }
    private E max(Node<E> n){
        if(n==null) return null;
        else if(n.right==null){
            return n.data;
        }else
            return max(n.right);
    }
    /**
     * Consulta si el elemento si encuentra en el arbol.
     * @param element
     * @return 
     */
    public boolean contains(E element){
        if(element==null){
            return false;
        }
        return contains(element,root);
    }
    private boolean contains(E element, Node<E> n){
        if(n==null){//arbol vacio o llego hasta una hoja y no encontró
            return false;
        }
        else if(f.compare(element, n.data)==0){//si es dicho nodo.
            return true;   
        }
        else if(f.compare(element, n.data)>0){//Si es mayor
            //busco a la derecha de n
            return contains(element, n.right);
        }
        else if(f.compare(element, n.data)<0){
            //busco a la izquiera de n
            return contains(element, n.left);
        }
        return false;
    }
    
    /**
     * Remueve el elemento del arbol
     * @param element
     * @return 
     */
    public boolean remove(E element){
        if(element==null) return false;
        this.root = remove(element, root);
        return true;
    }
    
    private Node<E> remove(E element, Node<E> n){
        if(n== null){
            return n;
        }else if(f.compare(element,n.data)>0){
            n.right = remove(element, n.right);
        }else if(f.compare(element, n.data)<0){
            n.left = remove(element, n.left);
        } 
        //Si la data es igual, encontre al nodoa eliminar
        else if(n.left!=null &&n.right!=null){//tiene dos hijos
            n.data=max(n.left);//cambio al mayor de los menors
            n.left=remove(n.data,n.left);//mando eliminar el mayor de los menors
            
        }else{//si tiene un solo nodo hijo
            n=(n.left!=null)?n.left:n.right;
        }
        return n;
    }
    
    
    /**
     * Imprime el arbol en preOrden
     * raiz, izq,derecha
     */
    public void preOrden(){
        preOrden(root);
    }
    private void preOrden(Node<E> n){
        if(n!=null){
            System.out.println(n.data);
            preOrden(n.left);
            preOrden(n.right);
        }
    }
    /**
     * Imprime el arbol en PostOrden
     * izq, derecho, raiz
     */
    public void postOrden(){
        postOrden(root);
    }
    private void postOrden(Node<E> n)
    {
        if(n!=null){
            postOrden(n.left);         
            postOrden(n.right);
            System.out.println(n);
        }
    }
    /**
     * Imprime el arbol en Orden
     * izq, raiz, derecho
     */
    public void enOrden(){
        enOrden(root);
    }
    private void enOrden(Node<E> n){
        if(n!=null){
            postOrden(n.left);
            System.out.println(n);
            postOrden(n.right);
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
