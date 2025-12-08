/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import DAO.IPagoDAO;
import DAO.PagoDAO;
import DTO.PagoDTO;
import Mappers.PagoMapper;
import Servicios.FacturaPDF;
import Servicios.FacturaXML;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author pxand
 */
public class ServicioPago {

    private final IPagoDAO pagoDAO;
    private final PagoMapper mapper;
    private final ServicioCliente servicioCliente;

    public ServicioPago() {
        this.pagoDAO = new PagoDAO();
        this.mapper = new PagoMapper();
        this.servicioCliente = new ServicioCliente();
    }

    public Pago registrarPago(String idCliente, double subtotal, String formatoFactura) throws Exception {
        Cliente cliente = servicioCliente.buscarPorCedula(idCliente);
        LocalDate fechaActual = LocalDate.now(); 
        
        PagoDTO dto = new PagoDTO(0, idCliente, fechaActual,subtotal);  
        
        pagoDAO.insertar(dto);
        
        PagoDTO creado = pagoDAO.listarPorCliente(idCliente).stream()
                .filter(p -> p.getFecha().equals(fechaActual))
                .findFirst()
                .orElseThrow(() -> new Exception("Error al recuperar pago creado"));
        Pago pagoCompleto = (Pago) mapper.ToEntidad(creado);
        
        int meses = obtenerMesesPorMembresia(cliente.getTipo());
        
        LocalDate nuevaVencimiento = cliente.getFechaVencimiento().plusMonths(meses);
        
        servicioCliente.actualizar(idCliente, null, null, null, nuevaVencimiento, null);
        
        generarFactura(pagoCompleto, formatoFactura);
        
        return pagoCompleto;
    }

    
    public List<Pago> listarPorCliente(String idCliente) throws Exception {
        return pagoDAO.listarPorCliente(idCliente).stream()
                .map(dto -> (Pago) mapper.ToEntidad(dto))
                .collect(Collectors.toList());
    }

    
    public List<Pago> listarTodos() throws Exception {
        return pagoDAO.listarTodos().stream()
                .map(dto -> (Pago) mapper.ToEntidad(dto))
                .collect(Collectors.toList());
    }

   
    public Pago buscarPorId(int id) throws Exception {
        PagoDTO dto = pagoDAO.buscar(id);
        return dto != null ? (Pago) mapper.ToEntidad(dto) : null;
    }

    
    private void generarFactura(Pago pago, String formato) throws Exception {
        if ("PDF".equalsIgnoreCase(formato)) {
            FacturaPDF.generarFactura(pago);
        } else if ("XML".equalsIgnoreCase(formato)) {
            FacturaXML.generarFactura(pago);
        } else {
            throw new IllegalArgumentException("Formato de factura inválido: " + formato);
        }
    }

    
    private int obtenerMesesPorMembresia(TiposMembresia tipo) {
        switch (tipo) {
            case BASICA:
                return 1;
            case PREMIUM:
                return 3;
            default:
                return 1;
        }
    }
}
