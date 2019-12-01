package com.plataforma.application.vo.plataformacategoria;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlataformaCategoriaVo{
    private Long id;
    private Long idPlataforma;
    private Long idCategoria;
    private Boolean estado;
    private String fechaActualizacion;
    private String fechaCreacion;
}
