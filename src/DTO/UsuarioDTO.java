/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import Modelo.Roles;

/**
 *
 * @author pxand
 */
public class UsuarioDTO {
   private int id;
   private String nombreUsuario;
   private String contrasena;
   private Roles rol;

    public UsuarioDTO(int id, String nombreUsuario, String contrasena, Roles rol) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    public int getId() {
        return id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public Roles getRol() {
        return rol;
    }
   
   
    
}
