/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidenciajava;

/**
 *
 * @author Alan Franco
 */
public class Doctor {
    
    String id;
    String nombre;
    String especialidad;
    
    public Doctor(String id, String nombre, String especialidad){
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nNombre: " + nombre + "\nEspecialidad: " + especialidad + "\n";
    }
  
    
}
