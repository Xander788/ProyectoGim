/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.PagoDTO;
import java.sql.Connection;
import java.sql.Date;
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
public class PagoDAO implements IPagoDAO {
    private final String url = "jdbc:mysql://localhost:3306/ProyectoGym?useSSL=false&serverTimezone=UTC";
    private final String user = "Admin";
    private final String password = "Admin123@";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public void insertar(PagoDTO pago) throws Exception {
        String sql = "INSERT INTO pago(id_cliente, fecha) VALUES (?, ?)";

        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, pago.getIdCliente());
            ps.setDate(2, new Date(pago.getFecha().getTime()));
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error insertar pago: " + ex);
        }
    }

    @Override
    public PagoDTO buscar(int id) throws Exception {
        String sql = "SELECT id, id_cliente, fecha FROM pago WHERE id=?";

        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new PagoDTO(
                    rs.getInt("id"),
                    rs.getInt("id_cliente"),
                    rs.getDate("fecha")
                );
            }

        } catch (SQLException ex) {
            System.out.println("Error buscar pago: " + ex);
        }

        return null;
    }

    @Override
    public List<PagoDTO> listarPorCliente(int idCliente) throws Exception {
        List<PagoDTO> lista = new ArrayList<>();
        String sql = "SELECT id, id_cliente, fecha FROM pago WHERE id_cliente=?";

        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, idCliente);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new PagoDTO(
                    rs.getInt("id"),
                    idCliente,
                    rs.getDate("fecha")
                ));
            }

        } catch (SQLException ex) {
            System.out.println("Error listar pagos por cliente: " + ex);
        }

        return lista;
    }

    @Override
    public List<PagoDTO> listarTodos() throws Exception {
        List<PagoDTO> lista = new ArrayList<>();
        String sql = "SELECT id, id_cliente, fecha FROM pago";

        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new PagoDTO(
                    rs.getInt("id"),
                    rs.getInt("id_cliente"),
                    rs.getDate("fecha")
                ));
            }

        } catch (SQLException ex) {
            System.out.println("Error listar todos los pagos: " + ex);
        }

        return lista;
    }
}
