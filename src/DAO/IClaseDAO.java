/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Modelo.Clase;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Jorge
 */
public interface IClaseDAO {
     void insertar(Clase clase) throws Exception;

    void actualizar(Clase clase) throws Exception;

    void eliminar(int id) throws Exception;

    Optional<Clase> buscar(int id) throws Exception;

    List<Clase> obtenerTodas() throws Exception;

    List<Clase> buscarPorTipo(String tipo) throws Exception;
}
