/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Pago;
import Modelo.ServicioPago;
import Vista.IVista;
import java.util.List;

/**
 *
 * @author pxand
 */
public class ControladorPago implements IVista{
    private final ServicioPago Pago;
    private final IVista vista;

    public ControladorPago(ServicioPago Pago, IVista vista) {
        this.Pago = new ServicioPago();
        this.vista = vista;
    }
    
    private Pago registrarPago(){
        
        return null;
        
    }
    
    private List<Pago> listarPorCliente(){
        
        return null;
        
    }    
            
    private List<Pago> listarTodos(){
        
        return null;
        
    }      
    
    private Pago buscarPorId(){
        
        return null;
        
    }
    
    private void generarFactura(){
        
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
