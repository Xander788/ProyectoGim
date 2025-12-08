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

    public int getId() {
        return id;
    }

    public String getIdCliente() {
        return idCliente;
    }

   

    public LocalDate getFecha() {
        return fecha;
    }

    public PagoDTO(int id, String idCliente, LocalDate fecha) {
        this.id = id;
        this.idCliente = idCliente;
        this.fecha = fecha;
    }
}
