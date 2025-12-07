/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import Modelo.Cliente;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

/**
 *
 * @author danny
 */
public class Validaciones {

    public static void validarCliente(Cliente c) throws IllegalArgumentException {
        if (c.getCedula() == null || c.getCedula().trim().isEmpty() || c.getCedula().length() > 20) {
            throw new IllegalArgumentException("Cédula obligatoria y máximo 20 caracteres");
        }
        
        if (c.getNombre() == null || c.getNombre().trim().isEmpty() || c.getNombre().length() > 1000) {
            throw new IllegalArgumentException("Nombre obligatorio y maximo 100 caracteres");
        }
        
        
        if (c.getFechaNacimientos() == null || Period.between(c.getFechaNacimientos(), LocalDate.now()).getYears() < 16) {
            throw new IllegalArgumentException("El cliente debe tener al menos 16 años");
        }
        
        
        if (c.getContactos() != null && c.getContactos().length() > 100) {
            throw new IllegalArgumentException("Contacto demasiado largo");
        }
        
        if (!List.of("Basica", "Premium", "VIP").contains(c.getTipo())) {
            throw new IllegalArgumentException("Tipo de membresía invalido");
        }
        
        if (c.getFechaVencimiento() == null || c.getFechaVencimiento().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Fecha de vencimiento debe ser futura");
        }
    }
}
