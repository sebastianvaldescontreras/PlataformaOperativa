package com.plataforma.application.vo.ventaproducto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VentaProductoVo{
    private Long id;
    private Long idProducto;
    private Long idVenta;
    private Long cantidad;
    private Long precio;
    private Long descuento;
    private Boolean estado;
    private String fechaActualizacion;
    private String fechaCreacion;
}
