/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.graph;

import java.util.LinkedList;
import java.util.Objects;

/**
 *
 * @author rogwi
 */
public class GraphLA<E> {
    private LinkedList<Vertex<E>> vertexes; 
    private boolean directed;

    public GraphLA(boolean directed) {
        this.directed = directed;
        vertexes = new LinkedList<>();
    }
    public boolean addVertex(E data){
        Vertex<E> v= new Vertex<>(data);
        return (data == null  | vertexes.contains(v))? false :
        vertexes.add(v);
    }
        
    
    
    
    
    //INNER CLASS----------------------------------------------------------------
    public class Vertex<E>{
        private E data;
        private LinkedList<Edge<E>> edges;

        public Vertex(E data) {
            this.data = data;
            edges = new LinkedList<>();
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public LinkedList<Edge<E>> getEdges() {
            return edges;
        }

        public void setEdges(LinkedList<Edge<E>> edges) {
            this.edges = edges;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Vertex<E> other = (Vertex<E>) obj;
        
            return Objects.equals(this.data, other.data);
         
        }   
    }
    public class Edge<E> {
        private int peso;
        private Vertex<E> vo;
        private Vertex<E> vd;

        public Edge(int peso, Vertex<E> vo, Vertex<E> vd) {
            this.peso = peso;
            this.vo = vo;
            this.vd = vd;
        }

        public int getPeso() {
            return peso;
        }

        public void setPeso(int peso) {
            this.peso = peso;
        }

        public Vertex<E> getVorigen() {
            return vo;
        }

        public void setVorigen(Vertex<E> vo) {
            this.vo = vo;
        }

        public Vertex<E> getVdestino() {
            return vd;
        }

        public void setVdestino(Vertex<E> vd) {
            this.vd = vd;
        }
    
    
    }

    
}







