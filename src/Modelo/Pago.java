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

    public int getId() {
        return id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public Date getFecha() {
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

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Pago(int id, int idCliente, Date fecha, double subtotal, double impuesto, double total) {
        this.id = id;
        this.idCliente = idCliente;
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.impuesto = impuesto;
        this.total = total;
    }
    
    public void calcularTotales() {
        impuesto = subtotal * 0.13;
        total = subtotal + impuesto;
    }
}
