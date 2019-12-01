package com.plataforma.application.vo.comprobante;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComprobanteVo {
    private Long id;
    private String tipo;
    private String serie;
    private Long numero;
    private Boolean estado;
    private String fechaActualizacion;
    private String fechaCreacion;
}
