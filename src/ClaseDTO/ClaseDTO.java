/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClaseDTO;

/**
 *
 * @author Jorge
 */
public class ClaseDTO {
     private int id;
    private String tipo;
    private String horario;
    private int capacidadMaxima;

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getHorario() {
        return horario;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public ClaseDTO(int id, String tipo, String horario, int capacidadMaxima) {
        this.id = id;
        this.tipo = tipo;
        this.horario = horario;
        this.capacidadMaxima = capacidadMaxima;
    }
}
