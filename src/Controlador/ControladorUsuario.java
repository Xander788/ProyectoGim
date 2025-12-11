/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Roles;
import Modelo.ServicioUsuario;
import Modelo.Usuario;
import Vista.IVista;
import java.util.List;

/**
 *
 * @author pxand
 */
public class ControladorUsuario implements IVista{
    private final ServicioUsuario servicio;
    private final IVista vista;

    public ControladorUsuario(ServicioUsuario servicio, IVista vista) {
        this.servicio = servicio;
        this.vista = vista;   
    }
    
    public void registrar(int id, String nombreUsuario, String contrasenaPlana, Roles rol) throws Exception{
        servicio.registrar(id, nombreUsuario, contrasenaPlana, rol);
  
    }
    
    public Usuario buscar(int id){
        try {
            Usuario usuario = servicio.obtenerTodos().stream()
                    .filter(u -> u.getId() == id)
                    .findFirst()
                    .orElse(null);
            if (usuario != null) {
                return usuario;
            } else {
                vista.mostrarError("Usuario no encontrado");
            }
        } catch (Exception ex) {
            vista.mostrarError(ex.getMessage());
        }
        return null;
    }
    
    public void actualizar(int id, String nuevoNombre, String nuevaContrasena, Roles nuevoRol){
        try {
            servicio.actualizar(id, nuevoNombre, nuevaContrasena, nuevoRol);
            vista.mostrarMensaje("Usuario actualizado correctamente", "Éxito");
        } catch (Exception ex) {
            vista.mostrarError(ex.getMessage());
        }
    }
    
    public void eliminar(int id){
        try {
            if (vista.confirmar("¿Seguro que desea eliminar este usuario?", "Confirmar eliminación")) {
                servicio.eliminar(id);
                vista.limpiar();
            }
        } catch (Exception ex) {
            vista.mostrarError(ex.getMessage());
        }
    }
    
    public List<Usuario> obtenerTodos() throws Exception{
        return servicio.obtenerTodos();
        
    }
    
    public boolean login(String nombreUsuario, String contrasenaPlana) {
        try {
            Usuario usuario = servicio.login(nombreUsuario, contrasenaPlana);
            if (usuario != null) {
                return true;
            } else {
                vista.mostrarError("Usuario o contraseña incorrectos");
                return false;
            }
        } catch (Exception ex) {
            vista.mostrarError("Error en el sistema: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public void limpiar() {
        vista.limpiar();
    }

    @Override
    public void cambiarEstadoCampos(boolean estado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void habilitarCampos() {
        IVista.super.habilitarCampos(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void deshabilitarCampos() {
        IVista.super.deshabilitarCampos(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void mostrarDatos(Object entidad) {
        vista.mostrarDatos(entidad);
    }

    @Override
    public boolean confirmar(String msg, String titulo) {
        return vista.confirmar(msg, titulo);
    }

    @Override
    public void mostrarMensaje(String msg, String titulo) {
        vista.mostrarMensaje(msg, titulo);
    }

    @Override
    public void mostrarError(String msg) {
        vista.mostrarError(msg);
    }

    @Override
    public String solicitar(String msg, String titulo) {
        return vista.solicitar(msg, titulo);
    }
    
            
}
