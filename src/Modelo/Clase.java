/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Jorge
 */
public class Clase {
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

    public void setId(int id) {
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public void setIdEntrenador(int idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    public Clase(int id, String tipo, String horario, int capacidadMaxima, int idEntrenador) {
        this.id = id;
        this.tipo = tipo;
        this.horario = horario;
        this.capacidadMaxima = capacidadMaxima;
        this.idEntrenador = idEntrenador;
    }
    
    public void validar() throws Exception {
        if (tipo == null || tipo.isBlank())
            throw new Exception("El tipo de clase es obligatorio.");

        if (capacidadMaxima <= 0)
            throw new Exception("La capacidad debe ser mayor que 0.");

        if (!horario.matches("\\d{2}:\\d{2}-\\d{2}:\\d{2}"))
            throw new Exception("Formato de horario inválido. Ej: 08:00-09:30.");
    }
    
}
