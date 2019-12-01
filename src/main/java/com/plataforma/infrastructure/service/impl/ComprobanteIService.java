package com.plataforma.infrastructure.service.impl;

import com.plataforma.application.vo.comprobante.ComprobanteVo;
import com.plataforma.domain.entities.Comprobante;
import com.plataforma.infrastructure.repository.IComprobanteRepository;
import com.plataforma.infrastructure.service.IComprobanteIService;
import com.plataforma.infrastructurecross.util.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ComprobanteIService implements IComprobanteIService {
    @Autowired
    private IComprobanteRepository comprobanteRepository;

    @Override
    public List<ComprobanteVo> getComprobante(Long id){
        List<Comprobante> comprobanteList = comprobanteRepository.selectComprobante(id);
        return ObjectMapper.mapAll(comprobanteList, ComprobanteVo.class);
    }

    @Override
    public List<ComprobanteVo> getAllComprobante() {
        List<Comprobante> comprobanteList = comprobanteRepository.selectAllComprobante();
        return ObjectMapper.mapAll(comprobanteList, ComprobanteVo.class);
    }

    @Override
    public Long postComprobante(ComprobanteVo comprobanteVo){
        ModelMapper modelMapper = new ModelMapper();
        Comprobante comprobante  = (Comprobante) modelMapper.map(comprobanteVo, (Class) Comprobante.class);
        comprobante.setFechaCreacion(LocalDateTime.now());
        comprobante.setFechaActualizacion(LocalDateTime.now());
        return comprobanteRepository.insertComprobante(comprobante);
    }

    @Override
    public Long putComprobante(ComprobanteVo comprobanteVo){
        ModelMapper modelMapper = new ModelMapper();
        Comprobante comprobante  = (Comprobante) modelMapper.map(comprobanteVo, (Class)Comprobante.class);
        comprobante.setFechaActualizacion(LocalDateTime.now());
        return comprobanteRepository.updateComprobante(comprobante);
    }

    @Override
    public Long deleteComprobante(Long id) {
        return comprobanteRepository.deleteComprobante(id);
    }
}
