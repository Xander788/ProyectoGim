/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ClaseDTO;
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
public class ClaseDAO implements IClaseDAO {

    private final String url;
    private final String user;
    private final String password;

    public ClaseDAO() {
        this.url = "jdbc:mysql://localhost:3306/ProyectoGym?useSSL=false&serverTimezone=UTC";
        this.user = "Admin";
        this.password = "Admin123@";
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public void insertar(ClaseDTO dto) throws Exception {
        String sql = "INSERT INTO clase (id, tipo, horario, capacidad) VALUES (?,?,?,?)";

        try (Connection cn = getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, dto.getId());
            ps.setString(2, dto.getTipo());
            ps.setString(3, dto.getHorario());
            ps.setInt(4, dto.getCapacidadMaxima());
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error insertar clase: " + ex);
        }
    }

    @Override
    public void actualizar(ClaseDTO dto) throws Exception {
        String sql = "UPDATE clase SET tipo=?, horario=?, capacidad=? WHERE id=?";

        try (Connection cn = getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, dto.getTipo());
            ps.setString(2, dto.getHorario());
            ps.setInt(3, dto.getCapacidadMaxima());
            ps.setInt(4, dto.getId());
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error actualizar clase: " + ex);
        }
    }

    @Override
    public void eliminar(int id) throws Exception {
        String sql = "DELETE FROM clase WHERE id=?";

        try (Connection cn = getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error eliminar clase: " + ex);
        }
    }

    @Override
    public ClaseDTO buscar(int id) throws Exception {
        String sql = "SELECT id, tipo, horario, capacidad FROM clase WHERE id=?";

        try (Connection cn = getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new ClaseDTO(
                        rs.getInt("id"),
                        rs.getString("tipo"),
                        rs.getString("horario"),
                        rs.getInt("capacidad")
                );
            }

        } catch (SQLException ex) {
            System.out.println("Error buscar clase: " + ex);
        }

        return null;
    }

    @Override
    public List<ClaseDTO> obtenerTodas() throws Exception {
        List<ClaseDTO> lista = new ArrayList<>();
        String sql = "SELECT id, tipo, horario, capacidad FROM clase";

        try (Connection cn = getConnection(); PreparedStatement ps = cn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new ClaseDTO(
                        rs.getInt("id"),
                        rs.getString("tipo"),
                        rs.getString("horario"),
                        rs.getInt("capacidad")
                ));
            }

        } catch (SQLException ex) {
            System.out.println("Error obtener clases: " + ex);
        }

        return lista;
    }

    @Override
    public List<ClaseDTO> buscarPorTipo(String tipo) throws Exception {
        List<ClaseDTO> lista = new ArrayList<>();
        String sql = "SELECT id, tipo, horario, capacidad FROM clase WHERE tipo = ?";

        try (Connection cn = getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, "%" + tipo + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new ClaseDTO(
                        rs.getInt("id"),
                        rs.getString("tipo"),
                        rs.getString("horario"),
                        rs.getInt("capacidad")
                ));
            }

        } catch (SQLException ex) {
            System.out.println("Error buscar por tipo: " + ex);
        }

        return lista;
    }
}
