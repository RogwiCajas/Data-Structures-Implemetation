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
        return addEdge(src,dest,0);
        /*if(src == null | dest ==null) return false;
        int is = vertexes.indexOf(src);
        int id = vertexes.indexOf(dest);
        if(is==-1 | id== -1)return false;
        matrix[is][id] = 0;
        if(!directed){
            matrix[id][is] = 0;
        }
        return true;*/
        
    }
    /**
     * Devuelve la representacion en string de el grpho
     * vertices =[v1,v2,vn]
     * relaciones =[(v1,v2),...]
     * @return 
     */
    @Override
    public String toString(){
        String v = "V:  " + vertexes.toString() + "\n";
        StringBuilder sb = new StringBuilder();
        sb.append(v);
        sb.append("E: [");
        for (int i = 0; i < vertexes.size(); i++) {
            for (int j = 0; j < vertexes.size(); j++) {
                if(matrix[i][j] != 0){
                    sb.append("(");
                    sb.append(vertexes.get(i)).append(",").append(vertexes.get(j)).append(",").append(matrix[i][j]);
                    sb.append(")").append(","); //(A,B,1),
                }
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
        int vd= vertexes.indexOf(element);
        if(vd == -1) return -1;
        //Recorro las filas y cuento
        int entradas = 0;
        for(int i = 0; i<vertexes.size(); i++){
            if(matrix[i][vd] != 0){
                entradas++;
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
        if(element== null){
            return -1;
        }
        int v=vertexes.indexOf(element);
        if( v == -1) return -1;
        int salidas=0;
        for(int i = 0 ; i<vertexes.size() ; i++){
            if(matrix[v][i]!=0) {
                salidas ++;
            }
        }
        return salidas;
    }
}









