/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Cliente;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author danny
 */
public class ClienteDaoI implements ClienteDao{
    
    private static List<Cliente> clientesDB = new ArrayList<>();
    
    
    

    @Override
    public Cliente buscarCedula(String cedula) {
        return clientesDB.stream().filter(c -> c.getCedula().equals(cedula)).findFirst().orElse(null);
    }

    @Override
    public List<Cliente> listartodos() {
        return new ArrayList<>(clientesDB);
    }

    @Override
    public List<Cliente> buscarPorNombre(String nombre) {
        return clientesDB.stream().filter(c -> c.getNombre().toLowerCase().contains(nombre.toLowerCase())).collect(Collectors.toList());
    }

    @Override
    public List<Cliente> buscarPorMembresia(String membresia) {
        return clientesDB.stream().filter(c -> c.getTipo().equalsIgnoreCase(membresia)) .collect(Collectors.toList());
    }

    @Override
    public List<Cliente> buscarPorVencimientoProximo(int dias) {
LocalDate limite = LocalDate.now().plusDays(dias);
        return clientesDB.stream().filter(c -> !c.getFechaVencimiento().isAfter(limite)).collect(Collectors.toList());
    }


    @Override
    public void crear(Cliente cliente) {
        if (buscarCedula(cliente.getCedula()) != null) {
            try {
                throw new Exception("Ya existe alguien con esa cedula");
            } catch (Exception ex) {
                System.getLogger(ClienteDaoI.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
        clientesDB.add(cliente);
    }

    @Override
    public void actualizar(Cliente cliente) {
// falta crear esta parte de aca 
    }

    @Override
    public void eliminar(String cedula) {
        clientesDB.removeIf(c -> c.getCedula().equals(cedula));
    }
    
    
    
    
}
