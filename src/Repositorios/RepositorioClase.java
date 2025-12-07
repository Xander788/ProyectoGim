/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositorios;

import Modelo.Clase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 *
 * @author Jorge
 */
public class RepositorioClase implements IRepositorioClase {

    private final Map<String, Clase> data = new HashMap<>();

    @Override
    public void guardar(Clase c) {
       data.put(String.valueOf(c.getId()), c);
    }

    @Override
    public Optional<Clase> buscar(String id) {
       return Optional.ofNullable(data.get(id));
    }

    @Override
    public void eliminar(String id) {
       data.remove(id);
    }

    @Override
    public List<Clase> obtenerTodo() {
        return new ArrayList<>(data.values());
    }

}
