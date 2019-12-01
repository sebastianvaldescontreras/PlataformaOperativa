package com.plataforma.domain.entities;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class PlataformaCategoria{
    private Long id;
    private Long idPlataforma;
    private Long idCategoria;
    private Boolean estado;
    private LocalDateTime fechaActualizacion;
    private LocalDateTime fechaCreacion;
}
