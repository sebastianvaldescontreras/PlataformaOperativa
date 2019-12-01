package com.plataforma.infrastructure.repository;

import com.plataforma.domain.entities.Comprobante;

import java.util.List;

public interface IComprobanteRepository{
    List<Comprobante> selectComprobante(Long id);
    List<Comprobante> selectAllComprobante();
    Long insertComprobante(Comprobante comprobante);
    Long updateComprobante(Comprobante comprobante);
    Long deleteComprobante(Long id);
}
