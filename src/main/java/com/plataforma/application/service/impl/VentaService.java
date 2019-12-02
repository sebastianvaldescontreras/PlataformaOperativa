package com.plataforma.application.service.impl;

import com.plataforma.application.service.IVentaService;
import com.plataforma.application.vo.venta.VentaVo;
import com.plataforma.infrastructure.service.IVentaIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VentaService implements IVentaService {
    @Autowired
    private IVentaIService ventaIService;

    @Override
    public List<VentaVo> getVenta(Long id){
        return ventaIService.getVenta(id);
    }

    @Override
    public List<VentaVo> getAllVenta() {
        return ventaIService.getAllVenta();
    }

    @Override
    public Long postVenta(VentaVo ventaVo){
        return ventaIService.postVenta(ventaVo);
    }

    @Override
    public Long putVenta(VentaVo ventaVo){
        return ventaIService.putVenta(ventaVo);
    }

    @Override
    public Long deleteVenta(Long id) {
        return ventaIService.deleteVenta(id);
    }
}
