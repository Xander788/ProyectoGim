 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import DTO.ClaseDTO;
import java.util.List;


/**
 *
 * @author Jorge
 */
public interface IClaseDAO {
     void insertar(ClaseDTO clase) throws Exception;

    void actualizar(ClaseDTO clase) throws Exception;

    void eliminar(int id) throws Exception;

    ClaseDTO buscar(int id) throws Exception;

    List<ClaseDTO> obtenerTodas() throws Exception;

    List<ClaseDTO> buscarPorTipo(String tipo) throws Exception;
}
