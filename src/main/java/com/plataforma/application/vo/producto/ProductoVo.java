package com.plataforma.application.vo.producto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoVo{
    private Long id;
    private String codigo;
    private String nombre;
    private String descripcion;
    private Long precio;
    private Boolean estado;
    private String fechaActualizacion;
    private String fechaCreacion;
}
