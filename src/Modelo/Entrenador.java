/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author danny
 */
public class Entrenador {
    private int id;
    private String contacto;
    private String nombre;
    private String especialidad;

    public Entrenador(int id, String contacto, String nombre, String especialidad) {
        this.id = id;
        this.contacto = contacto;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public int getId() {
        return id;
    }

    public String getContacto() {
        return contacto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return id +" "+ nombre+ " ("+especialidad+")" ;
    }
    
    
}
