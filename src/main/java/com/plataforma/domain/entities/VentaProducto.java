package com.plataforma.domain.entities;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class VentaProducto{
    private Long id;
    private Long idProducto;
    private Long idVenta;
    private Long cantidad;
    private Long precio;
    private Long descuento;
    private Boolean estado;
    private LocalDateTime fechaActualizacion;
    private LocalDateTime fechaCreacion;
}
