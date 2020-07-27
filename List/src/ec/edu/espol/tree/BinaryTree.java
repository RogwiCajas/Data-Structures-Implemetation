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
    *Consulta si el arbol esta vacio
    */
    public boolean isEmpty(){
        return root==null;
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
}










