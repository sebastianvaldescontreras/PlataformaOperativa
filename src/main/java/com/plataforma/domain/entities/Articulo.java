package com.plataforma.domain.entities;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class Articulo{
    private Long id;
    private Long idCategoria;
    private String codigo;
    private String nombre;
    private Long precio;
    private Long stock;
    private String descripcion;
    private String imagen;
    private Boolean estado;
    private LocalDateTime fechaActualizacion;
    private LocalDateTime fechaCreacion;
}
