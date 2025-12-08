/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.EntrenadorDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jorge
 */
public class EntrenadorDAO implements IEntrenadorDAO {
    private final String url;
    private final String user;
    private final String password;

    public EntrenadorDAO() {
        this.url = "jdbc:mysql://localhost:3306/ProyectoGym?useSSL=false&serverTimezone=UTC";
        this.user = "root";
        this.password = "Root123@";
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public void insertar(EntrenadorDTO dto) throws Exception {
        try {
            Connection cn = getConnection();
            PreparedStatement ps = cn.prepareStatement("INSERT INTO entrenador (id, contacto, nombre, especialidad) VALUES (?,?,?,?)");
            ps.setInt(1, dto.getId());
            ps.setString(2, dto.getContacto());
            ps.setString(3, dto.getNombre());
            ps.setString(4, dto.getEspecialidad());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error insertar entrenador: " + ex);
            throw ex;
        }
    }

    @Override
    public void actualizar(EntrenadorDTO dto) throws Exception {
        String sql = "UPDATE entrenador SET contacto=?, nombre=?, especialidad=? WHERE id=?";
        try (Connection cn = getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, dto.getContacto());
            ps.setString(2, dto.getNombre());
            ps.setString(3, dto.getEspecialidad());
            ps.setInt(4, dto.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error actualizar entrenador: " + ex);
            throw ex;
        }
    }

    @Override
    public void eliminar(int id) throws Exception {
        String sql = "DELETE FROM entrenador WHERE id=?";
        try (Connection cn = getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error eliminar entrenador: " + ex);
            throw ex;
        }
    }

    @Override
    public EntrenadorDTO buscar(int id) throws Exception {
        String sql = "SELECT id, contacto, nombre, especialidad FROM entrenador WHERE id=?";
        try (Connection cn = getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new EntrenadorDTO(
                        rs.getInt("id"),
                        rs.getString("contacto"),
                        rs.getString("nombre"),
                        rs.getString("especialidad")
                );
            }
        } catch (SQLException ex) {
            System.out.println("Error buscar entrenador: " + ex);
            throw ex;
        }
        return null;
    }

    @Override
    public List<EntrenadorDTO> obtenerTodas() throws Exception {
        List<EntrenadorDTO> lista = new ArrayList<>();
        String sql = "SELECT id, contacto, nombre, especialidad FROM entrenador";
        try (Connection cn = getConnection(); PreparedStatement ps = cn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new EntrenadorDTO(
                        rs.getInt("id"),
                        rs.getString("contacto"),
                        rs.getString("nombre"),
                        rs.getString("especialidad")
                ));
            }
        } catch (SQLException ex) {
            System.out.println("Error obtener entrenadores: " + ex);
            throw ex;
        }
        return lista;
    }
}
