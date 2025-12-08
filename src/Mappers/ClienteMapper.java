/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import DTO.ClienteDTO;
import Modelo.Cliente;

/**
 *
 * @author pxand
 */
public class ClienteMapper {
    public ClienteDTO ToDto(Cliente cli){
        return new ClienteDTO(cli.getCedula(),cli.getFechaNacimientos(),cli.getFechaVencimiento(),cli.getNombre(),cli.getContactos(),cli.getTipo());
    }
    
    public Cliente ToEntidad(ClienteDTO cli){
        return new Cliente(cli.getCedula(),cli.getFechaNacimientos(),cli.getFechaVencimiento(),cli.getNombre(),cli.getContactos(),cli.getTipo());
    }
}
