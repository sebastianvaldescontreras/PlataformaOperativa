package com.plataforma.infrastructure.repository;

import com.plataforma.domain.entities.VentaProducto;
import java.util.List;

public interface IVentaProductoRepository{
    List<VentaProducto> selectVentaProducto(Long id);
    List<VentaProducto> selectAllVentaProducto();
    Long insertVentaProducto(VentaProducto ventaProducto);
    Long updateVentaProducto(VentaProducto ventaProducto);
    Long deleteVentaProducto(Long id);
}
