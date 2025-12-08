/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ClienteDTO;
import Modelo.TiposMembresia;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jorge
 */
public class ClienteDAO implements IClienteDAO {

    private final String url;
    private final String user;
    private final String password;

    public ClienteDAO() {
        this.url = "jdbc:mysql://localhost:3306/ProyectoGym?useSSL=false&serverTimezone=UTC";
        this.user = "root";
        this.password = "Root123@";
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public void insertar(ClienteDTO dto) throws Exception {
        try {
            Connection cn = getConnection();
            PreparedStatement ps = cn.prepareStatement("INSERT INTO cliente (cedula, fecha_nacimiento, fecha_vencimiento, nombre, contactos, tipo) VALUES (?,?,?,?,?,?)");
            ps.setString(1, dto.getCedula());
            ps.setDate(2, dto.getFechaNacimientos() != null ? Date.valueOf(dto.getFechaNacimientos()) : null);
            ps.setDate(3, dto.getFechaVencimiento() != null ? Date.valueOf(dto.getFechaVencimiento()) : null);
            ps.setString(4, dto.getNombre());
            ps.setString(5, dto.getContactos());
            ps.setString(6, dto.getTipo() != null ? dto.getTipo().name() : null);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error insertar cliente: " + ex);
            throw ex;
        }
    }

    @Override
    public void actualizar(ClienteDTO dto) throws Exception {
        String sql = "UPDATE cliente SET fecha_nacimiento=?, fecha_vencimiento=?, nombre=?, contactos=?, tipo=? WHERE cedula=?";
        try (Connection cn = getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setDate(1, dto.getFechaNacimientos() != null ? Date.valueOf(dto.getFechaNacimientos()) : null);
            ps.setDate(2, dto.getFechaVencimiento() != null ? Date.valueOf(dto.getFechaVencimiento()) : null);
            ps.setString(3, dto.getNombre());
            ps.setString(4, dto.getContactos());
            ps.setString(5, dto.getTipo() != null ? dto.getTipo().name() : null);
            ps.setString(6, dto.getTipo() != null ? dto.getTipo().name() : null);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error actualizar cliente: " + ex);
            throw ex;
        }
    }

    @Override
    public void eliminar(String cedula) throws Exception {
        String sql = "DELETE FROM cliente WHERE cedula=?";
        try (Connection cn = getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, cedula);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error eliminar cliente: " + ex);
            throw ex;
        }
    }

    @Override
    public ClienteDTO buscar(String cedula) throws Exception {
        String sql = "SELECT cedula, fecha_nacimiento, fecha_vencimiento, nombre, contactos, tipo FROM cliente WHERE cedula=?";
        try (Connection cn = getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, cedula);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Date fechaNacSql = rs.getDate("fecha_nacimiento");
                LocalDate fechaNac = fechaNacSql != null ? fechaNacSql.toLocalDate() : null;
                Date fechaVenSql = rs.getDate("fecha_vencimiento");
                LocalDate fechaVen = fechaVenSql != null ? fechaVenSql.toLocalDate() : null;
                String tipoStr = rs.getString("tipo");
                TiposMembresia tipo = tipoStr != null ? TiposMembresia.valueOf(tipoStr) : null;
                return new ClienteDTO(
                        rs.getString("cedula"),
                        fechaNac,
                        fechaVen,
                        rs.getString("nombre"),
                        rs.getString("contactos"),
                        tipo
                );
            }
        } catch (SQLException ex) {
            System.out.println("Error buscar cliente: " + ex);
            throw ex;
        }
        return null;
    }

    @Override
    public List<ClienteDTO> obtenerTodas() throws Exception {
        List<ClienteDTO> lista = new ArrayList<>();
        String sql = "SELECT cedula, fecha_nacimiento, fecha_vencimiento, nombre, contactos, tipo FROM cliente";
        try (Connection cn = getConnection(); PreparedStatement ps = cn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Date fechaNacSql = rs.getDate("fecha_nacimiento");
                LocalDate fechaNac = fechaNacSql != null ? fechaNacSql.toLocalDate() : null;
                Date fechaVenSql = rs.getDate("fecha_vencimiento");
                LocalDate fechaVen = fechaVenSql != null ? fechaVenSql.toLocalDate() : null;
                String tipoStr = rs.getString("tipo");
                TiposMembresia tipo = tipoStr != null ? TiposMembresia.valueOf(tipoStr) : null;
                lista.add(new ClienteDTO(
                        rs.getString("cedula"),
                        fechaNac,
                        fechaVen,
                        rs.getString("nombre"),
                        rs.getString("contactos"),
                        tipo
                ));
            }
        } catch (SQLException ex) {
            System.out.println("Error obtener clientes: " + ex);
            throw ex;
        }
        return lista;
    }
}
