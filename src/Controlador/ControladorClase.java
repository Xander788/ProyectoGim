/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Clase;
import Modelo.ServicioClase;
import Vista.IVista;
import java.util.List;

/**
 *
 * @author pxand
 */
public class ControladorClase implements IVista{
    private final ServicioClase clase;
    private final IVista vista;

    public ControladorClase(ServicioClase clase, IVista vista) {
        this.clase = new ServicioClase();
        this.vista = vista;
    }

    public Clase registrar() {

        return null;

    }

    public void actualizar() {

    }

    public void eliminar() {

    }

    public List<Clase> obtenerTodas() {

        return null;

    }

    public List<Clase> buscarPorTipo(String tipo) {

        return null;

    }

    public Clase buscarPorId(int id) {

        return null;

    }

    public int obtenerSiguienteId() {

        return 0;

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
