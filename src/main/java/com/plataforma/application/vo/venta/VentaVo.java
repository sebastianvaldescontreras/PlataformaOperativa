package com.plataforma.application.vo.venta;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VentaVo{
    private Long id;
    private Long idUsuario;
    private Long idComprobante;
    private Long impuesto;
    private Long total;
    private Boolean estado;
    private String fechaActualizacion;
    private String fechaCreacion;
}
