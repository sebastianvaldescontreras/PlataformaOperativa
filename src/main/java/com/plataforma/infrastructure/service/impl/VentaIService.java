package com.plataforma.infrastructure.service.impl;

import com.plataforma.application.vo.venta.VentaVo;
import com.plataforma.domain.entities.Venta;
import com.plataforma.infrastructure.repository.IVentaRepository;
import com.plataforma.infrastructure.service.IVentaIService;
import com.plataforma.infrastructurecross.util.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class VentaIService implements IVentaIService {
    @Autowired
    private IVentaRepository ventaRepository;

    @Override
    public List<VentaVo> getVenta(Long id){
        List<Venta> ventaList = ventaRepository.selectVenta(id);
        return ObjectMapper.mapAll(ventaList, VentaVo.class);
    }

    @Override
    public List<VentaVo> getAllVenta() {
        List<Venta> ventaList = ventaRepository.selectAllVenta();
        return ObjectMapper.mapAll(ventaList, VentaVo.class);
    }

    @Override
    public Long postVenta(VentaVo ventaVo){
        ModelMapper modelMapper = new ModelMapper();
        Venta venta  = (Venta) modelMapper.map(ventaVo, (Class)Venta.class);
        venta.setFechaCreacion(LocalDateTime.now());
        venta.setFechaActualizacion(LocalDateTime.now());
        return ventaRepository.insertVenta(venta);
    }

    @Override
    public Long putVenta(VentaVo ventaVo){
        ModelMapper modelMapper = new ModelMapper();
        Venta venta = (Venta) modelMapper.map(ventaVo, (Class)Venta.class);
        venta.setFechaActualizacion(LocalDateTime.now());
        return ventaRepository.updateVenta(venta);
    }

    @Override
    public Long deleteVenta(Long id) {
        return ventaRepository.deleteVenta(id);
    }
}
