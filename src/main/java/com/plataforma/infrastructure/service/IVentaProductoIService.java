package com.plataforma.infrastructure.service;

import com.plataforma.application.vo.ventaproducto.VentaProductoVo;
import java.util.List;

public interface IVentaProductoIService{
    List<VentaProductoVo> getVentaProducto(Long id);
    List<VentaProductoVo> getAllVentaProducto();
    Long postVentaProducto(VentaProductoVo ventaProductoVo);
    Long putVentaProducto(VentaProductoVo ventaProductoVo);
    Long deleteVentaProducto(Long id);
}
