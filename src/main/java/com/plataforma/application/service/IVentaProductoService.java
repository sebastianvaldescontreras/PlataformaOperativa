package com.plataforma.application.service;

import com.plataforma.application.vo.ventaproducto.VentaProductoVo;
import java.util.List;

public interface IVentaProductoService{
    List<VentaProductoVo> getVentaProducto(Long id);
    List<VentaProductoVo> getAllVentaProducto();
    Long postVentaProducto(VentaProductoVo ventaProductoVo);
    Long putVentaProducto(VentaProductoVo ventaProductoVo);
    Long deleteVentaProducto(Long id);
}
