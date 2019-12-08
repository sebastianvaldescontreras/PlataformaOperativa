package com.plataforma.infrastructure.service.impl;

import com.plataforma.application.vo.ventaproducto.VentaProductoVo;
import com.plataforma.domain.entities.VentaProducto;
import com.plataforma.infrastructure.repository.IVentaProductoRepository;
import com.plataforma.infrastructure.service.IVentaProductoIService;
import com.plataforma.infrastructurecross.util.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class VentaProductoIService implements IVentaProductoIService {
    @Autowired
    private IVentaProductoRepository ventaProductoRepository;

    @Override
    public List<VentaProductoVo> getVentaProducto(Long id){
        List<VentaProducto> ventaProductoList = ventaProductoRepository.selectVentaProducto(id);
        return ObjectMapper.mapAll(ventaProductoList, VentaProductoVo.class);
    }

    @Override
    public List<VentaProductoVo> getAllVentaProducto() {
        List<VentaProducto> ventaProductoList = ventaProductoRepository.selectAllVentaProducto();
        return ObjectMapper.mapAll(ventaProductoList, VentaProductoVo.class);
    }

    @Override
    public Long postVentaProducto(VentaProductoVo ventaProductoVo){
        ModelMapper modelMapper = new ModelMapper();
        VentaProducto ventaProducto  = (VentaProducto) modelMapper.map(ventaProductoVo, (Class)VentaProducto.class);
        ventaProducto.setFechaCreacion(LocalDateTime.now());
        ventaProducto.setFechaActualizacion(LocalDateTime.now());
        return ventaProductoRepository.insertVentaProducto(ventaProducto);
    }

    @Override
    public Long putVentaProducto(VentaProductoVo ventaProductoVo){
        ModelMapper modelMapper = new ModelMapper();
        VentaProducto ventaProducto = (VentaProducto) modelMapper.map(ventaProductoVo, (Class)VentaProducto.class);
        ventaProducto.setFechaActualizacion(LocalDateTime.now());
        return ventaProductoRepository.updateVentaProducto(ventaProducto);
    }

    @Override
    public Long deleteVentaProducto(Long id) {
        return ventaProductoRepository.deleteVentaProducto(id);
    }
}
