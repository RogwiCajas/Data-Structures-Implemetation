/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.util;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author cajas
 */
public class SetSL<E> {
    private LinkedList<E> lista;
    private Comparator<E> f;
    
    public SetSL(Comparator<E> f){
        this.lista=new LinkedList<>();
        this.f=f;
    }
    public boolean add(E element){
        if(element==null) return false;
        if(lista.isEmpty()|| f.compare(element,lista.getLast())>0) 
            return lista.add(element);
        ListIterator<E> lit=lista.listIterator();
        while(lit.hasNext()){
            E data=lit.next();
            int x=f.compare(data, element);
            if(x==0){
                return false;
            }
            if(x>0){
                lit.previous();
                lit.add(element);
                return true;
            }
        }
        return false;
    }
    public SetSL<E> interseccion(SetSL<E> s){
        SetSL<E> resultado= new SetSL<>(this.f);
        ListIterator<E> xa=this.lista.listIterator();
        ListIterator<E> xb=s.lista.listIterator();
        while(xa.hasNext()&&xb.hasNext()){
            E ea=xa.next();
            E eb=xb.next();
            
            int x=f.compare(ea,eb);
            if(x==0){
                resultado.lista.add(eb);
            }
            if(x>0){
                xa.previous();
            }else
                xb.previous();
                     
                    
        }
        return resultado;
    }
    
    
    
    
    
    
    
    
    
    
    
}
