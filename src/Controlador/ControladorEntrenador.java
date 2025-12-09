/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Entrenador;
import Modelo.ServicioClase;
import Modelo.ServicioEntrenador;
import java.util.List;

/**
 *
 * @author pxand
 */
public class ControladorEntrenador {
    private final ServicioEntrenador entrenador;
    private final ServicioClase servicioClase;

    public ControladorEntrenador(ServicioEntrenador entrenador) {
        this.entrenador = new ServicioEntrenador();
        this.servicioClase = new ServicioClase();
    }
    
    private Entrenador registrar(){
        
        return null;
        
    }
    
    private void actualizar(){
        
    }
    
    private boolean eliminar(){
        
        return false;
        
    }
    
    private Entrenador buscarPorId(){
        
        return null;
        
    }
    
    private List<Entrenador> obtenerTodos(){
        
        return null;
        
    }
    
    private boolean tieneClasesAsignadas(){
        
        return false;
        
    }
        
}
