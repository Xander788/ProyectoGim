/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author pxand
 */
public class EntrenadorDTO {
    private int id;
    private String contacto;
    private String nombre;
    private String especialidad;

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

    public EntrenadorDTO(int id, String contacto, String nombre, String especialidad) {
        this.id = id;
        this.contacto = contacto;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }
    
    
}
