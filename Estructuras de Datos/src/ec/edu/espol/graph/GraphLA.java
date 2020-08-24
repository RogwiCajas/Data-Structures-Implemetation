/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.graph;

import java.util.LinkedList;
import java.util.ListIterator;
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
        Vertex<E> v = new Vertex<>(data);
        return (data == null || vertexes.contains(v))?false:vertexes.add(v);
    }
    
    public boolean removeVertex(E data){
        if(data == null || vertexes.isEmpty()) return false;
        ListIterator<Vertex<E>> iv = vertexes.listIterator();
        while(iv.hasNext()){
            Vertex<E> v = iv.next();
            ListIterator<Edge<E>> ie = v.getEdges().listIterator();
            while(ie.hasNext()){
                Edge<E> e = ie.next();
                if(e.getVdestino().getData().equals(data))
                    ie.remove();
            }
        }
        Vertex<E> vi = new Vertex<>(data);
        return vertexes.remove(vi);
    }
    
    public boolean addEdge(E src, E dst, int peso){
        if(src == null || dst == null) return false;
        Vertex<E> vs = searchVertex(src);
        Vertex<E> vd = searchVertex(dst);
        if(vs == null || vd == null) return false;
        Edge<E> e = new Edge<>(peso,vs,vd);
        if(!vs.getEdges().contains(e))
            vs.getEdges().add(e);
        if(!directed){
            Edge<E> ei = new Edge<>(peso,vd,vs);
            if(!vd.getEdges().contains(ei))
                vd.getEdges().add(ei);
        }
        return true;
    }
    
    public boolean removeEdge(E src, E dst){
        if(src == null || dst == null) return false;
        Vertex<E> vs = searchVertex(src);
        Vertex<E> vd = searchVertex(dst);
        if(vs == null || vd == null) return false;
        Edge<E> e = new Edge<>(0,vs,vd);
        vs.getEdges().remove(e);
        if(!directed){
            e = new Edge<>(0,vd,vs);
            vd.getEdges().remove(e);
        }
        return true;
    }
    
    @Override
    public String toString(){
        String vertices = "V:  " + vertexes.toString() + "\n";
        StringBuilder sb = new StringBuilder();
        sb.append(vertices);
        sb.append("E: [");
        ListIterator<Vertex<E>> iv=vertexes.listIterator();
        while(iv.hasNext()){//Recorro los vertices
            Vertex<E> v=iv.next();
            ListIterator<Edge<E>> ie=v.getEdges().listIterator();
            while(ie.hasNext()){//Recorro los arcos de cada vertice
                Edge<E> e=ie.next();
                sb.append(e.toString());
                sb.append(",");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]\n");
        return sb.toString();
    }
    /**
     * Retorna el Numero de relacones que tienen a element como destino
     * Retorna -1 si es null o element no es un vertice del graph
     * @param element
     * @return 
     */
    public int inDegree(E element){
        if(element == null) return -1;
        int entradas =0;
        if(searchVertex(element)==null) return -1;
        for(Vertex<E>  v: vertexes){
            for(Edge<E> e :v.getEdges()){
                if(e.getVdestino().getData().equals(element)){
                    entradas++;
                }
            }
            
        }
        return entradas;
    }
    /**
     * Retorna el numero de relaciones que tiene a element como origen.
     * Retorna -1 si el elemento es null o no se encuentra en la lista de vertices
     * @param element
     * @return 
     */
    public int outDegree(E element){
        if(element == null) return -1;
        Vertex<E> v=searchVertex(element);
        /*if(v == null) return -1;       
        return v.getEdges().size();*/
        return (v == null)? -1:v.getEdges().size();
    }
    
    private Vertex<E> searchVertex(E data){
        for(Vertex<E> v : vertexes)
        {
            if(v.getData().equals(data))
                return v;
        }
        return null;
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

        @Override
        public String toString() {
            return data.toString();
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

        @Override
        public String toString() {
            return "(" + vo + "," + vd + "," +peso+")";
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
            final Edge<E> other = (Edge<E>) obj;
            return Objects.equals(this.vo, other.vo) && Objects.equals(this.vd, other.vd);
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 97 * hash + Objects.hashCode(this.vo);
            hash = 97 * hash + Objects.hashCode(this.vd);
            return hash;
        }
    
    }

    
}







