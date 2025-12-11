/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Cliente;
import Modelo.ServicioCliente;
import Modelo.TiposMembresia;
import Vista.IVista;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author pxand
 */
public class ControladorCliente implements IVista{
    private final ServicioCliente servicio;
    private final IVista vista;

    public ControladorCliente(ServicioCliente servicio,IVista vista ) {
        this.servicio = servicio;
        this.vista = vista;
    }
    
    public void registrar(String cedula, LocalDate fechaNacimiento, LocalDate fechaVencimiento, String nombre, String contacto, TiposMembresia tipo) throws Exception {
        if (cedula == null || cedula.isBlank()) {
            throw new Exception("La cédula es requerida");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new Exception("El nombre es requerido");
        }
        if (fechaNacimiento == null || fechaNacimiento.isAfter(LocalDate.now())) {
            throw new Exception("Fecha de nacimiento inválida");
        }
        if (fechaVencimiento == null || fechaVencimiento.isBefore(LocalDate.now())) {
            throw new Exception("Fecha de vencimiento inválida");
        }
        
        
                
        servicio.registrar(cedula,nombre,contacto,fechaNacimiento,fechaVencimiento,tipo);
    }
    
    
    public void actualizar(String cedula, LocalDate fechaNacimiento, LocalDate fechaVencimiento, String nombre, String contacto, TiposMembresia tipo) throws Exception{
        Cliente existente = servicio.buscarPorCedula(cedula);
        if (existente == null) {
            throw new Exception("Cliente no encontrado");
        }
        
        
        existente.setFechaNacimientos(fechaNacimiento != null ? fechaNacimiento : existente.getFechaNacimientos());
        existente.setNombre(nombre != null && !nombre.isBlank() ? nombre : existente.getNombre());
        existente.setContactos(contacto != null && !contacto.isBlank() ? contacto : existente.getContactos());
        existente.setTipo(tipo != null ? tipo : existente.getTipo());
        
        servicio.actualizar(existente.getCedula(), existente.getNombre(),existente.getContactos(),existente.getFechaNacimientos(),existente.getFechaVencimiento(),existente.getTipo());
    }
    
    public void eliminar(String cedula) throws Exception{
        if (cedula == null || cedula.isBlank()) {
            throw new Exception("La cédula es requerida");
        }
        
        Cliente cli = servicio.buscarPorCedula(cedula);
        if (cli == null) {
            throw new Exception("Cliente no encontrado");
        }
        
        if (!vista.confirmar("¿Está seguro de eliminar el cliente " + cli.getNombre() + "?", "Confirmar eliminación")) {
            return;
        }
        
        servicio.eliminar(cedula);
        
    }
    
    public Cliente buscarPorCedula(String cedula) throws Exception{
        if (cedula == null || cedula.isBlank()) {
            throw new Exception("La cédula es requerida");
        }
        
        return servicio.buscarPorCedula(cedula);
        

    }
    
    public List<Cliente> obtenerTodos() throws Exception{
        return servicio.obtenerTodos();
        
    }
    
    private boolean membresiaVigente(Cliente cli) throws Exception{
        String cedula = cli.getCedula();
        
        
        cli = servicio.buscarPorCedula(cedula);
        if (cli == null) {
            throw new Exception("Cliente no encontrado");
        }
        return servicio.membresiaVigente(cli);
        
    }

    @Override
    public void limpiar() {
        vista.limpiar();
    }

    @Override
    public void cambiarEstadoCampos(boolean estado) {
        vista.cambiarEstadoCampos(estado);
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
        return vista.confirmar(msg, titulo);
    }

    @Override
    public void mostrarMensaje(String msg, String titulo) {
        vista.mostrarError(msg);
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
