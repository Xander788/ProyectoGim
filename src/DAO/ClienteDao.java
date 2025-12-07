/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Modelo.Cliente;
import java.util.List;

/**
 *
 * @author danny
 */
public interface ClienteDao {

    Cliente buscarCedula(String cedula);

    List<Cliente> listartodos();

    List<Cliente> buscarPorNombre(String nombre);

    List<Cliente> buscarPorMembresia(String membresia);

    List<Cliente> buscarPorVencimientoProximo(int dias);

    void crear(Cliente cliente);

    void actualizar(Cliente cliente);

    void eliminar(String cedula);

}
