/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import DAO.ClaseDAO;
import DAO.EntrenadorDAO;
import DAO.IEntrenadorDAO;
import DTO.EntrenadorDTO;
import Mappers.EntrenadorMapper;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author pxand
 */
public class ServicioEntrenador {
    private final IEntrenadorDAO entrenadorDAO;
    private final EntrenadorMapper mapper;
    private final ServicioClase servicioClase;

    public ServicioEntrenador() {
        this.entrenadorDAO = new EntrenadorDAO();
        this.mapper = new EntrenadorMapper();
        this.servicioClase = new ServicioClase();
        
    }
    
    public Entrenador registrar(String nombre, String contacto, String especialidad) throws Exception {

        if (nombre == null || nombre.trim().isBlank()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        if (contacto == null || contacto.trim().isBlank()) {
            throw new IllegalArgumentException("El contacto es obligatorio");
        }
        if (especialidad == null || especialidad.trim().isBlank()) {
            throw new IllegalArgumentException("La especialidad es obligatoria");
        }

        final String nombreFinal = nombre.trim();
        final String contactoFinal = contacto.trim();
        final String especialidadFinal = especialidad.trim();

        boolean existeNombre = entrenadorDAO.obtenerTodas().stream()
                .anyMatch(e -> e.getNombre().equalsIgnoreCase(nombreFinal));

        if (existeNombre) {
            throw new Exception("Ya existe un entrenador con el nombre '" + nombreFinal + "'");
        }

        EntrenadorDTO dtoTemporal = new EntrenadorDTO(0, contactoFinal, nombreFinal, especialidadFinal);
        entrenadorDAO.insertar(dtoTemporal);

        EntrenadorDTO creado = entrenadorDAO.obtenerTodas().stream()
                .filter(e -> e.getNombre().equalsIgnoreCase(nombreFinal)
                && e.getContacto().equals(contactoFinal))
                .findFirst()
                .orElseThrow(() -> new Exception("Error al recuperar el entrenador creado"));

        return mapper.ToEntidad(creado);
    }
    
    public void actualizar(int id, String nuevoNombre, String nuevoContacto, String nuevaEspecialidad) throws Exception {

        EntrenadorDTO existente = entrenadorDAO.buscar(id);
        if (existente == null) {
            throw new Exception("No se encontró entrenador con ID " + id);
        }

        String nombreFinal = (nuevoNombre != null && !nuevoNombre.trim().isBlank()) ? nuevoNombre.trim() : existente.getNombre();
        String contactoFinal = (nuevoContacto != null && !nuevoContacto.trim().isBlank()) ? nuevoContacto.trim() : existente.getContacto();
        String especialidadFinal = (nuevaEspecialidad != null && !nuevaEspecialidad.trim().isBlank()) ? nuevaEspecialidad.trim() : existente.getEspecialidad();

        boolean nombreEnUso = entrenadorDAO.obtenerTodas().stream()
                .anyMatch(e -> e.getNombre().equalsIgnoreCase(nombreFinal) && e.getId() != id);
        if (nombreEnUso) {
            throw new Exception("El nombre '" + nombreFinal + "' ya está en uso por otro entrenador");
        }

        EntrenadorDTO dtoActualizado = new EntrenadorDTO(id, contactoFinal, nombreFinal, especialidadFinal);
        entrenadorDAO.actualizar(dtoActualizado);
    }

    public boolean eliminar(int id) throws Exception {
        if (entrenadorDAO.buscar(id) == null || tieneClasesAsignadas(id)) {
            return false;
        }
        entrenadorDAO.eliminar(id);
        return true;
    }
    
    public Entrenador buscarPorId(int id) throws Exception {
        EntrenadorDTO dto = entrenadorDAO.buscar(id);
        if (dto == null) {
            return null;
        }
        return mapper.ToEntidad(dto);
    }

    public List<Entrenador> obtenerTodos() throws Exception {
        return entrenadorDAO.obtenerTodas().stream()
                .map(mapper::ToEntidad)
                .collect(Collectors.toList());
    }
 
    public List<Entrenador> buscarPorEspecialidad(String especialidad) throws Exception {
        if (especialidad == null || especialidad.trim().isBlank()) {
            return obtenerTodos();
        }
        String esp = especialidad.trim();
        return entrenadorDAO.obtenerTodas().stream()
                .filter(e -> e.getEspecialidad().toLowerCase().contains(esp.toLowerCase()))
                .map(mapper::ToEntidad)
                .collect(Collectors.toList());
    }
    
    public boolean tieneClasesAsignadas(int idEntrenador) throws Exception {
        
        return servicioClase.obtenerTodas().stream()
                .anyMatch(c -> c.getIdEntrenador() == idEntrenador);
    }
}
