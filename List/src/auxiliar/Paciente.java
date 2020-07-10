/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auxiliar;

/**
 *
 * @author cajas
 */
public class Paciente {
    private String nombre;
    private int tiempo;
    private int edad;

    public Paciente(String nombre, int tiempo, int edad) {
        this.nombre = nombre;
        this.tiempo = tiempo;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    @Override
    public String toString(){
        return nombre+" de "+edad+" años: "+tiempo+ " minutos.";
    }
    
    public Paciente copy(){
        return new Paciente(nombre, tiempo, edad);
    }
}
