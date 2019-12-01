package com.plataforma.application.vo.rol;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RolVo{
    private Long id;
    private String nombre;
    private String descripcion;
    private Boolean estado;
    private String fechaActualizacion;
    private String fechaCreacion;
}
