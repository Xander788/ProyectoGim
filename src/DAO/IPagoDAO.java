/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;
import DTO.PagoDTO;
import java.util.List;
/**
 *
 * @author Jorge
 */

public interface IPagoDAO {

    void insertar(PagoDTO pago) throws Exception;

    PagoDTO buscar(int id) throws Exception;

    List<PagoDTO> listarPorCliente(int idCliente) throws Exception;

    List<PagoDTO> listarTodos() throws Exception;
}
