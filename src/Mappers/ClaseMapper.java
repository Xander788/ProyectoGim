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
public class ClaseMapper {
    
    public ClaseDTO ToDto(Clase ent) {
       return new ClaseDTO(ent.getId(),ent.getTipo(), ent.getHorario(), ent.getCapacidadMaxima(),ent.getIdEntrenador());
    }
    
    public Clase ToEntidad(ClaseDTO dto, int entredanorId) {
    return new Clase(dto.getId(),dto.getTipo(),dto.getHorario(),dto.getCapacidadMaxima(),entredanorId);   
    }
}