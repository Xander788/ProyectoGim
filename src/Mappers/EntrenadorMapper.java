/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import DTO.EntrenadorDTO;
import Modelo.Entrenador;

/**
 *
 * @author pxand
 */
public class EntrenadorMapper {
    public EntrenadorDTO toDTO(Entrenador ent){
        return new EntrenadorDTO(ent.getId(),ent.getContacto(),ent.getNombre(),ent.getEspecialidad());
    }
    
    public Entrenador ToEntidad (EntrenadorDTO ent){
        return new Entrenador(ent.getId(),ent.getContacto(),ent.getNombre(),ent.getEspecialidad());
    }
            
}
