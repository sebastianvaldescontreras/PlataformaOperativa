package com.plataforma.application.service.impl;

import com.plataforma.application.service.IComprobanteService;
import com.plataforma.application.vo.comprobante.ComprobanteVo;
import com.plataforma.infrastructure.service.IComprobanteIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ComprobanteService implements IComprobanteService{
    @Autowired
    private IComprobanteIService comprobanteIService;

    @Override
    public List<ComprobanteVo> getComprobante(Long id) {
        return comprobanteIService.getComprobante(id);
    }

    @Override
    public List<ComprobanteVo> getAllComprobante() {
        return comprobanteIService.getAllComprobante();
    }

    @Override
    public Long postComprobante(ComprobanteVo comprobanteVo) {
        return comprobanteIService.postComprobante(comprobanteVo);
    }

    @Override
    public Long putComprobante(ComprobanteVo comprobanteVo) {
        return comprobanteIService.putComprobante(comprobanteVo);
    }

    @Override
    public Long deleteComprobante(Long id) {
        return comprobanteIService.deleteComprobante(id);
    }
}
