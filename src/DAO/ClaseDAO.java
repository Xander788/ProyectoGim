/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ClaseDTO;
import Modelo.Clase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Jorge
 */

public class ClaseDAO implements IClaseDAO {

    private final String url;
    private final String user;
    private final String password;

    public ClaseDAO() {
        this.url = "jdbc:mysql://localhost:3306/BancoApp?useSSL=false&serverTimezone=UTC";
        this.user = "Admin";
        this.password = "Admin123@";
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public void insertar(Clase dto) throws Exception {
        try {
            Connection cn = getConnection();
            PreparedStatement ps = cn.prepareStatement("INSERT INTO clase (id, tipo, horario, capacidad)  VALUES (?,?,?,?)");
           ps.setInt(1, dto.getId());
            ps.setString(2,dto.getTipo());
            ps.setString(3,dto.getHorario());
            ps.setInt(4, dto.getCapacidadMaxima());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }

    @Override
    public void actualizar(Clase clase) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(int id) throws Exception {
           try {
            Connection cn = getConnection();
            PreparedStatement ps = cn.prepareStatement("DELETE FROM clase WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }
    }

    @Override
    public Optional<Clase> buscar(int id) throws Exception {
         try {
            Connection cn = getConnection();
            PreparedStatement ps = cn.prepareStatement("SELECT id, tipo, horario, capacidad FROM clase WHERE Id =?");
            ps.setInt(1, Id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new ClaseDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
        return null;
    }

    @Override
    public List<Clase> obtenerTodas() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Clase> buscarPorTipo(String tipo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
