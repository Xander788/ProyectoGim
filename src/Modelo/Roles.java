/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Modelo;

/**
 *
 * @author pxand
 */
public enum Roles {
    ADMINISTRADOR("Administrador"),ENTRENADOR("Entrenador");
    
    private final String roles;

    private Roles(String roles) {
        this.roles = roles;
    }

    public String getRoles() {
        return roles;
    }
}
