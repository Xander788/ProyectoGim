/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.UsuarioDTO;
import Modelo.Roles;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements IUsuarioDAO {

    private final String url = "jdbc:mysql://localhost:3306/ProyectoGym?useSSL=false&serverTimezone=UTC";
    private final String user = "root";
    private final String password = "Root123@";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public void insertar(UsuarioDTO dto) throws Exception {
        String sql = "INSERT INTO usuario (id, nombre_usuario, contrasena, rol) VALUES (?,?,?,?)";
        try (Connection cn = getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, dto.getId());
            ps.setString(2, dto.getNombreUsuario());
            ps.setString(3, dto.getContrasena());
            ps.setString(4, dto.getRol() != null ? dto.getRol().name() : null);
            ps.executeUpdate();
        }
    }

    @Override
    public void actualizar(UsuarioDTO dto) throws Exception {
        String sql = "UPDATE usuario SET nombre_usuario=?, contrasena=?, rol=? WHERE id=?";
        try (Connection cn = getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, dto.getNombreUsuario());
            ps.setString(2, dto.getContrasena());
            ps.setString(3, dto.getRol() != null ? dto.getRol().name() : null);
            ps.setInt(4, dto.getId());
            ps.executeUpdate();
        }
    }

    @Override
    public void eliminar(int id) throws Exception {
        String sql = "DELETE FROM usuario WHERE id=?";
        try (Connection cn = getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public UsuarioDTO buscar(int id) throws Exception {
        String sql = "SELECT id, nombre_usuario, contrasena, rol FROM usuario WHERE id=?";
        try (
                Connection cn = getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (
                    ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Roles rol = rs.getString("rol") != null
                            ? Roles.valueOf(rs.getString("rol")) : null;
                    return new UsuarioDTO(
                            rs.getInt("id"),
                            rs.getString("nombre_usuario"),
                            rs.getString("contrasena"),
                            rol
                    );
                }
            }
        }
        return null;
    }

    @Override
    public List<UsuarioDTO> obtenerTodas() throws Exception {
        List<UsuarioDTO> lista = new ArrayList<>();
        String sql = "SELECT id, nombre_usuario, contrasena, rol FROM usuario";
        try (Connection cn = getConnection(); PreparedStatement ps = cn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Roles rol = rs.getString("rol") != null ? Roles.valueOf(rs.getString("rol")) : null;
                lista.add(new UsuarioDTO(
                        rs.getInt("id"),
                        rs.getString("nombre_usuario"),
                        rs.getString("contrasena"),
                        rol
                ));
            }
        }
        return lista;
    }
}
