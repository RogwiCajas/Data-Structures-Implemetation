/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.tree;

/**
 *
 * @author cajas
 */
public class BinaryTree<E> {
    private Node<E> root;
    
    private class Node<E>{
        private E data;
        private Node<E> left;
        private Node<E> right;

        public Node(E data){
            this.data=data;
        }
    }   
    //constructor con raiz nula;
    /**
     * Consulta si el arbol es completo
     * @return true si es completo.
     */
    public boolean isFull(){    
       return isFull(root); 
    }
    private boolean isFull(Node<E> n){
        if(n == null)
            return true;
        else if((n.left == null && n.right != null)&&(n.left != null && n.right == null)){
            return false;
        }
        return  height(n.left) == height(n.right) && isFull(n.left) &&isFull(n.right);
    }
    /**
     * Consulta altura del arbol
     * @return 
     */
    public int height(){
        return height(root);
    }
    private int height(Node<E> n){
        if(n==null)
            return 0;
        else 
            return 1+ Math.max(height(n.left), height(n.right));
    }
    
    /**
    *Consulta si el arbol esta vacio
    */
    public boolean isEmpty(){
        return root==null;
    }
    /**
     * 
     * @return numero de nodos en el arbol
     */
    public int size(){
        return size(root);
    }
    private int size(Node<E> n){
        if(n==null) 
            return 0;
        else
            return 1+size(n.right)+size(n.left);
        
    }
    /**
     * 
     * @param child
     * @param parent
     * @return 
     */
    public boolean add(E child,E parent){
        Node<E> nc=searchNode(child);
        if(nc!=null) return false;
        nc= new Node<>(child);
        if(parent==null&&root==null){
            root=nc;
            return true;
        }
        Node<E> np=searchNode(parent);
        if(np!=null){
            if(np.left==null){
                np.left=nc;
                return true;
            }else if(np.right==null){
                np.right=nc;
                return true;
            }
        }
        return false;
    }
    /**
     * 
     * @param parent 
     * @return 
     */
    private Node<E> searchNode(E data){
        return searchNode(data, root);
    }
    
    /**
     * 
     * @param data
     * @param n
     * @return 
     */
    private Node<E> searchNode(E data, Node<E> n){
        if(n==null){
            return null;
        }
        else if(n.data.equals(data)){
            return n;
       }
        else{
            /*Node <E> nl=searchNode(data,n.left);
            Node <E> nr= searchNode(data,n.right);
            return (nl!=null)?nl:nr;
            */
            Node <E> nl=searchNode(data,n.left);
            if(nl!=null) return nl;
            return searchNode(data,n.right);
        }
    }
    /**
     * Elimina el elemento del arbol
     * @param child
     * @return 
     */
    public boolean remove(E child){
        if(child==null|| isEmpty()) return false;
        if(root.data.equals(child)){
            root = null;
            return true;
        }
        Node<E> np=searchParent(child);
        if(np!=null){
            if(np.left!=null && np.left.data.equals(child)){
                np.left = null;
            }else
                np.right = null;
            return true;
        }
        return false;
    }
    private Node<E> searchParent(E child){
        return searchParent(child, root);
    }
    private Node<E> searchParent(E child, Node<E> n){
        if(n==null) 
            return null;
        else if((n.left!=null && n.left.data.equals(child))|| (n.right!=null)&&n.right.data.equals(child))
            return n;
        else{
            Node<E> nl=searchParent(child,n.left);
            if(nl != null) return nl;
            return searchParent(child, n.right);
        }
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







































