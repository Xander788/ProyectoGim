/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Mappers;

/**
 *
 * @author Jorge
 * @param <Entidad>
 * @param <Dto>
 */
public interface IMapper<Entidad, Dto>{
    public Dto ToDto(Entidad ent);
    
    public Entidad ToEntidad(Dto dto);
}
