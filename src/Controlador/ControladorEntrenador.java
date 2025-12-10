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
    private final ServicioEntrenador servicio;
    private final IVista vista;

    public ControladorEntrenador(ServicioEntrenador servicio, IVista vista) {
        this.servicio = servicio;
        this.vista = vista;
    }
    
    public Entrenador registrar(String nombre, String contacto, String especialidad) throws Exception{
        try {
            if (nombre.isEmpty() || contacto.isEmpty() || especialidad.isEmpty()) {
                vista.mostrarError("Todos los campos son obligatorios");
                return null;
            }
            vista.limpiar();
        } catch (Exception e) {
            vista.mostrarError("Error al registrar entrenador: " + e.getMessage());
        }
        return servicio.registrar(nombre, contacto, especialidad);
    }
    
    public void actualizar(int id, String nuevoNombre, String nuevoContacto, String nuevaEspecialidad) throws Exception{
        try {
            String stid = String.valueOf(id);
            if (stid.isBlank()) {
                vista.mostrarError("El ID es obligatorio para actualizar");
                return;
            }
            if (nuevoNombre.isEmpty() || nuevoContacto.isEmpty() || nuevaEspecialidad.isEmpty()) {
                vista.mostrarError("Todos los campos son obligatorios");
                return;
            }

            servicio.actualizar(id, nuevoNombre, nuevoContacto, nuevaEspecialidad);
            
        } catch (NumberFormatException e) {
            vista.mostrarError("ID no válido");
        } catch (Exception e) {
            vista.mostrarError("Error al actualizar: " + e.getMessage());
        }
    }
    
    public boolean eliminar(int id) throws Exception{
        try {
            String stid = String.valueOf(id);
            if (stid.isEmpty()) {
                vista.mostrarError("Ingrese el ID para eliminar");
                return false;
            }
            if (servicio.tieneClasesAsignadas(id)) {
                vista.mostrarError("No se puede eliminar: el entrenador tiene clases asignadas");
                return false;
            }

            if (vista.confirmar("¿Está seguro de eliminar este entrenador?", "Confirmar eliminación")) {
                boolean eliminado = servicio.eliminar(id);
                if (eliminado) {
                    vista.limpiar();
                    return true;
                } else {
                    vista.mostrarError("No se encontró el entrenador o ya fue eliminado");
                }
            }
        } catch (NumberFormatException e) {
            vista.mostrarError("ID no válido");
        } catch (Exception e) {
            vista.mostrarError("Error al eliminar: " + e.getMessage());
        }
        return false;
    }
    
    private Entrenador buscarPorId(int id) throws Exception{
        try {
            String stid = String.valueOf(id);
            if (stid.isEmpty()) {
                vista.mostrarError("Ingrese el ID para buscar");
                return null;
            }

            Entrenador encontrado = servicio.buscarPorId(id);
            if (encontrado != null) {
                return encontrado;
            } else {
                vista.mostrarError("Entrenador no encontrado con ID: " + id);
                vista.limpiar();
            }

        } catch (NumberFormatException e) {
            vista.mostrarError("ID no válido");
        } catch (Exception e) {
            vista.mostrarError("Error en la búsqueda: " + e.getMessage());
        }
        return null;
    }
    
    private List<Entrenador> obtenerTodos() throws Exception{
        return servicio.obtenerTodos();
    }
    
    private List<Entrenador> buscarPorEspecialidad(String especialidad) throws Exception{
        return servicio.buscarPorEspecialidad(especialidad);
    }
    
    private boolean tieneClasesAsignadas(int idEntrenador) throws Exception{
        return servicio.tieneClasesAsignadas(idEntrenador);
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
