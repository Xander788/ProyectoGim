/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositorios;

import Modelo.Clase;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Jorge
 */
public interface IRepositorioClase {
     public void guardar(Clase c);

    public Optional<Clase> buscar(String id);

    public void eliminar(String id);

    public List<Clase> obtenerTodo();
}
