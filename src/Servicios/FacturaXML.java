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
public class FacturaXML {
     public static void generarFactura(Pago pago) throws Exception {
        String archivo = "factura_" + pago.getId() + ".xml";

        String xml = """
        <factura>
            <id>%d</id>
            <cliente>%d</cliente>
            <fecha>%s</fecha>
            <subtotal>%.2f</subtotal>
            <impuesto>%.2f</impuesto>
            <total>%.2f</total>
        </factura>
        """.formatted(
                pago.getId(),
                pago.getIdCliente(),
                pago.getFecha(),
                pago.getSubtotal(),
                pago.getImpuesto(),
                pago.getTotal()
        );

        FileWriter fw = new FileWriter(archivo);
        fw.write(xml);
         fw.close();
    }
}
