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
    private final ServicioClase servicio;
    private final IVista vista;

    public ControladorClase(ServicioClase servicio, IVista vista) {
        this.servicio = servicio;
        this.vista = vista;
    }

    public void registrar(int id, String tipo, String horario, int capacidadMaxima, int idEntrenador) throws Exception {
        if (tipo == null || tipo.isBlank()) {
            throw new Exception("El tipo de clase es obligatorio");
        }
        if (horario == null || horario.isBlank()) {
            throw new Exception("El horario es obligatorio");
        }
        if (capacidadMaxima <= 0) {
            throw new Exception("La capacidad máxima debe ser mayor a 0");
        }
        if (idEntrenador <= 0) {
            throw new Exception("Debe seleccionar un entrenador válido");
        }

        
        servicio.registrar(id, tipo, horario, capacidadMaxima, idEntrenador);
        vista.mostrarMensaje("Clase registrada correctamente", "Éxito");
    }

    public void actualizar(int id, String tipo, String horario, Integer capacidadMaxima, Integer idEntrenador) throws Exception {
        Clase existente = servicio.buscarPorId(id);
        if (existente == null) {
            throw new Exception("Clase no encontrada");
        }

        String tipoFinal = (tipo != null && !tipo.isBlank()) ? tipo : existente.getTipo();
        String horarioFinal = (horario != null && !horario.isBlank()) ? horario : existente.getHorario();
        int capacidadFinal = (capacidadMaxima != null && capacidadMaxima > 0) ? capacidadMaxima : existente.getCapacidadMaxima();
        int entrenadorFinal = (idEntrenador != null && idEntrenador > 0) ? idEntrenador : existente.getIdEntrenador();

        servicio.actualizar(id, tipoFinal, horarioFinal, capacidadFinal, entrenadorFinal);
        vista.mostrarMensaje("Clase actualizada correctamente", "Éxito");
    }

    public void eliminar(int id) throws Exception {
        if (vista.confirmar("¿Seguro que desea eliminar esta clase?", "Confirmar eliminación")) {
            servicio.eliminar(id);
            vista.mostrarMensaje("Clase eliminada correctamente", "Éxito");
        }
    }

    public List<Clase> obtenerTodas() throws Exception {

        return servicio.obtenerTodas();

    }


    public Clase buscarPorId(int id) throws Exception {
        Clase clase = servicio.buscarPorId(id);
        if (clase == null) {
            vista.mostrarMensaje("Clase no encontrada", "Búsqueda");
            return null;
        }
        return clase;
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
