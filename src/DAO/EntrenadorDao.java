/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Modelo.Entrenador;
import java.util.List;

/**
 *
 * @author danny
 */
public interface EntrenadorDao {

    void actualizar(Entrenador entrenador);

    void eliminar(int id);

    int crear(Entrenador entrenador);

    Entrenador buscarId(int id);

    List<Entrenador> listarTodo();

    List<Entrenador> buscarNombre(String nombre);

    List<Entrenador> buscarEspecialidad(String especialidad);

}
