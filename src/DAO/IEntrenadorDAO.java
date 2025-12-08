/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import DTO.EntrenadorDTO;
import java.util.List;

/**
 *
 * @author Jorge
 */
public interface IEntrenadorDAO {
    void insertar(EntrenadorDTO dto) throws Exception;
    
    void actualizar(EntrenadorDTO dto) throws Exception;
    
    void eliminar(int id) throws Exception;
    
    EntrenadorDTO buscar(int id) throws Exception;
    
    List<EntrenadorDTO> obtenerTodas() throws Exception;
    
}
