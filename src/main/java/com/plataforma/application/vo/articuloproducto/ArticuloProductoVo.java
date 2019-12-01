package com.plataforma.application.vo.articuloproducto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticuloProductoVo {
    private Long id;
    private Long idArticulo;
    private Long idProducto;
    private Boolean estado;
    private String fechaActualizacion;
    private String fechaCreacion;
}
