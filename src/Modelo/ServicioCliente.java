/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import DAO.ClienteDAO;
import DAO.IClienteDAO;
import DTO.ClienteDTO;
import Mappers.ClienteMapper;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import Modelo.TiposMembresia;

/**
 *
 * @author pxand
 */
public class ServicioCliente {

    private final IClienteDAO clienteDAO;
    private final ClienteMapper mapper;

    public ServicioCliente() {
        this.clienteDAO = new ClienteDAO();
        this.mapper = new ClienteMapper();
    }

    
    public Cliente registrar(String cedula, String nombre, String contactos, LocalDate fechaNacimiento, LocalDate fechaVencimiento, TiposMembresia tipo) throws Exception {// Validaciones
        ClienteDTO dto = new ClienteDTO(cedula.trim(), fechaNacimiento, fechaVencimiento, nombre.trim(), contactos.trim(), tipo);
        clienteDAO.insertar(dto);
        return mapper.ToEntidad(dto);
    }

    
    public void actualizar(String cedula, String nuevoNombre, String nuevosContactos, LocalDate nuevaFechaNacimiento, LocalDate nuevaFechaVencimiento, TiposMembresia nuevoTipo) throws Exception {
        ClienteDTO existente = clienteDAO.buscar(cedula);
        String nombreFinal = (nuevoNombre != null && !nuevoNombre.trim().isBlank()) ? nuevoNombre.trim() : existente.getNombre();
        String contactosFinal = (nuevosContactos != null && !nuevosContactos.trim().isBlank()) ? nuevosContactos.trim() : existente.getContactos();
        LocalDate fechaNacFinal = (nuevaFechaNacimiento != null) ? nuevaFechaNacimiento : existente.getFechaNacimientos();
        LocalDate fechaVenFinal = (nuevaFechaVencimiento != null) ? nuevaFechaVencimiento : existente.getFechaVencimiento();
        TiposMembresia tipoFinal = (nuevoTipo != null) ? nuevoTipo : existente.getTipo();
        ClienteDTO dtoActualizado = new ClienteDTO(cedula, fechaNacFinal, fechaVenFinal, nombreFinal, contactosFinal, tipoFinal);
        clienteDAO.actualizar(dtoActualizado);
    }

    
    public void eliminar(String cedula) throws Exception {
        clienteDAO.eliminar(cedula);
    }

    
    public Cliente buscarPorCedula(String cedula) throws Exception {
        ClienteDTO dto = clienteDAO.buscar(cedula);
        return dto != null ? mapper.ToEntidad(dto) : null;
    }

    
    public List<Cliente> obtenerTodos() throws Exception {
        return clienteDAO.obtenerTodas().stream()
                .map(mapper::ToEntidad)
                .collect(Collectors.toList());
    }

    
    public boolean membresiaVigente(Cliente cli) throws Exception {
        return cli.getFechaVencimiento().isAfter(LocalDate.now());
    }
}
