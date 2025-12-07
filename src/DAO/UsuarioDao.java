/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Modelo.Usuario;
import java.util.List;

/**
 *
 * @author danny
 */
public interface UsuarioDao {

    int crear(Usuario usuario);

    void actualizar(Usuario usuario);

    void eliminar(int id);

    Usuario buscarPorId(int id);

    List<Usuario> listarTodos();

    Usuario buscarPorNombreUsuario(String nombreUsuario);

    Usuario validarCredenciales(String nombreUsuario, String password);

    boolean esNombreUsuarioUnico(String nombreUsuario);
}
