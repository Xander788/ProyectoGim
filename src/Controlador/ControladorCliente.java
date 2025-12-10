/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Cliente;
import Modelo.ServicioCliente;
import Vista.IVista;
import java.util.List;

/**
 *
 * @author pxand
 */
public class ControladorCliente implements IVista{
    private final ServicioCliente cliente;
    private final IVista vista;

    public ControladorCliente(ServicioCliente servicioCliente,IVista vista ) {
        this.cliente = new ServicioCliente();
        this.vista = vista;
    }
    
    private void registrar() {
        
    }
    
    
    private void actualizar(){
        
    }
    
    private void eliminar(){
        
    }
    
    private Cliente buscarPorCedula(){

        return null;

    }
    
    private List<Cliente> obtenerTodos(){
        
        return null;
        
    }
    
    private boolean membresiaVigente(Cliente cli){
        
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
