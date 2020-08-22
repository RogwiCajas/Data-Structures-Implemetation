/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.tree;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

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
    
    //////////////////////////////////// DEBER /////////////////////////////////
    //Ejercicio 1
    /**
     * Calcula la distancia de un nodo a su ancestro
     * @param currentAncestor
     * @param e
     * @return 
     */
    private int distanceAlAncestro( Node<E> currentAncestor,E e){
        if(currentAncestor==null || f.compare(currentAncestor.data, e)==0){
            //Si no hay mas nodos  o es el mismo.
            return 0;
        }
        else if(f.compare(currentAncestor.data, e)>0){//current>e
            return 1+ distanceAlAncestro(currentAncestor.left, e);
        }
        else if(f.compare(currentAncestor.data, e)<0){//current<e
            return 1+ distanceAlAncestro(currentAncestor.right, e);
        }
        return 0;//hay que ver
    }
    /**
     * Calula la distancia entre 2 nodos con un ancestro comun
     * @param n1
     * @param n2
     * @param currentAncestor
     * @return 
     */
    private int distanceBetweenNodes(E n1, E n2, Node<E> currentAncestor) {
            if(currentAncestor==null) {
                currentAncestor = this.root;
            }
            if(f.compare(n1, n2)>0){//n1 simpre debe ser menor que n2
                E temp = n2;
                n2 = n1;
                n1 = temp;
            }
            
            if( f.compare(currentAncestor.data, n1)>0 && f.compare(currentAncestor.data, n2)>0 ){
                return this.distanceBetweenNodes(n1, n2, currentAncestor.left);
            }
            if(f.compare(currentAncestor.data, n1)<0 && f.compare(currentAncestor.data, n2)<0) {
                return this.distanceBetweenNodes(n1, n2, currentAncestor.right);
            }
            if(f.compare(currentAncestor.data, n1)>=0 && f.compare(currentAncestor.data, n2)<=0) {
                return distanceAlAncestro(currentAncestor, n1) + distanceAlAncestro(currentAncestor, n2);
            }
            return 0;//nunca se invoca.
    }
    /**
     * Calula la distancia mas corta entre 2 nodos.
     * @param n1
     * @param n2
     * @return 
     */
    public int distanceBetwenNodes(E n1, E n2){
        return distanceBetweenNodes(n1, n2, root);
    }
    
    //--------------------------------------Tema 3//////////////////////////////
    /**
     * Retorna una lista con todas las claves del arbol derecho
     * de la clave enviada como parametro
     * @param clave
     * @return 
     */
    public List<E> subDerecho(E clave){
        List<E> lista=new LinkedList<>();
        if(clave == null){
            return lista;
        }
        return subDerecho(clave,root,false);
    }
    
    private List<E> subDerecho(E clave, Node<E> n,boolean flag){
        List<E> lista =new LinkedList<>();
        if(n==null){
            return lista;
        }
        if(f.compare(clave,n.data)>0){
            //busco a la derecha. muevo el viajero a la derech
            if(flag==true){//si esta dentro del hijo de recho de la clave
                lista.add(n.data);
            }
            lista.addAll(subDerecho(clave,n.right,flag));
        }
        if(f.compare(clave,n.data)<0){
            //busco a la izquierda.muevo el viajero a la izq
            if(flag==true){//si esta dentro del hijo derecho de la clave
                lista.add(n.data);
            }
            lista.addAll(subDerecho(clave,n.left,flag));//mando a agregar por izqu y por derecha
            lista.addAll(subDerecho(clave,n.right,flag));
        }
        if(f.compare(clave,n.data)==0){
            //me muevo a la drecha y guardo todos sus hijos
            lista.addAll(subDerecho(clave,n.right,true));
        }
            
        return lista;
    }
    
    public int getLevel(E e){
        if(e==null){
            return  -1;
        }
        return getLevel(e,root);
    }
    private int getLevel(E e, Node<E> n){
        if(n==null){
            return -1;
        }
        else if(n.data.equals(e)){
            
            return 0;
        }
        else if(f.compare(e,n.data)>0){
            int level=getLevel(e, n.right);
            return (level == -1)? -1 : 1 + level;
        }else {
            int level=getLevel(e, n.left);
            return (level == -1)? -1 : 1 + level;
            
        }
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
