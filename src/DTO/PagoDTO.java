/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.time.LocalDate;

/**
 *
 * @author Jorge
 */
public class PagoDTO {
    private int id;
    private String idCliente;
    private LocalDate fecha;
    private double subtotal;

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

    public PagoDTO(int id, String idCliente, LocalDate fecha, double subtotal) {
        this.id = id;
        this.idCliente = idCliente;
        this.fecha = fecha;
        this.subtotal = subtotal;
    }
}
