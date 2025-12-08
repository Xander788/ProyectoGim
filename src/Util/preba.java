/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Util;


import DAO.EntrenadorDAO;
import DAO.UsuarioDAO;
import DTO.EntrenadorDTO;
import DTO.UsuarioDTO;
import static Modelo.Roles.ENTRENADOR;
import java.time.LocalDate;


/**
 *
 * @author Jorge
 */
public class preba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        LocalDate fechaSQL=LocalDate.parse("2025-12-07");
        UsuarioDAO repo = new UsuarioDAO();
        UsuarioDTO cli = new UsuarioDTO(1,"farid","contraseña",ENTRENADOR);
        repo.obtenerTodas();
        
    }
}