/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositorios;

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
public class RepositorioClaseMysql {
    private final String url;
    private final String user;
    private final String password;

    public RepositorioClaseMysql(String url, String user, String password) {
        this.url = "jdbc:mysql://localhost:3306/TiendaApp?useSSL=false&serverTimezone=UTC";
        this.user = user;
        this.password = password;
    }
    
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    
    public List<ClaseDTO> obtenerTodo() {
        try {
            Connection cn = getConnection();
            PreparedStatement ps = cn.prepareStatement("SELECT id, tipo, horario, capacidad FROM clase");
            ResultSet rs = ps.executeQuery();
            List<ClaseDTO> list = new ArrayList();
            while (rs.next()) {
                list.add(new ClaseDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
        return null;
    }
    
    public ClaseDTO buscar(String Id) {
        try {
            Connection cn = getConnection();
            PreparedStatement ps = cn.prepareStatement("SELECT id, tipo, horario, capacidad FROM clase WHERE Id =?");
            ps.setString(1, Id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new ClaseDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
        return null;
    }
    
    public void guardar(ClaseDTO dto) {
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
    
    public void borrar(String id){
             try {
            Connection cn = getConnection();
            PreparedStatement ps = cn.prepareStatement("DELETE FROM clase WHERE id=?");
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }
}
