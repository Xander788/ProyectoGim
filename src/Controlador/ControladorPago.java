/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Pago;
import Modelo.ServicioPago;
import Vista.IVista;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author pxand
 */
public class ControladorPago implements IVista{
    private final ServicioPago servicio;
    private final IVista vista;

    public ControladorPago(ServicioPago servicio, IVista vista) {
        this.servicio = servicio;
        this.vista = vista;
    }
    
    public void registrarPago(String idCliente, double subtotal,String formatofactura) throws Exception{
        if (idCliente == null || idCliente.isBlank()) {
            throw new Exception("El ID del cliente es obligatorio");
        }
        if (subtotal <= 0) {
            throw new Exception("El subtotal debe ser mayor a 0");
        }

        servicio.registrarPago(idCliente,subtotal,formatofactura);
        vista.mostrarMensaje("Pago registrado correctamente", "Éxito");
        
    }
    
    private List<Pago> listarPorCliente(String idCliente) throws Exception{
        
        return servicio.listarPorCliente(idCliente);
        
    }    
            
    public List<Pago> listarTodos() throws Exception{
        
        return servicio.listarTodos();
        
    }      
    
    public Pago buscarPorId(int id) throws Exception{
        
        return servicio.buscarPorId(id);
        
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
