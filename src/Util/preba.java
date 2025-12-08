/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Util;

import DAO.ClaseDAO;
import DTO.ClaseDTO;
import Modelo.Clase;
import Modelo.ServicioClase;
import Modelo.ServicioEntrenador;

/**
 *
 * @author Jorge
 */
public class preba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        ServicioEntrenador servicio = new ServicioEntrenador();
        System.out.println(servicio.eliminar(8));
    }
}
