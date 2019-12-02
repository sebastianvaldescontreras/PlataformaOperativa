package com.plataforma.infrastructure.service;

import com.plataforma.application.vo.venta.VentaVo;
import java.util.List;

public interface IVentaIService{
    List<VentaVo> getVenta(Long id);
    List<VentaVo> getAllVenta();
    Long postVenta(VentaVo ventaVo);
    Long putVenta(VentaVo ventaVo);
    Long deleteVenta(Long id);
}
