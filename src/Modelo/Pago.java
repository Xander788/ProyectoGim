/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Jorge
 */
public class Pago {
     private int id;
    private String idCliente;
    private LocalDate fecha;
    private double subtotal;
    private double impuesto;
    private double total;

    public int getId() {
        return id;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public double getTotal() {
        return total;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }



    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Pago(int id, String idCliente, LocalDate fecha, double subtotal) {
        this.id = id;
        this.idCliente = idCliente;
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.impuesto = 0.13;
        this.total = calcularTotales();
    }
    
    public double calcularTotales() {
        impuesto = subtotal * 0.13;
       return  subtotal + impuesto;
    }
}
