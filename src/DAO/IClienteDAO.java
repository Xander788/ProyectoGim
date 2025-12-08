/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import DTO.ClienteDTO;
import java.util.List;

/**
 *
 * @author Jorge
 */
public interface IClienteDAO {
    void insertar(ClienteDTO dto) throws Exception;
    
    void actualizar(ClienteDTO dto) throws Exception;
    
    void eliminar(String cedula) throws Exception;
    
    ClienteDTO buscar(String cedula) throws Exception;
    
    List<ClienteDTO> obtenerTodas() throws Exception;
    
}
