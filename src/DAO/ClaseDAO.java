/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Clase;
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
            ps.setString(2, dto.getTipo());
            ps.setString(3, dto.getHorario());
            ps.setInt(4, dto.getCapacidadMaxima());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }

    @Override
    public void actualizar(Clase clase) throws Exception {
        try {
            Connection cn = getConnection();
            PreparedStatement ps = cn.prepareStatement("INSERT INTO clase (id, tipo, horario, capacidad)  VALUES (?,?,?,?)");
            ps.setString(1, clase.getTipo());
            ps.setString(2, clase.getHorario());
            ps.setInt(3, clase.getCapacidadMaxima());
            ps.setInt(4, clase.getIdEntrenador());
            ps.setInt(5, clase.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
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

    @Override
    public Clase buscar(int id) throws Exception {
        try {
            Connection cn = getConnection();
            PreparedStatement ps = cn.prepareStatement("SELECT id, tipo, horario, capacidad FROM clase WHERE Id =?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Clase(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
        return null;
    }

    @Override
    public List<Clase> obtenerTodas() throws Exception {
List<Clase> lista = new ArrayList<>();
 try{
        Connection cn = getConnection();
        PreparedStatement ps = cn.prepareStatement("SELECT * FROM clase");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            lista.add(new Clase(
                rs.getInt("id"),
                rs.getString("tipo"),
                rs.getString("horario"),
                rs.getInt("capacidad"),
                rs.getInt("id_entrenador")
            )) ;
        }
             } catch (SQLException ex) {
        System.out.println("Error: " + ex);
    }
    return lista;
    }

    @Override
 public List<Clase> buscarPorTipo(String tipo) throws Exception {
    List<Clase> lista = new ArrayList<>();
    try {
        Connection cn = getConnection();
        PreparedStatement ps = cn.prepareStatement("SELECT * FROM clase WHERE tipo=?");
        ps.setString(1, tipo);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            lista.add(new Clase(
                rs.getInt("id"),
                rs.getString("tipo"),
                rs.getString("horario"),
                rs.getInt("capacidad"),
                rs.getInt("id_entrenador")
            ));
        }
    } catch (SQLException ex) {
        System.out.println("Error: " + ex);
    }
    return lista;
}
}