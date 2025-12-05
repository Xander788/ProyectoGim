/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClaseDTO;

import java.util.Date;

/**
 *
 * @author Jorge
 */
public class PagoDTO {
     private int id;
    private int idCliente;
    private Date fecha;

    public int getId() {
        return id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public PagoDTO(int id, int idCliente, Date fecha) {
        this.id = id;
        this.idCliente = idCliente;
        this.fecha = fecha;
    }
}
