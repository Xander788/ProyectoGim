/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import DTO.PagoDTO;
import Modelo.Pago;

/**
 *
 * @author Jorge
 */
public class PagoMapper{


    public Object ToDto(Pago ent) {
        return new PagoDTO(ent.getId(),ent.getIdCliente(),ent.getFecha());
    }

    public Object ToEntidad(PagoDTO dto) {
   Pago p = new Pago( dto.getId(),dto.getIdCliente(),dto.getFecha(), 0.0 );
    p.calcularTotales();
    return p;
    }
}
