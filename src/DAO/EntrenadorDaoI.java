/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Entrenador;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 *
 * @author danny
 */
public class EntrenadorDaoI implements EntrenadorDao {
    private static List<Entrenador> entrenadorDB = new ArrayList<>();
    
    
    //jorge, esto del static maybe tiene que quitarlo cuando vaya hacer la BD ya q estoy haceiendo como simulaciones prueba
    private static AtomicInteger contadorId = new AtomicInteger(1);
  

    @Override
    public void actualizar(Entrenador entrenador) {
      Entrenador existente = buscarId(entrenador.getId());
        
        if (existente == null) {
          try {
              throw new Exception("Entrenador con ID " + entrenador.getId() + " no encontrado.");
          } catch (Exception ex) {
              System.getLogger(EntrenadorDaoI.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
          }
        }

        if (entrenador.getNombre() == null || entrenador.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del entrenador es obligatorio para la actualizacion.");
        }

        existente.setNombre(entrenador.getNombre());
        existente.setContacto(entrenador.getContacto());
        existente.setEspecialidad(entrenador.getEspecialidad());
    }

    @Override
    public void eliminar(int id) {
        entrenadorDB.removeIf(e -> e.getId() == id);
    }

    @Override
    public int crear(Entrenador entrenador) {
        if (entrenador.getNombre() == null || entrenador.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del entrenador es obligatorio.");
        }
        
        int nuevoId = contadorId.getAndIncrement();
        entrenador.setId(nuevoId);
        entrenadorDB.add(entrenador);
        return nuevoId;
    }

    @Override
    public Entrenador buscarId(int id) {
        return entrenadorDB.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Entrenador> listarTodo() {
        return new ArrayList<>(entrenadorDB);
    }

    @Override
    public List<Entrenador> buscarNombre(String nombre) {
        if(nombre==null) return listarTodo();
        String nombreMinuscula = nombre.toLowerCase().trim();
        return entrenadorDB.stream().filter(e -> e.getNombre().toLowerCase().contains(nombreMinuscula)).collect(Collectors.toList());
    }

    @Override
    public List<Entrenador> buscarEspecialidad(String especialidad) {
        if (especialidad==null) return listarTodo();
        String especialidadMinuscula=especialidad.toLowerCase().trim();
        return entrenadorDB.stream().filter(e -> e.getEspecialidad().toLowerCase().contains(especialidadMinuscula)).collect(Collectors.toList());
    }
    
    
}
