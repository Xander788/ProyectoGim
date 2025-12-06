/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;

/**
 *
 * @author danny
 */
public class Cliente {
    
    private String cedula;
    private LocalDate fechaNacimientos;
    private LocalDate fechaVencimiento;
    private String nombre;
    private String contactos;
    private String tipo;

    public Cliente(String cedula, LocalDate fechaNacimientos, LocalDate fechaVencimiento, String nombre, String contactos, String tipo) {
        this.cedula = cedula;
        this.fechaNacimientos = fechaNacimientos;
        this.fechaVencimiento = fechaVencimiento;
        this.nombre = nombre;
        this.contactos = contactos;
        this.tipo = tipo;
    }

    public String getCedula() {
        return cedula;
    }

    public LocalDate getFechaNacimientos() {
        return fechaNacimientos;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContactos() {
        return contactos;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return nombre + " "+ cedula ;
    }
    
    
}
