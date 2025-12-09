/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import DAO.IUsuarioDAO;
import DAO.UsuarioDAO;
import DTO.UsuarioDTO;
import Mappers.UsuarioMapper;
import java.util.List;
import java.util.stream.Collectors;


/**
 *
 * @author pxand
 */
public class ServicioUsuario {
    private final IUsuarioDAO usuarioDAO;
    private final UsuarioMapper mapper;

    public ServicioUsuario() {
        this.usuarioDAO = new UsuarioDAO();
        this.mapper = new UsuarioMapper();
    }

    public Usuario registrar(int idManual, String nombreUsuario, String contrasenaPlana, Roles rol) throws Exception {

        String contrasenaEncriptada = encriptarConHashCode(contrasenaPlana);
        UsuarioDTO dto = new UsuarioDTO(idManual, nombreUsuario, contrasenaEncriptada, rol);
        usuarioDAO.insertar(dto);
        return mapper.ToEntidad(dto);
    }
    
    public Usuario login(String nombreUsuario, String contrasena) throws Exception {
        for (UsuarioDTO dto : usuarioDAO.obtenerTodas()) {
            if (dto.getNombreUsuario().equals(nombreUsuario)) {
                String hashAlmacenado = dto.getContrasena();
                String hashIngresado = encriptarConHashCode(contrasena);
                if (hashAlmacenado.equals(hashIngresado)) {
                    return mapper.ToEntidad(dto);
                }
            }
        }
        return null;
    }
    
    public void actualizar(int id, String nuevoNombre, String nuevaContrasena, Roles nuevoRol) throws Exception {
        UsuarioDTO existente = null;
        for (UsuarioDTO u : usuarioDAO.obtenerTodas()) {
            if (u.getId() == id) {
                existente = u;
                break;
            }
        }

        String nuevaHash = existente.getContrasena();
        if (nuevaContrasena != null && !nuevaContrasena.trim().isEmpty()) {
            nuevaHash = encriptarConHashCode(nuevaContrasena);
        }

        UsuarioDTO actualizado = new UsuarioDTO(
            id,
            nuevoNombre != null ? nuevoNombre : existente.getNombreUsuario(),
            nuevaHash,
            nuevoRol != null ? nuevoRol : existente.getRol()
        );

        usuarioDAO.actualizar(actualizado);
    }
    
    public void eliminar(int id) throws Exception {
        usuarioDAO.eliminar(id);
    }
    
    public List<Usuario> obtenerTodos() throws Exception {
        return usuarioDAO.obtenerTodas().stream()
                .map(mapper::ToEntidad)
                .collect(Collectors.toList());
    }
    
    
    private String encriptarConHashCode(String texto) {
        return Integer.toHexString((texto).hashCode());
    }
}
