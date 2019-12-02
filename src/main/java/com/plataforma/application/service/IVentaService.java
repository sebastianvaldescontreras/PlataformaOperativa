package com.plataforma.application.service;

import com.plataforma.application.vo.venta.VentaVo;
import java.util.List;

public interface IVentaService{
    List<VentaVo> getVenta(Long id);
    List<VentaVo> getAllVenta();
    Long postVenta(VentaVo ventaVo);
    Long putVenta(VentaVo ventaVo);
    Long deleteVenta(Long id);
}
