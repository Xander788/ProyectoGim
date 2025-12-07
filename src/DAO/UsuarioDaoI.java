/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Roles;
import Modelo.Usuario;
import Util.Seguridad;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author danny
 */
public class UsuarioDaoI implements UsuarioDao {

    private static List<Roles> rolesDB = new ArrayList<>();
    private static List<Usuario> usuariosDB = new ArrayList<>();
    private static AtomicInteger contadorId = new AtomicInteger(1);

    static { //jorge acuerdese que esto es como el de la clase de antes que capaz tiene q quitarlo despues 

        Roles adminRol = new Roles(1, "Administrador");
        Roles entrenadorRol = new Roles(2, "Entrenador");
        rolesDB.add(adminRol);
        rolesDB.add(entrenadorRol);

        String hashAdmin = Seguridad.hashearContrasena("admin123");
        String hashEntr = Seguridad.hashearContrasena("entrena456");

        usuariosDB.add(new Usuario(contadorId.getAndIncrement(), "admin", hashAdmin, adminRol));
        usuariosDB.add(new Usuario(contadorId.getAndIncrement(), "dannyE", hashEntr, entrenadorRol));
    }

    @Override
    public int crear(Usuario usuario) {

        if (!esNombreUsuarioUnico(usuario.getNombreUsuario())) {
            throw new IllegalArgumentException("El nombre de usuario ya existe.");
        }

        if (usuario.getContrasena() == null || usuario.getContrasena().length() < 6) {
            throw new IllegalArgumentException("La contraseña es obligatoria y debe ser segura.");
        }

        int nuevoId = contadorId.getAndIncrement();
        usuario.setId(nuevoId);
        if (usuario.getRol() == null) {
            Roles rolPorDefecto = rolesDB.stream().filter(r -> r.getNombre().equals("Entrenador")).findFirst().orElse(null);
            usuario.setRol(rolPorDefecto);
        }
        usuariosDB.add(usuario);
        return nuevoId;
    }

    @Override
    public void actualizar(Usuario usuario) {
        Usuario existente = buscarPorId(usuario.getId());
        if (existente == null) {
            try {
                throw new Exception("Usuario con ID " + usuario.getId() + " no encontrado.");
            } catch (Exception ex) {
                System.getLogger(UsuarioDaoI.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
        existente.setNombreUsuario(usuario.getNombreUsuario());
        if (usuario.getContrasena() != null && !usuario.getContrasena().isEmpty()) {
            existente.setContrasena(usuario.getContrasena());
        }
        existente.setRol(usuario.getRol());
    }

    @Override
    public void eliminar(int id) {
        boolean eliminado = usuariosDB.removeIf(u -> u.getId() == id);
        if (!eliminado) {
            try {
                throw new Exception("Error al eliminar: Usuario con ID " + id + " no encontrado.");
            } catch (Exception ex) {
                System.getLogger(UsuarioDaoI.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
    }

    @Override
    public Usuario buscarPorId(int id) {
        return usuariosDB.stream().filter(u -> u.getId() == id).findFirst().orElse(null);

    }

    @Override
    public List<Usuario> listarTodos() {
        return new ArrayList<>(usuariosDB);
    }

    @Override
    public Usuario buscarPorNombreUsuario(String nombreUsuario) {
        if (nombreUsuario == null) {
            return null;
        }
        return usuariosDB.stream().filter(u -> u.getNombreUsuario().equalsIgnoreCase(nombreUsuario)).findFirst().orElse(null);
    }

    @Override
    public Usuario validarCredenciales(String nombreUsuario, String password) {
        Usuario usuario = buscarPorNombreUsuario(nombreUsuario);

        if (usuario == null) {
            return null;
        }
        if (Seguridad.verificarContrasena(password, usuario.getContrasena())) {
            return usuario;
        } else {
            return null;
        }
    }

    @Override
    public boolean esNombreUsuarioUnico(String nombreUsuario) {
        return usuariosDB.stream().noneMatch(u -> u.getNombreUsuario().equalsIgnoreCase(nombreUsuario));
    }

}
