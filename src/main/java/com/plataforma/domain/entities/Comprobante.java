package com.plataforma.domain.entities;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class Comprobante{
    private Long id;
    private String tipo;
    private String serie;
    private Long numero;
    private Boolean estado;
    private LocalDateTime fechaActualizacion;
    private LocalDateTime fechaCreacion;
}
