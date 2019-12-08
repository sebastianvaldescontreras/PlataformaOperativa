package com.plataforma.application.service.impl;

import com.plataforma.application.service.IVentaProductoService;
import com.plataforma.application.vo.ventaproducto.VentaProductoVo;
import com.plataforma.infrastructure.service.IVentaProductoIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VentaProductoService implements IVentaProductoService {
    @Autowired
    private IVentaProductoIService ventaProductoIService;

    @Override
    public List<VentaProductoVo> getVentaProducto(Long id){
        return ventaProductoIService.getVentaProducto(id);
    }

    @Override
    public List<VentaProductoVo> getAllVentaProducto() {
        return ventaProductoIService.getAllVentaProducto();
    }

    @Override
    public Long postVentaProducto(VentaProductoVo ventaProductoVo){
        return ventaProductoIService.postVentaProducto(ventaProductoVo);
    }

    @Override
    public Long putVentaProducto(VentaProductoVo ventaProductoVo){
        return ventaProductoIService.putVentaProducto(ventaProductoVo);
    }

    @Override
    public Long deleteVentaProducto(Long id) {
        return ventaProductoIService.deleteVentaProducto(id);
    }
}
