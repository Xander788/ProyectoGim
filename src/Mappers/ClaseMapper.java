/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import DTO.ClaseDTO;
import Modelo.Clase;

/**
 *
 * @author Jorge
 */
public class ClaseMapper implements IMapper<Clase, ClaseDTO>{
    @Override
    public ClaseDTO ToDto(Clase ent) {
       return new ClaseDTO(ent.getId(),ent.getTipo(), ent.getHorario(), ent.getCapacidadMaxima());
    }

    @Override
    public Clase ToEntidad(ClaseDTO dto, Entrenador id) {
        return new Clase(dto.getId(), dto.getTipo(), dto.getHorario(), dto.getCapacidadMaxima(),id.getId);
    }

}
