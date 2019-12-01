package com.plataforma.infrastructure.service;

import com.plataforma.application.vo.comprobante.ComprobanteVo;
import java.util.List;

public interface IComprobanteIService{
    List<ComprobanteVo> getComprobante(Long id);
    List<ComprobanteVo> getAllComprobante();
    Long postComprobante(ComprobanteVo comprobanteVo);
    Long putComprobante(ComprobanteVo comprobanteVo);
    Long deleteComprobante(Long id);
}
