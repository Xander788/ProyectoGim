/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Util;

import Modelo.Cliente;
import Modelo.ServicioCliente;
import Modelo.TiposMembresia;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author Jorge
 */
public class preba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Cliente cli = new Cliente("1",LocalDate.of(2025, Month.MARCH, 14),LocalDate.of(2025, Month.MARCH,18),"jorge", "123", TiposMembresia.PREMIUM);
        ServicioCliente servicio = new ServicioCliente();
        System.out.println(servicio.membresiaVigente(cli));
    }
}