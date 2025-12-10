/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Entrenador;
import Modelo.ServicioClase;
import Modelo.ServicioEntrenador;
import Vista.IVista;
import java.util.List;

/**
 *
 * @author pxand
 */
public class ControladorEntrenador implements IVista{
    private final ServicioEntrenador entrenador;
    private final ServicioClase servicioClase;
    private final IVista vista;

    public ControladorEntrenador(ServicioEntrenador entrenador, IVista vista) {
        this.entrenador = new ServicioEntrenador();
        this.servicioClase = new ServicioClase();
        this.vista = vista;
    }
    
    private Entrenador registrar(){
        
        return null;
        
    }
    
    private void actualizar(){
        
    }
    
    private boolean eliminar(){
        
        return false;
        
    }
    
    private Entrenador buscarPorId(){
        
        return null;
        
    }
    
    private List<Entrenador> obtenerTodos(){
        
        return null;
        
    }
    
    private boolean tieneClasesAsignadas(){
        
        return false;
        
    }

    @Override
    public void limpiar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean confirmar(String msg, String titulo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mostrarMensaje(String msg, String titulo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mostrarError(String msg) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String solicitar(String msg, String titulo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
        
}
