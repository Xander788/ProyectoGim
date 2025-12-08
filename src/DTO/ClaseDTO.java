/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Jorge
 */
public class ClaseDTO {
    private int id;
    private String tipo;
    private String horario;
    private int capacidadMaxima;
    private int idEntrenador;

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

    public int getIdEntrenador() {
        return idEntrenador;
    }
    

    public ClaseDTO(int id, String tipo, String horario, int capacidadMaxima,int idEntrenador) {
        this.id = id;
        this.tipo = tipo;
        this.horario = horario;
        this.capacidadMaxima = capacidadMaxima;
        this.idEntrenador = idEntrenador;
    }
}
