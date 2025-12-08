/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import DTO.UsuarioDTO;
import java.util.List;

/**
 *
 * @author Jorge
 */
public interface IUsuarioDAO {
    void insertar(UsuarioDTO dto) throws Exception;
    
    void actualizar(UsuarioDTO dto) throws Exception;
    
    void eliminar(int id) throws Exception;
    
    UsuarioDTO buscar(int id) throws Exception;
    
    List<UsuarioDTO> obtenerTodas() throws Exception;
    
}
