package com.plataforma.application.vo.plataforma;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlataformaVo{
    private Long id;
    private String nombre;
    private String descripcion;
    private Boolean estado;
    private String fechaActualizacion;
    private String fechaCreacion;
}
