package com.plataforma.application.service;

import com.plataforma.application.vo.comprobante.ComprobanteVo;
import java.util.List;

public interface IComprobanteService {
    List<ComprobanteVo> getComprobante(Long id);
    List<ComprobanteVo> getAllComprobante();
    Long postComprobante(ComprobanteVo comprobanteVo);
    Long putComprobante(ComprobanteVo comprobanteVo);
    Long deleteComprobante(Long id);
}
