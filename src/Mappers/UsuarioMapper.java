/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import DTO.UsuarioDTO;
import Modelo.Usuario;

/**
 *
 * @author pxand
 */
public class UsuarioMapper {
    public UsuarioDTO ToDto(Usuario usu){
        return new UsuarioDTO(usu.getId(),usu.getNombreUsuario(),usu.getContrasena(),usu.getRol());
    }
    
    public Usuario ToEntidad(UsuarioDTO usu){
        return new Usuario(usu.getId(),usu.getNombreUsuario(),usu.getContrasena(),usu.getRol());
    }
}
