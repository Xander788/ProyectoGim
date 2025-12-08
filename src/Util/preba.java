/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Util;

import DAO.ClaseDAO;
import DTO.ClaseDTO;

/**
 *
 * @author Jorge
 */
public class preba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        ClaseDAO repo = new ClaseDAO();
        ClaseDTO cli = new ClaseDTO(3, "Entrenador", "Viernes", 5);
        repo.buscarPorTipo("Entrenador");
    }
}