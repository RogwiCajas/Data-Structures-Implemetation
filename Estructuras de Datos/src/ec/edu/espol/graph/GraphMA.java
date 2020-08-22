/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.graph;

import java.util.ArrayList;

/**
 *
 * @author rogwi
 */
public class GraphMA<E> {
    private ArrayList<E> vertexes;
    private int[][] matrix;
    private int capacity = 10;
    private boolean directed;
    
    public GraphMA(boolean directed){
        this.directed = directed;
        vertexes = new ArrayList<>();
        matrix = new int [capacity][capacity];
    }
    /**
     * Consulta si el grafo está vacio
     * @return 
     */
    public boolean isEmpty(){
        return vertexes.isEmpty();
    }
    /**
     * Agrega un vertice
     * @param data
     * @return 
     */
    public boolean addVertex(E data){
        if(vertexes.size() == capacity){
            //Deepcopy y shalllow copy de la matriz
        }
        return (data == null | vertexes.contains(data))?false :vertexes.add(data);
    }
    /**
     * Remueve un vertice tanto de la lista d evertices como de la matrix
     * de relaciones.
     * @param data
     * @return 
     */
    public boolean removeVertex(E data){
        if(data == null) return false;
        int iv=vertexes.indexOf(data);
        if(iv == -1) return false;
        
        for (int i = iv; i<vertexes.size(); i++){
            matrix[i] = matrix [i+1];
            for(int j= 0; j<vertexes.size();j++){
                matrix[j][i] = matrix[j][i+1];
            }            
        }
        vertexes.remove(iv);
        return true;
    }
    
    /**
     * Agrega una nueva relacion entre src y dest, si ya existe la sobreescribe
     * @param src
     * @param dest
     * @param peso
     * @return 
     */
    public boolean addEdge(E src, E dest,int peso){
        if(src == null | dest ==null) return false;
        int is = vertexes.indexOf(src);
        int id = vertexes.indexOf(dest);
        if(is==-1 | id== -1)return false;
        matrix[is][id]=peso;
        if(!directed){
            matrix[id][is] = peso;
        }
        return true;
    }
    /**
     * 
     * @param src
     * @param dest
     * @return 
     */
    public boolean removeEdge(E src, E dest){
        //return addEdge(src,dest,0);
        if(src == null | dest ==null) return false;
        int is = vertexes.indexOf(src);
        int id = vertexes.indexOf(dest);
        if(is==-1 | id== -1)return false;
        matrix[is][id] = 0;
        if(!directed){
            matrix[id][is] = 0;
        }
        return true;
        
    }
    /**
     * Devuelve la representacion en string de el grpho
     * vertices =[v1,v2,vn]
     * relaciones =[(v1,v2),...]
     * @return 
     */
    @Override
    public String toString(){
        return "";
    }
    
}









