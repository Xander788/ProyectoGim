/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Jorge
 */
public class Pago {
     private int id;
    private int idCliente;
    private Date fecha;
    private double subtotal;
    private double impuesto;
    private double total;

    public void calcularTotales() {
        impuesto = subtotal * 0.13;
        total = subtotal + impuesto;
    }
}
