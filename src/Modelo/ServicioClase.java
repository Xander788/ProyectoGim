/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import DAO.ClaseDAO;
import DAO.EntrenadorDAO;
import DAO.IClaseDAO;
import DTO.ClaseDTO;
import Mappers.ClaseMapper;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author pxand
 */
public class ServicioClase {
    private final IClaseDAO claseDAO;
    private final ClaseMapper mapper;
    private final EntrenadorDAO entrenadorDAO;

    public ServicioClase() {
        this.claseDAO = new ClaseDAO();
        this.entrenadorDAO = new EntrenadorDAO();
        this.mapper = new ClaseMapper();
    }
    
    public void registrar(int idManual, String tipo, String horario, int capacidadMaxima, int idEntrenador) throws Exception {
        Clase clase = new Clase(idManual, tipo.trim(), horario, capacidadMaxima, idEntrenador);
        if (clase.validar()==false) {
            return ;
        }

        ClaseDTO dto = new ClaseDTO(idManual, tipo.trim(), horario, capacidadMaxima, idEntrenador);
        claseDAO.insertar(dto);

        
    }

    public void actualizar(int id, String tipo, String horario, int capacidadMaxima, int idEntrenador) throws Exception {

        ClaseDTO existente = claseDAO.buscar(id);
        if (existente == null){
            return;
        }

        String tipoFinal = (tipo != null && !tipo.trim().isBlank()) ? tipo.trim() : existente.getTipo();
        int capacidadFinal = capacidadMaxima > 0 ? capacidadMaxima : existente.getCapacidadMaxima();
        int entrenadorFinal = idEntrenador > 0 ? idEntrenador : existente.getIdEntrenador();

        Clase claseActualizada = new Clase(id, tipoFinal, horario, capacidadFinal, entrenadorFinal);
        if (claseActualizada.validar()==false){
            return;
        }

        ClaseDTO dto = new ClaseDTO(id, tipoFinal, horario, capacidadFinal, entrenadorFinal);
        claseDAO.actualizar(dto);
    }

    
    public void eliminar(int id) throws Exception {
        if (claseDAO.buscar(id) == null) {
            return;
        }
        claseDAO.eliminar(id);
    }

    
    public List<Clase> obtenerTodas() throws Exception {
        return claseDAO.obtenerTodas().stream()
                .map(dto -> mapper.ToEntidad(dto, dto.getIdEntrenador()))
                .collect(Collectors.toList());
    }


    
    public Clase buscarPorId(int id) throws Exception {
        ClaseDTO dto = claseDAO.buscar(id);
        if (dto == null) return null;
        return mapper.ToEntidad(dto, dto.getIdEntrenador());
    }

    
    public int obtenerSiguienteId() throws Exception {
        return claseDAO.obtenerTodas().stream()
                .mapToInt(ClaseDTO::getId)
                .max()
                .orElse(0) + 1;
    }
}
    

