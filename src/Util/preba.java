/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Util;

import DAO.ClaseDAO;
import DAO.PagoDAO;
import DTO.ClaseDTO;
import DTO.PagoDTO;
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
        PagoDAO repo = new PagoDAO();
        PagoDTO cli = new PagoDTO(1,"12345678910", fechaSQL);
        repo.listarTodos();
        
    }
}