package com.plataforma.infrastructure.repository;

import com.plataforma.domain.entities.Venta;
import java.util.List;

public interface IVentaRepository{
    List<Venta> selectVenta(Long id);
    List<Venta> selectAllVenta();
    Long insertVenta(Venta venta);
    Long updateVenta(Venta venta);
    Long deleteVenta(Long id);
}
