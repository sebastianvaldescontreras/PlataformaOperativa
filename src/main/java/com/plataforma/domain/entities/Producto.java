package com.plataforma.domain.entities;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class Producto{
    private Long id;
    private String codigo;
    private String nombre;
    private String descripcion;
    private Long precio;
    private Boolean estado;
    private LocalDateTime fechaActualizacion;
    private LocalDateTime fechaCreacion;
}
