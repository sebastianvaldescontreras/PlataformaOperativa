package com.plataforma.application.vo.articulo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticuloVo{
    private Long id;
    private Long idCategoria;
    private String codigo;
    private String nombre;
    private Long precio;
    private Long stock;
    private String descripcion;
    private String imagen;
    private Boolean estado;
    private String fechaActualizacion;
    private String fechaCreacion;
}
