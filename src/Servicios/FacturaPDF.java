/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import Modelo.Pago;
import java.io.FileWriter;

/**
 *
 * @author Jorge
 */
public class FacturaPDF {
    //HUMILDEMENTE SI BUSQUE COMO PDOER HACER ESTO A TRAVES DE CHAT
  public static void generarFactura(Pago pago) throws Exception {

        String nombreArchivo = "factura_" + pago.getId() + ".txt";

        FileWriter fw = new FileWriter(nombreArchivo);

        fw.write("===== FACTURA DEL GIMNASIO =====\n");
        fw.write("\n");
        fw.write("Factura #: " + pago.getId() + "\n");
        fw.write("Cliente ID: " + pago.getIdCliente() + "\n");
        fw.write("Fecha: " + pago.getFecha() + "\n");
        fw.write("\n");
        fw.write("Subtotal: " + pago.getSubtotal() + "\n");
        fw.write("Impuesto (13%): " + pago.getImpuesto() + "\n");
        fw.write("Total a pagar: " + pago.getTotal() + "\n");
        fw.write("\n");
        fw.write("Gracias por su preferencia.\n");

        fw.close();
    }
}
